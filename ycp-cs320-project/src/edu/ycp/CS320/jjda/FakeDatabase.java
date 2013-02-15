/**
 * 
 */
package edu.ycp.CS320.jjda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jheltze3
 *
 */
public class FakeDatabase implements IDatabase {
	// map of user ids to users
	Map<Integer, User> userMap;
	
	// map of user ids to lists of ContactInfo for the user
	Map<Integer, List<ContactInfo>> contactInfoMap;

	public FakeDatabase() {
		userMap = new TreeMap<Integer, User>();
		contactInfoMap = new TreeMap<Integer, List<ContactInfo>>();
		
		User user = new User(1, "josh", "abc123");
		userMap.put(user.getId(), user);
		
		ContactInfo userHomeContactInfo= new ContactInfo();
		userHomeContactInfo.setType(ContactInfoType.HOME);
		userHomeContactInfo.setUserId(user.getId());
		userHomeContactInfo.setPhoneNumber("555-666-7787");
		contactInfoMap.put(user.getId(), new ArrayList<ContactInfo>());
		contactInfoMap.get(user.getId()).add(userHomeContactInfo);
		
	}
	
	@Override
	public void addToDatabase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFromDatabase() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
