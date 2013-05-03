package edu.ycp.CS320.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.ycp.CS320.shared.ContactInfo;
import edu.ycp.CS320.shared.ContactInfoType;
import edu.ycp.CS320.shared.Equipment;
import edu.ycp.CS320.shared.Events;
import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireApparatusSpec;
import edu.ycp.CS320.shared.FireCalendar;
import edu.ycp.CS320.shared.FireCalendarEvent;
import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.CS320.shared.User;


public class FakeDatabase implements IDatabase, Serializable {
	private static final long serialVersionUID = 1L;	
	
	private Map<Integer, User> userMap; // map of user ids to users
	private List <User> userList;
	private Map<Integer, List<ContactInfo>> contactInfoMap; // map of user ids to lists of ContactInfo for the user
	private ArrayList<FireApparatus> fireApparatusList;
	
	public FakeDatabase() {
		userMap = new TreeMap<Integer, User>();
		contactInfoMap = new TreeMap<Integer, List<ContactInfo>>();
		userList = new 	ArrayList<User>();
		fireApparatusList = new ArrayList<FireApparatus>();
		
		User user = new User();
		user.setId(-1);
		user.setUsername("Dinky");
		user.setPassword("tree");
		userMap.put(user.getId(), user);
		
		ContactInfo userHomeContactInfo= new ContactInfo();
		userHomeContactInfo.setType(ContactInfoType.HOME);
		userHomeContactInfo.setUserId(user.getId());
		userHomeContactInfo.setCellphoneNumber("555-666-7787");
		contactInfoMap.put(user.getId(), new ArrayList<ContactInfo>());
		contactInfoMap.get(user.getId()).add(userHomeContactInfo);
		
		//Add fire apparatus to database
		FireApparatus fireApparatus = new FireApparatus();
		fireApparatus.getFireApparatusSpec().setName("Engine 62-1");		
		fireApparatus.getFireApparatusSpec().setDescription("A Fire Engine");
		fireApparatus.getFireApparatusSpec().setMake("Pierce");
		fireApparatus.getFireApparatusSpec().setModel("Arrow XT PUC");
		fireApparatus.getFireApparatusSpec().setYear(2009);
		fireApparatus.getFireApparatusSpec().setType("Pumper-Rescue");
		addFireApparatusToDBOld(fireApparatus);
		
		for(int i=0; i<4; i++){
			FireApparatus fireApparatus_1 = new FireApparatus();
			fireApparatus_1.getFireApparatusSpec().setName("Engine "+Integer.toString(i));			
			fireApparatus_1.getFireApparatusSpec().setDescription("A Fire Engine");
			fireApparatus_1.getFireApparatusSpec().setMake("Pierce");
			fireApparatus_1.getFireApparatusSpec().setModel("Arrow XT PUC");
			fireApparatus_1.getFireApparatusSpec().setYear(2009);
			fireApparatus_1.getFireApparatusSpec().setType("Pumper-Rescue");
			addFireApparatusToDBOld(fireApparatus_1);
		}		
	}

	/**
	 * 
	 * TODO: implement adding to database via LoginServiceImpl and define methods
	 */
	public void addUserToDB(User user) {
		userList.add(user);
		
	}

	public void addContactToDB() {
		
	}

	public void addEquipmentToDB() {
		
	}

	/**
	 * 
	 * @param fireApparatus
	 * @return The number of FireApparatus objects in the list
	 */
	public int addFireApparatusToDBOld(FireApparatus fireApparatus) {
		fireApparatusList.add(fireApparatus);
		
		return fireApparatusList.size()-1;
	}

	public Map<Integer, User> getUsersFromDB() {		
		return userMap;
	}

	public ArrayList<ContactInfo> getContactsFromDB() {
		return null;
	}

	public List<Equipment> getEquipmentFromDB() {
		return null;
	}

	public void addToDB() {
		
	}

	public String getFromDB() {
		return null;
	}

	public ArrayList<FireApparatus> getFireApparatusFromDB() {
		return fireApparatusList;
	}

	@Override
	public int addFireApparatusToDB(FireApparatus fireApparatus) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addEquipmentToDB(Equipment equipment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addContactToDB(ContactInfo contactInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addFireCalendarEventToDB(FireCalendarEvent fireCalendarEvent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<FireCalendarEvent> getFireEventFromDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeFireApparatus(String name) {
		// TODO Auto-generated method stub
		
	}
}
