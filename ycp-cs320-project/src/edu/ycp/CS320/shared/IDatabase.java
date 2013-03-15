package edu.ycp.CS320.shared;

import java.util.List;


/**
 * @author dho7
 * interface for the controller classes to implement. The methods can be defined in the 
 * actual controller classes then after they implement this interface.
 *
 */
public interface IDatabase {
	public void addToDatabase();
	public String getFromDatabase();
	List<User> getUsersFromDatabase();
	void addEquipmentToDatabase();
	void addContactToDatabase();
	void addUserToDatabase(User user);
	List<ContactInfo> getContactsFromDatabase();
	List<Equipment> getEquipmentFromDatabase();
}
