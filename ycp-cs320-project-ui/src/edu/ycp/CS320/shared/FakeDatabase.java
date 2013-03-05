package edu.ycp.CS320.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.list.TreeList;

import edu.ycp.CS320.common.ContactInfo;
import edu.ycp.CS320.common.ContactInfoType;
import edu.ycp.CS320.equipment.Equipment;
import edu.ycp.CS320.shared.IDatabase;

/**
 * @author jheltze3
 *
 */
public class FakeDatabase implements IDatabase {
	// map of user ids to users
	Map<Integer, User> userMap;
	List <User > userList = new TreeList();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEquipmentToDatabase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUsersFromDatabase() {
		
		return userList;
	}

	@Override
	public List<ContactInfo> getContactsFromDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipment> getEquipmentFromDatabase() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

}
