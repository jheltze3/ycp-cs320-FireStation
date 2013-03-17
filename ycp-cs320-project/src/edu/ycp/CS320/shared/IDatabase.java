package edu.ycp.CS320.shared;

import java.util.List;


/**
 * @author dho7
 * interface for the controller classes to implement. The methods can be defined in the 
 * actual controller classes then after they implement this interface.
 *
 */
public interface IDatabase {
	public void addToDB();
	public String getFromDB();
	public List<User> getUsersFromDB();
	public void addEquipmentToDB();
	public void addContactToDB();
	public void addUserToDB(User user);
	public List<ContactInfo> getContactsFromDB();
	public List<Equipment> getEquipmentFromDB();
}
