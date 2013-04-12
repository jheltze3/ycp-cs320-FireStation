package edu.ycp.CS320.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author dho7
 * interface for the controller classes to implement. The methods can be defined in the 
 * actual controller classes then after they implement this interface.
 *
 */
public interface IDatabase {
	public void addToDB();
	public String getFromDB();
	public Map<Integer, User> getUsersFromDB();
	
	/*
	public User findUser(String username, String password);
	 */
	
	public void addEquipmentToDB();
	public void addContactToDB();
	public void addUserToDB(User user);
	public List<ContactInfo> getContactsFromDB();
	public List<Equipment> getEquipmentFromDB();
	public ArrayList<FireApparatus> getFireApparatusFromDB();
	public int addFireApparatusToDB(FireApparatus fireApparatus);
	
	public ArrayList<FireCalendar> getFireEventFromDB();
	public int addFireCalendarEventToDB(FireCalendar fireCalendar);
}
