package edu.ycp.CS320.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.ycp.CS320.shared.ContactInfo;
import edu.ycp.CS320.shared.ContactInfoType;
import edu.ycp.CS320.shared.Equipment;
import edu.ycp.CS320.shared.EquipmentSpec;
import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireApparatusSpec;
import edu.ycp.CS320.shared.FireCalendar;
import edu.ycp.CS320.shared.FireCalendarEvent;
import edu.ycp.CS320.shared.Form;
import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.CS320.shared.User;
import edu.ycp.CS320.shared.UserWithContactInfo;

public class DerbyDatabase implements IDatabase {
	private static final String DATASTORE = "H:/firestation.db";

	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new RuntimeException("Could not load Derby JDBC driver");
		}
	}

	private class DatabaseConnection {
		public Connection conn;
		public int refCount;
	}

	private final ThreadLocal<DatabaseConnection> connHolder = new ThreadLocal<DatabaseConnection>();

	private DatabaseConnection getConnection() throws SQLException {
		DatabaseConnection dbConn = connHolder.get();
		if (dbConn == null) {
			dbConn = new DatabaseConnection();
			dbConn.conn = DriverManager.getConnection("jdbc:derby:" + DATASTORE + ";create=true");
			dbConn.refCount = 0;
			connHolder.set(dbConn);
		}
		dbConn.refCount++;
		return dbConn;
	}

	private void releaseConnection(DatabaseConnection dbConn) throws SQLException {
		dbConn.refCount--;
		if (dbConn.refCount == 0) {
			try {
				dbConn.conn.close();
			} finally {
				connHolder.set(null);
			}
		}
	}

	private<E> E databaseRun(ITransaction<E> transaction) {
		// FIXME: retry if transaction times out due to deadlock
		try {
			DatabaseConnection dbConn = getConnection();

			try {
				boolean origAutoCommit = dbConn.conn.getAutoCommit();
				try {
					dbConn.conn.setAutoCommit(false);

					return transaction.run(dbConn.conn);
				} finally {
					dbConn.conn.setAutoCommit(origAutoCommit);
				}
			} finally {
				releaseConnection(dbConn);
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException accessing database", e);
		}
	}

	void createTables() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run(Connection conn) throws SQLException {
				PreparedStatement stmtContacts = null;	
				PreparedStatement stmtEvents = null;
				PreparedStatement stmtEquipment = null;
				PreparedStatement stmtUsers = null;
				PreparedStatement stmtApparatusSpec = null;
				PreparedStatement stmtForms = null;
				try {
					stmtUsers = conn.prepareStatement(
							"create table users (" +
							"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
							"name VARCHAR(64) NOT NULL, " +
							"password VARCHAR(64) " +
							")"
													);
					stmtUsers.executeUpdate();
					
					stmtApparatusSpec = conn.prepareStatement(
							"create table fire_apparatus_spec (" +
							"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
							"make VARCHAR(64), " +
							"model VARCHAR(64), " +
							"name VARCHAR(64) NOT NULL, " +
							"model_year INTEGER, " +
							"type VARCHAR(64), " +
							"description VARCHAR(64)" +
							")"
															);
					stmtApparatusSpec.executeUpdate();		
					
					stmtContacts = conn.prepareStatement(
							"create table contact_info (" +
							"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
							"user_id INTEGER NOT NULL, " +
							"type VARCHAR(64), " +
							"home_phone_number VARCHAR(64), " +
							"cell_phone_number VARCHAR(64), " +
							"name VARCHAR(64)" +
							")"
														);
					stmtContacts.executeUpdate();
					
					stmtEvents = conn.prepareStatement(
							"create table fire_events ("  +
							"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
							"title VARCHAR(64), " +
							"location VARCHAR(64), " +
							"startTime VARCHAR(64), " +
							"endTime VARCHAR(64), " +
							"date VARCHAR(64), " +
							"description VARCHAR(64)" +
							")"
													  );
					stmtEvents.executeUpdate();
					
					stmtEquipment = conn.prepareStatement(
							"create table fire_equipment (" +
							"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
							"name VARCHAR(64), " +
							"amount INTEGER, " +
							"condition VARCHAR(64), " +
							"make VARCHAR(64), " +
							"model VARCHAR(64)" +
							")"
														);
					stmtEquipment.executeUpdate();

					stmtForms = conn.prepareStatement(
							"create table forms (" +
							"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
							"name VARCHAR(64), " +
							"address VARCHAR(64), " +
							"doctor VARCHAR(64), " +
							"doctorPhone VARCHAR(64)" +
							")"
													  );
					stmtForms.executeUpdate();								
				} finally {
					DBUtil.closeQuietly(stmtEquipment);
					DBUtil.closeQuietly(stmtUsers);
					DBUtil.closeQuietly(stmtEvents);
					DBUtil.closeQuietly(stmtContacts);
					DBUtil.closeQuietly(stmtApparatusSpec);
					DBUtil.closeQuietly(stmtForms);
				}				
				return true;
			}
		});
	}

	void dropTables() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run(Connection conn) throws SQLException {				
				PreparedStatement stmtDrop = null;
				try {					
					stmtDrop = conn.prepareStatement("DROP TABLE forms");
					stmtDrop.executeUpdate();					
				} finally {
					DBUtil.closeQuietly(stmtDrop);
				}				
				return true;
			}
		});
	}
	
	public void removeFireApparatus(final String name){
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run(Connection conn) throws SQLException {				
				PreparedStatement stmtRemoveFireApparatus = null;
				try {					
					stmtRemoveFireApparatus = conn.prepareStatement("DELETE FROM fire_apparatus_spec " +
							"WHERE name = ?"
							);
					stmtRemoveFireApparatus.setString(1, name);
					stmtRemoveFireApparatus.executeUpdate();					
				} finally {
					DBUtil.closeQuietly(stmtRemoveFireApparatus);
				}				
				return true;
			}
		});
	}
	@Override
	public Map<Integer, User> getUsersFromDB() {
		return databaseRun(new ITransaction<Map<Integer, User>>() {
			@Override
			public Map<Integer, User> run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					Map<Integer, User> result = new HashMap<Integer, User>();

					stmt = conn.prepareStatement("select users.id, users.name, users.password from users");

					resultSet = stmt.executeQuery();
					while (resultSet.next()) {
						User user = new User();
						loadUserFromResultSet(resultSet, user);
						result.put(user.getId(), user);
					}

					return result;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public ContactInfo addContactInfo(final ContactInfo contactInfo) {
		return databaseRun(new ITransaction<ContactInfo>() {
			@Override
			public ContactInfo run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet keys = null;

				try {
					stmt = conn.prepareStatement(
						"insert into contact_info(user_id, type, home_phone_number, cell_phone_number, name) values (?, ?, ?, ?, ?)",
						PreparedStatement.RETURN_GENERATED_KEYS
					);
					stmt.setInt(1, contactInfo.getUserId());
					ContactInfoType type = contactInfo.getType();
					stmt.setString(2, type.toString());
					stmt.setString(3, contactInfo.getHomePhoneNumber());
					stmt.setString(4, contactInfo.getCellPhoneNumber());
					stmt.setString(5, contactInfo.getName());
					// TODO: other fields

					stmt.executeUpdate();

					keys = stmt.getGeneratedKeys();
					if (!keys.next()) {
						throw new SQLException("Couldn't get generated key for contact info");
					}
					contactInfo.setId(keys.getInt(1));

					return contactInfo;
				} finally {
					DBUtil.closeQuietly(keys);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public void addUserToDB(final User user) {

		databaseRun(new ITransaction<Boolean>() {

			PreparedStatement stmt = null;
			ResultSet keys = null;

			@Override
			public Boolean run(Connection conn) throws SQLException {
				try{

				stmt = conn.prepareStatement("INSERT INTO users (name, password)" +
											 "VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);			

				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getPassword());

				stmt.executeUpdate();

				keys = stmt.getGeneratedKeys();
				if (!keys.next()) {
					throw new SQLException("Couldn't get generated key");
				}
				user.setId(keys.getInt(1));

				return null;

				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(keys);
				}
			}	
		});		
	}
	
	@Override
	public ArrayList<UserWithContactInfo> getContactsFromDB() {
		// TODO Auto-generated method stub
		return databaseRun(new ITransaction<ArrayList<UserWithContactInfo>>() {			
			@Override
			public ArrayList<UserWithContactInfo> run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					ArrayList<UserWithContactInfo> result = new ArrayList<UserWithContactInfo>();

					stmt = conn.prepareStatement("select users.*, contact_info.* from users, contact_info where users.id = contact_info.user_id");
					resultSet = stmt.executeQuery();

					while (resultSet.next()) {	
						User user = new User();
						ContactInfo contactInfo = new ContactInfo();

						user.setId(resultSet.getInt(1));
						user.setUsername(resultSet.getString(2));
						user.setPassword("***");

						contactInfo.setId(resultSet.getInt(4));
						// etc.
						contactInfo.setUserId(resultSet.getInt(5));
						ContactInfoType type = ContactInfoType.valueOf(resultSet.getString(6));
						contactInfo.setHomephoneNumber(resultSet.getString(7));
						contactInfo.setCellphoneNumber(resultSet.getString(8));
						contactInfo.setName(resultSet.getString(9));

						UserWithContactInfo userWithContactInfo = new UserWithContactInfo();
						userWithContactInfo.setUser(user);
						userWithContactInfo.setContactInfo(contactInfo);
						result.add(userWithContactInfo);						
					}					
					return result;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	// created by Drew, Modified by Jake
		public int addFireCalendarEventToDB( final FireCalendar fireCalendarEvent) {
			databaseRun(new ITransaction<Boolean>() {
				PreparedStatement stmt = null;
				ResultSet keys = null;
				@Override
				public Boolean run(Connection conn) throws SQLException {
					try{
						stmt = conn.prepareStatement("INSERT INTO fire_events (title, location, startTime,endTime, date, description)" +
								 "VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);	


						stmt.setString(1,fireCalendarEvent.getFireFireEvent().getTitle());
						stmt.setString(2,fireCalendarEvent.getFireFireEvent().getLocation());
						stmt.setString(3,fireCalendarEvent.getFireFireEvent().getStartTime());
						stmt.setString(4,fireCalendarEvent.getFireFireEvent().getEndTime());
						stmt.setString(5,fireCalendarEvent.getFireFireEvent().getDate());
						stmt.setString(6,fireCalendarEvent.getFireFireEvent().getDescription());




						stmt.executeUpdate();
						keys = stmt.getGeneratedKeys();

						if(!keys.next()){
							throw new SQLException("Couldn't get generated key");
						}

						fireCalendarEvent.getFireFireEvent().setId(keys.getInt(1));
					} finally {
						DBUtil.closeQuietly(stmt);
						DBUtil.closeQuietly(keys);
					}
					return null;
				}
			});
			return 0;
		}	
		/*public void dropCalendarTables() throws SQLException {
			databaseRun(new ITransaction<Boolean>() {
				@Override
				public Boolean run(Connection conn) throws SQLException {				
					PreparedStatement stmtDrop = null;
					try {					
						stmtDrop = conn.prepareStatement("DROP TABLE fire_events");
						stmtDrop.executeUpdate();					
					} finally {
						DBUtil.closeQuietly(stmtDrop);
					}				
					return true;
				}
			});
		}*/
		void createEventTable() throws SQLException {
			databaseRun(new ITransaction<Boolean>() {
				@Override
				public Boolean run(Connection conn) throws SQLException {

					PreparedStatement stmtEvents = null;

					try {


						stmtEvents = conn.prepareStatement(
								"create table fire_events ("  +
								"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
								"title VARCHAR(64), " +
								"location VARCHAR(64), " +
								"startTime VARCHAR(64), " +
								"endTime VARCHAR(64), " +
								"date VARCHAR(64), " +
								"description VARCHAR(64)" +
								")"
								  			);
						stmtEvents.executeUpdate();

					} finally {

						DBUtil.closeQuietly(stmtEvents);

					}				
					return true;
				}
			});
	}

		// created by Drew, Modified by Jake
		@Override
		public ArrayList<FireCalendar> getFireEventFromDB() {
			return databaseRun(new ITransaction<ArrayList<FireCalendar>>() {			
				@Override
				public ArrayList<FireCalendar> run(Connection conn) throws SQLException {
					PreparedStatement stmt = null;
					ResultSet resultSet = null;

					try {
						ArrayList<FireCalendar> result = new ArrayList<FireCalendar>();

						stmt = conn.prepareStatement("select * from fire_events");

						resultSet = stmt.executeQuery();

						while (resultSet.next()) {	
							result.add(new FireCalendar( new FireCalendarEvent(
									resultSet.getInt(1), 
															 resultSet.getString(2),
															 resultSet.getString(3),
															 resultSet.getString(4),
															 resultSet.getString(5),
															 resultSet.getString(6),
															 resultSet.getString(7))));
						}					



						return result;
					} finally {
						DBUtil.closeQuietly(stmt);
					}
				}
			});
		}

		public void removeFireCalendarEvent(final int ids){
			databaseRun(new ITransaction<Boolean>() {
				@Override
				public Boolean run(Connection conn) throws SQLException {				
					PreparedStatement stmtFireCalenderEvent = null;

					try {					
						stmtFireCalenderEvent = conn.prepareStatement("DELETE FROM fire_events " +
								"WHERE id = ?"
								);
						stmtFireCalenderEvent.setInt(1, ids);

						stmtFireCalenderEvent.executeUpdate();					
					} finally {
						DBUtil.closeQuietly(stmtFireCalenderEvent);
					}				
					return true;
				}
			});
		}

	
	
	
	
	

	private void loadUserFromResultSet(ResultSet resultSet, User user)
			throws SQLException {
		user.setId(resultSet.getInt(1));
		user.setUsername(resultSet.getString(2));
		user.setPassword(resultSet.getString(3));
	}

	@Override
	public int addFireApparatusToDB(final FireApparatus fireApparatus) {
			databaseRun(new ITransaction<Boolean>() {

			PreparedStatement stmt = null;
			ResultSet keys = null;

			@Override
			public Boolean run(Connection conn) throws SQLException {
				try{

				stmt = conn.prepareStatement("INSERT INTO fire_apparatus_spec (make, model, name, model_year, type, description)" +
											 "VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);			

				stmt.setString(1, fireApparatus.getFireApparatusSpec().getMake());
				stmt.setString(2, fireApparatus.getFireApparatusSpec().getModel());
				stmt.setString(3, fireApparatus.getFireApparatusSpec().getName());
				stmt.setInt(4, fireApparatus.getFireApparatusSpec().getYear());
				stmt.setString(5, fireApparatus.getFireApparatusSpec().getType());
				stmt.setString(6,  fireApparatus.getFireApparatusSpec().getDescription());
			

				stmt.executeUpdate();

				keys = stmt.getGeneratedKeys();
				if (!keys.next()) {
					throw new SQLException("Couldn't get generated key");
				}

				fireApparatus.getFireApparatusSpec().setId(keys.getInt(1));

				return null;

				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(keys);
				}
			}	
		});			

			return 0;
	}

	@Override
	public void addEquipmentToDB(final Equipment equipment) {
		databaseRun(new ITransaction<Boolean>() {

			PreparedStatement stmt = null;
			ResultSet keys = null;

			@Override
			public Boolean run(Connection conn) throws SQLException {
				try{
					stmt = conn.prepareStatement("INSERT INTO fire_equipment(name, amount, condition, make, model)" +
												"VALUES(?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

					stmt.setString(1, equipment.getName());
					stmt.setInt(2, equipment.getPrice());
					stmt.setString(3, equipment.getCondition());
					stmt.setString(4, equipment.getSpec().getMake());
					stmt.setString(5, equipment.getSpec().getModel());

					stmt.executeUpdate();

					keys = stmt.getGeneratedKeys();

					if(!keys.next()){
						throw new SQLException("Couldn't get generated key");
					}

					equipment.setId(keys.getInt(1));
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(keys);
				}
				return null;
			}
		});

	}

	@Override
	public ArrayList<FireApparatus> getFireApparatusFromDB() {
		return databaseRun(new ITransaction<ArrayList<FireApparatus>>() {			
			@Override
			public ArrayList<FireApparatus> run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					ArrayList<FireApparatus> result = new ArrayList<FireApparatus>();

					stmt = conn.prepareStatement("select " +
							"fire_apparatus_spec.make, " +
							"fire_apparatus_spec.model, " +
							"fire_apparatus_spec.name, " +
							"fire_apparatus_spec.model_year, " +
							"fire_apparatus_spec.type, " +
							"fire_apparatus_spec.description from fire_apparatus_spec");

					resultSet = stmt.executeQuery();
					while (resultSet.next()) {	
						result.add(new FireApparatus(null, new FireApparatusSpec(
								resultSet.getString(1), 
								resultSet.getString(2), 
								resultSet.getString(3), 
								resultSet.getInt(4), 
								resultSet.getString(5), 
								resultSet.getString(6)
								)));						
					}					
					return result;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

//	@Override
//	public ArrayList<ContactInfo> getContactsFromDB() {
//		return databaseRun(new ITransaction<ArrayList<ContactInfo>>() {
//
//			@Override
//			public ArrayList<ContactInfo> run(Connection conn) throws SQLException {
//
//				PreparedStatement stmt = null;
//				ResultSet resultSet = null;
//
//				try{
//					ArrayList <ContactInfo> result = new ArrayList <ContactInfo>();
//
//					stmt = conn.prepareStatement("select " +
//												"contact_info.id, " +
//												"contact_info.home_phone_number, " +
//												"contact_info.cell_phone_number, " +
//												"contact_info.name");
//
//					resultSet = stmt.executeQuery();
//
//					while(resultSet.next()){
//						result.add(new ContactInfo(resultSet.getInt(1),												   
//												   resultSet.getString(2),
//												   resultSet.getString(3),
//												   resultSet.getString(4)
//												   ));
//					}
//					return result;
//				} finally {
//					DBUtil.closeQuietly(stmt);
//				}
//
//			}
//		});
//
//	}

	@Override
	public ArrayList<Equipment> getEquipmentFromDB() {
		return databaseRun(new ITransaction<ArrayList<Equipment>>() {

			@Override
			public ArrayList<Equipment> run(Connection conn) throws SQLException {

				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try{
					ArrayList <Equipment> result = new ArrayList <Equipment>();

					stmt = conn.prepareStatement("select " +
												"equipment.id, " +
												"equipment.name, " +
												"equipment.amount, " +
												"equipment.condition, " +
												"equipment.make, " +
												"equipment.model");

					resultSet = stmt.executeQuery();

					while(resultSet.next()){
						result.add(new Equipment(resultSet.getInt(1),
												 resultSet.getString(2),
												 resultSet.getInt(3),
												 resultSet.getString(4),
												 new EquipmentSpec(resultSet.getString(5),
														 		   resultSet.getString(6))));
					}
					return result;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public ArrayList<Form> getFormsFromDB() {
		return databaseRun(new ITransaction<ArrayList<Form>>() {			
			@Override
			public ArrayList<Form> run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					ArrayList<Form> result = new ArrayList<Form>();

					stmt = conn.prepareStatement("select " +
												 "forms.id, " +
												 "forms.name, " +
												 "forms.address, " +
												 "forms.doctor, " +
												 "forms.doctorPhone");

					resultSet = stmt.executeQuery();

					while (resultSet.next()) {	
						result.add(new Form(resultSet.getInt(1), 
											resultSet.getString(2),
											resultSet.getString(3), 
											resultSet.getString(4), 
											resultSet.getString(5)));
					}					



					return result;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}

	@Override
	public void addFormsToDB(final Form form) {
		databaseRun(new ITransaction<Boolean>() {

			PreparedStatement stmt = null;
			ResultSet keys = null;

			@Override
			public Boolean run(Connection conn) throws SQLException {
				try{
					stmt = conn.prepareStatement("INSERT INTO forms(name, address, doctor, doctorPhone)" +
												"VALUES(?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

					stmt.setString(1, form.getName());
					stmt.setString(2, form.getAddress());
					stmt.setString(3, form.getDoctor());
					stmt.setString(4, form.getDoctorPhone());					

					stmt.executeUpdate();

					keys = stmt.getGeneratedKeys();

					if(!keys.next()){
						throw new SQLException("Couldn't get generated key");
					}

					form.setId(keys.getInt(1));
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(keys);
				}
				return null;
			}
		});
		
	}

	@Override
	public void addContactToDB() {
		// TODO Auto-generated method stub
		
	}
	
	//
//	
//// created by Drew, Modified by Jake
//	public int addFireCalendarEventToDB( final FireCalendar fireCalendarEvent) {
//		databaseRun(new ITransaction<Boolean>() {
//			PreparedStatement stmt = null;
//			ResultSet keys = null;
//			@Override
//			public Boolean run(Connection conn) throws SQLException {
//				try{
//					stmt = conn.prepareStatement("INSERT INTO fire_events (title, location, startTime,endTime, date, description)" +
//							 "VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);	
//
//				
//					stmt.setString(1,fireCalendarEvent.getFireFireEvent().getTitle());
//					stmt.setString(2,fireCalendarEvent.getFireFireEvent().getLocation());
//					stmt.setString(3,fireCalendarEvent.getFireFireEvent().getStartTime());
//					stmt.setString(4,fireCalendarEvent.getFireFireEvent().getEndTime());
//					stmt.setString(5,fireCalendarEvent.getFireFireEvent().getDate());
//					stmt.setString(6,fireCalendarEvent.getFireFireEvent().getDescription());
//		
//		
//
//					stmt.executeUpdate();
//					keys = stmt.getGeneratedKeys();
//
//					if(!keys.next()){
//						throw new SQLException("Couldn't get generated key");
//					}
//
//					fireCalendarEvent.getFireFireEvent().setId(keys.getInt(1));
//				} finally {
//					DBUtil.closeQuietly(stmt);
//					DBUtil.closeQuietly(keys);
//				}
//				return null;
//			}
//		});
//		return 0;
//	}	
//	
//	// created by Drew, Modified by Jake
//	@Override
//	public ArrayList<FireCalendar> getFireEventFromDB() {
//		return databaseRun(new ITransaction<ArrayList<FireCalendar>>() {			
//			@Override
//			public ArrayList<FireCalendar> run(Connection conn) throws SQLException {
//				PreparedStatement stmt = null;
//				ResultSet resultSet = null;
//
//				try {
//					ArrayList<FireCalendar> result = new ArrayList<FireCalendar>();
//
//					stmt = conn.prepareStatement("select * from fire_events");
//
//					resultSet = stmt.executeQuery();
//
//					while (resultSet.next()) {	
//						result.add(new FireCalendar( new FireCalendarEvent(
//								resultSet.getInt(1), 
//														 resultSet.getString(2),
//														 resultSet.getString(3),
//														 resultSet.getString(4),
//														 resultSet.getString(5),
//														 resultSet.getString(6),
//														 resultSet.getString(7))));
//					}					
//
//
//
//					return result;
//				} finally {
//					DBUtil.closeQuietly(stmt);
//				}
//			}
//		});
//	}

	
	
}
