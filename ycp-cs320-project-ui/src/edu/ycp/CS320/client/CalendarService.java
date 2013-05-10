package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;
import edu.ycp.CS320.shared.FireCalendar;


/**
 * @author Jake
 *
 */
@RemoteServiceRelativePath("CalendarServiceImpl")
public interface CalendarService extends RemoteService {

	public boolean message(String message);
	ArrayList<FireCalendar> loadEvents();
	boolean addcalendar(FireCalendar fireCalendar);
	boolean removeFireCalendarEvent(int id);


}
