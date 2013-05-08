
 package edu.ycp.CS320.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.ArrayList;
import edu.ycp.CS320.client.CalendarService;
import edu.ycp.CS320.shared.FireCalendar;
import edu.ycp.CS320.shared.FireCalendarEvent;
import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.cs320.controllers.GetCalendarController;

/**
 * The server side implementation of the RPC service. 
 * author Jake
 */

public class CalendarServiceImpl extends RemoteServiceServlet implements CalendarService{

	private static final long serialVersionUID = 1L;


	@Override
	public boolean message(String message) {
		System.out.println("Message is: " + message);
		return true;
	}


	@Override
	public ArrayList<FireCalendar> loadEvents() {
		GetCalendarController calendarController = new GetCalendarController();
		
		IDatabase db = DatabaseSingleton.instance();
		
		ArrayList<FireCalendar> result = calendarController.getEvent(db);
		if (result == null) {
			result = new ArrayList<FireCalendar>();
		}
		return result;
	
	}

	@Override
	public boolean addcalendar(FireCalendar firecalendar) {
	
		GetCalendarController calendarController = new GetCalendarController();
		
		IDatabase db = DatabaseSingleton.instance();
		
		calendarController.addEvent(firecalendar, db);
		
		return true;
	}

}

