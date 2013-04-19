package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

import edu.ycp.CS320.shared.FireCalendar;


public interface CalendarServiceAsync {
	void message(String message, AsyncCallback<Boolean> callback);

	void loadEvents(AsyncCallback<ArrayList<FireCalendar>> callback);
	
}
