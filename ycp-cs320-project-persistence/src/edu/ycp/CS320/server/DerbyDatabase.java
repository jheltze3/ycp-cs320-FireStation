package edu.ycp.CS320.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.ycp.CS320.shared.ContactInfo;
import edu.ycp.CS320.shared.Equipment;
import edu.ycp.CS320.shared.Events;
import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireApparatusSpec;
import edu.ycp.CS320.shared.FireCalendar;
import edu.ycp.CS320.shared.FireCalendarEvent;
import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.CS320.shared.User;

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

//				PreparedStatement stmtUsers = null;
				PreparedStatement stmtApparatusSpec = null;
				try {
//					stmtUsers = conn.prepareStatement(
//							"create table users (" +
//							"id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
//							"name VARCHAR(64) NOT NULL, " +
//							"password VARCHAR(64) " +
//							")"

//													);

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


				} finally {
					DBUtil.closeQuietly(stmtApparatusSpec);
				}				
				return true;
			}
		});
	}

	void dropTables() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run(Connection conn) throws SQLException {				
				PreparedStatement stmtDropApparatus = null;
				try {					
					stmtDropApparatus = conn.prepareStatement("DROP TABLE fire_apparatus_spec");
					stmtDropApparatus.executeUpdate();					
				} finally {
					DBUtil.closeQuietly(stmtDropApparatus);
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
	public void addEquipmentToDB() {
		// TODO Auto-generated method stub

	}
	@Override
	public void addContactToDB() {
		// TODO Auto-generated method stub		
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
	public ArrayList<ContactInfo> getContactsFromDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipment> getEquipmentFromDB() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int addFireCalendarEventToDB(FireCalendar fireCalendar) {
		// TODO Auto-generated method stub
		return 0;
	}	

	@Override
	public ArrayList<FireCalendar> getFireEventFromDB() {
		// TODO Auto-generated method stub
		return null;
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
	
	

	@Override
	public List<FireCalendar> getEventsFromDB() {
		return databaseRun(new ITransaction<ArrayList<FireCalendar>>() {			
			@Override
			public ArrayList<FireCalendar> run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					ArrayList<FireCalendar> result = new ArrayList<FireCalendar>();

					stmt = conn.prepareStatement("select " +
							"fire_calendar.title, " +
							"fire_calendar.location, " +
							"fire_calendar.StartTime, " +
							"fire_calendar.EndTime, " +
							"fire_calendar.description from fire_calendar" + 
							"fire_calendar.date "
							);

					resultSet = stmt.executeQuery();
					while (resultSet.next()) {	
						result.add(new FireCalendar(new FireCalendarEvent(
								resultSet.getString(1), 
								resultSet.getString(2), 
								resultSet.getString(3), 
								resultSet.getString(4), 
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

	public int addFireCalendarEventToDB(FireCalendarEvent fireCalendar) {
		// TODO Auto-generated method stub
		return 0;
	}

}