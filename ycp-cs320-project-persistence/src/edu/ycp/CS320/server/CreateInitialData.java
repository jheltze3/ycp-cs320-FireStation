package edu.ycp.CS320.server;

import java.sql.SQLException;

import edu.ycp.CS320.shared.ContactInfo;
import edu.ycp.CS320.shared.ContactInfoType;
import edu.ycp.CS320.shared.Events;
import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireApparatusSpec;
import edu.ycp.CS320.shared.FireCalendar;
import edu.ycp.CS320.shared.FireCalendarEvent;

import edu.ycp.CS320.shared.User;

public class CreateInitialData {

	private static ContactInfoType HOME;

	public static void main(String[] args) throws SQLException {
		DerbyDatabase db = new DerbyDatabase();			

//		app1.setFireApparatusSpec(spec1); TODO: implement addFireApparatus derby method

//		FireCalendar fireApparatus = new FireApparatus(null, new FireApparatusSpec("Pierce", "Arrow XTC PUC", "Engine 62-1", 2009, "Pumper", "This is the first out engine to fire calls"));		
//		db.addFireApparatusToDB(fireApparatus);

//		FireApparatus fireApparatus = new FireApparatus(null, new FireApparatusSpec("Pierce", "Arrow XTC PUC", "Engine 62-1", 2009, "Pumper", "This is the first out engine to fire calls"));		
//		db.addFireApparatusToDB(fireApparatus);
// 		THIS IS FOR THE CALENDAR
//		FireCalendar firecalendar = new FireCalendar(new FireCalendarEvent(0, "TITLE", "LOCATION", "STARTTIME", "ENDTIME", "DATE", "NOTES"));		
//		db.addFireCalendarEventToDB(firecalendar);

	//	FireCalendar fireApparatus = new FireApparatus(null, new FireApparatusSpec("Pierce", "Arrow XTC PUC", "Engine 62-1", 2009, "Pumper", "This is the first out engine to fire calls"));		
		//db.addFireApparatusToDB(fireApparatus);

		//FireApparatus fireApparatus = new FireApparatus(null, new FireApparatusSpec("Pierce", "Arrow XTC PUC", "Engine 62-1", 2009, "Pumper", "This is the first out engine to fire calls"));		
		//db.addFireApparatusToDB(fireApparatus);
		
		// THIS IS FOR THE CALENDAR
		//FireCalendar firecalendar = new FireCalendar(new FireCalendarEvent(0, "TITLE", "LOCATION", "STARTTIME", "ENDTIME", "DATE", "NOTES"));		
		//db.addFireCalendarEventToDB(firecalendar);

//		FireApparatus fireApparatus = new FireApparatus(new FireApparatusSpec("Pierce", "Arrow XTC PUC", "Engine 62-1", 2009, "Pumper", "This is the first out engine to fire calls"));		
//		db.addFireApparatusToDB(fireApparatus);
//		
//		fireApparatus = new FireApparatus(new FireApparatusSpec("Pierce", "Arrow XTC PUC", "Rescue 62", 2013, "Rescue", "This is the new rescue unit on order."));		
//		db.addFireApparatusToDB(fireApparatus);
//		
//		fireApparatus = new FireApparatus(new FireApparatusSpec("American Le France", "Unknown", "Engine 62-5", 2002, "Tanker", "This pumper-tanker supplies water at a fire scene"));		
//		db.addFireApparatusToDB(fireApparatus);

//		fireApparatus = new FireApparatus(null, new FireApparatusSpec("Pierce", "Arrow XTC PUC", "Rescue 62", 2013, "Rescue", "This is the new rescue unit on order."));		
//		db.addFireApparatusToDB(fireApparatus);

		//fireApparatus = new FireApparatus(null, new FireApparatusSpec("Pierce", "Arrow XTC PUC", "Rescue 62", 2013, "Rescue", "This is the new rescue unit on order."));		
		//db.addFireApparatusToDB(fireApparatus);
		
	//	Events event = new Events();
		//event.setCondition("graduated");
		//event.setName("party");
	//	event.setPrice(50);


		//fireApparatus = new FireApparatus(null, new FireApparatusSpec("American Le France", "Unknown", "Engine 62-5", 2002, "Tanker", "This pumper-tanker supplies water at a fire scene"));		
		//db.addFireApparatusToDB(fireApparatus);

	/*	ContactInfo contact = new ContactInfo();
		contact.setCellphoneNumber("0-000-0000");
		contact.setHomephoneNumber("9-999-9999");
		contact.setName("fake");	
		contact.setType(HOME);
		
		FireCalendarEvent event = new FireCalendarEvent();
		event.setTitle("practice");
		
		FireCalendar fireCalendar = new FireCalendar(event);
		fireCalendar.setFireCalendarEvent(event);
		
		db.addContactToDB(contact);*/
		//db.addFireCalendarEventToDB(event);
		
		
		//add contact/event to DB

		User alana = new User(-1, "alana", "pw");
		db.addUserToDB(alana);
		
		Events event = new Events();
		event.setCondition("graduated");
		event.setName("party");
		event.setPrice(50);

		ContactInfo contact = new ContactInfo();
		contact.setType(ContactInfoType.HOME);
		contact.setUserId(alana.getId());
		contact.setCellphoneNumber("0-000-0000");
		contact.setHomephoneNumber("9-999-9999");
		contact.setName("Alana");	
		//contact.setType(HOME);
		db.addContactInfo(contact);

		System.out.println("Successfully created initial data");
	}

}
