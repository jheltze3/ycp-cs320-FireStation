
package edu.ycp.CS320.client;
import java.util.ArrayList;

import edu.ycp.CS320.shared.FireCalendar;



import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

import edu.ycp.CS320.shared.FireCalendar;
import edu.ycp.CS320.shared.FireCalendarEvent;
/*
 * 
 * 
 *  author Jake
 */

public interface CalendarServiceAsync {
	void message(String message, AsyncCallback<Boolean> callback);
	void loadEvents(AsyncCallback<ArrayList<FireCalendar>> callback);
	void addcalendar(FireCalendar fireCalendar,AsyncCallback<Boolean> callback);	
}

