package edu.ycp.cs320.controllers;

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
		fireCalendar.getFireCalendarSpec().setName("Engine 62-1");		
		fireCalendar.getFireCalendarSpec().setDescription("A Fire Engine");
		fireCalendar.getFireCalendarSpec().setMake("Pierce");
		fireCalendar.getFireCalendarSpec().setModel("Arrow XT PUC");
		fireCalendar.getFireCalendarSpec().setYear("2009");
		fireCalendar.getFireCalendarSpec().setType("Pumper-Rescue");
		db.addFireCalendarEventToDB(fireCalendar);
		
		for(int i=0; i<4; i++){
			FireCalendar fireCalendar1 = new FireCalendar();
			fireCalendar1.getFireCalendarSpec().setName("Engine "+Integer.toString(i));
			
			fireCalendar1.getFireCalendarSpec().setDescription("A Fire Engine");
			fireCalendar1.getFireCalendarSpec().setMake("Pierce");
			fireCalendar1.getFireCalendarSpec().setModel("Arrow XT PUC");
			fireCalendar1.getFireCalendarSpec().setYear("2009");
			fireCalendar1.getFireCalendarSpec().setType("Pumper-Rescue");
			db.addFireCalendarEventToDB(fireCalendar1);
		}
		
		return db.getFireEventFromDB();
	}
}
