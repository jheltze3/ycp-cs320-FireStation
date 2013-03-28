package edu.ycp.CS320.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


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
	public int addFireApparatusToDB(FireApparatus fireApparatus) {
		fireApparatusList.add(fireApparatus);
		
		return fireApparatusList.size()-1;
	}

	public Map<Integer, User> getUsersFromDB() {		
		return userMap;
	}

	public List<ContactInfo> getContactsFromDB() {
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
	

	
	

}
