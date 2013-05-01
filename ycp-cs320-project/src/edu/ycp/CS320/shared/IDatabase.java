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
	
	public Map<Integer, User> getUsersFromDB();		
	public void addEquipmentToDB();		
	public void addContactToDB();
	public void addUserToDB(User user);		
	public int addFireApparatusToDB(FireApparatus fireApparatus);	
	public int addFireCalendarEventToDB(FireCalendar fireCalendar);
	public ArrayList<ContactInfo> getContactsFromDB();	
	public List<Equipment> getEquipmentFromDB();	
	public ArrayList<FireApparatus> getFireApparatusFromDB();	
	public ArrayList<FireCalendar> getFireEventFromDB();
	public void removeFireApparatus(final String name);
}
