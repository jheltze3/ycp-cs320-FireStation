package edu.ycp.CS320.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.CS320.shared.User;

/**
 * @author jheltze3
 *
 */
public class FakeDatabase implements IDatabase, Serializable {
	private static final long serialVersionUID = 1L;
	// map of user ids to users
	Map<Integer, User> userMap;
	List <User > userList = new ArrayList<User>();
	// map of user ids to lists of ContactInfo for the user
	Map<Integer, List<ContactInfo>> contactInfoMap;

	public FakeDatabase() {
		userMap = new TreeMap<Integer, User>();
		contactInfoMap = new TreeMap<Integer, List<ContactInfo>>();
		
		
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
	public void addUserToDatabase(User user) {
		userList.add(user);
	}

	@Override
	public void addContactToDatabase() {
	}

	@Override
	public void addEquipmentToDatabase() {
	}

	@Override
	public List<User> getUsersFromDatabase() {
		return userList;
	}

	@Override
	public List<ContactInfo> getContactsFromDatabase() {
		return null;
	}

	@Override
	public List<Equipment> getEquipmentFromDatabase() {
		return null;
	}
	

	
	

}
