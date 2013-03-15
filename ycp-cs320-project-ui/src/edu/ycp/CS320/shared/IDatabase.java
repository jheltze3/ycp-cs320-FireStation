package edu.ycp.CS320.shared;

import java.util.List;

import edu.ycp.CS320.shared.User;


/**
 * @author dho7
 * interface for the controller classes to implement. The methods can be defined in the 
 * actual controller classes then after they implement this interface.
 *
 */
public interface IDatabase {
	public void addUserToDatabase(User user);
	public void addContactToDatabase();
	public void addEquipmentToDatabase();
	public List <User> getUsersFromDatabase();
	public List <ContactInfo> getContactsFromDatabase();
	public List <Equipment> getEquipmentFromDatabase();
	
}
