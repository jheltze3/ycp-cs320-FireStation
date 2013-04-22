
package edu.ycp.cs320.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireCalendar;
import edu.ycp.CS320.shared.IDatabase;




import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireCalendar;
import edu.ycp.CS320.shared.IDatabase;

public class GetCalendarController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<FireCalendar> getEvent(IDatabase db){
		
		FireCalendar fireCalendar = new FireCalendar();
		fireCalendar.getFireCalendarSpec().setTitle("FOCE TEST");		
		fireCalendar.getFireCalendarSpec().setDescription("A terrible test that invloves alot of work");
		fireCalendar.getFireCalendarSpec().setStartTime("11:00 A.M");
		fireCalendar.getFireCalendarSpec().setEndtime("12:15 PM");
		fireCalendar.getFireCalendarSpec().setLocation("KEC ROOM");
		fireCalendar.getFireCalendarSpec().setDate("4/18/2013");
		
		db.addFireCalendarEventToDB(fireCalendar);
		
		for(int i=0; i<4; i++){
			FireCalendar fireCalendar1 = new FireCalendar();
			fireCalendar1.getFireCalendarSpec().setTitle("FOCE TEST");		
			fireCalendar1.getFireCalendarSpec().setDescription("A terrible test that invloves alot of work");
			fireCalendar1.getFireCalendarSpec().setStartTime("11:00 A.M");
			fireCalendar1.getFireCalendarSpec().setEndtime("12:15 PM");
			fireCalendar1.getFireCalendarSpec().setLocation("KEC ROOM");
			fireCalendar1.getFireCalendarSpec().setDate("4/18/2013");
			db.addFireCalendarEventToDB(fireCalendar1);
		}
		
		return db.getFireEventFromDB();
	}
}

