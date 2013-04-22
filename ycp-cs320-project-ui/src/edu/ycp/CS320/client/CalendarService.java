package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

import edu.ycp.CS320.shared.FireCalendar;
import edu.ycp.CS320.shared.FireCalendarEvent;

/**
 * @author Joshua
 *
 */
@RemoteServiceRelativePath("ApparatusServiceImpl")
public interface CalendarService extends RemoteService {
	
	public boolean message(String message);
	public ArrayList<FireCalendar> loadEvents();
}

