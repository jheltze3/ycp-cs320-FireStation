package edu.ycp.cs320.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import edu.ycp.CS320.shared.FireCalendar;
import edu.ycp.CS320.shared.IDatabase;

public class GetCalendarController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<FireCalendar> getEvent(IDatabase db){	

		return db.getFireEventFromDB();
	}

	public void addEvent(FireCalendar firecalendar, IDatabase db){
	db.addFireCalendarEventToDB(firecalendar);
	}

	public void removeEvent(int id, IDatabase db) {
		db.removeFireCalendarEvent(id);
	}


}