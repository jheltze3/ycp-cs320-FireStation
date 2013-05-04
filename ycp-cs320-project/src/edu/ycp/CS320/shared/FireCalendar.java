
package edu.ycp.CS320.shared;

import java.io.Serializable;



public class FireCalendar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FireCalendarEvent fireCalendar;

	public FireCalendar(FireCalendarEvent fireCalendarEvent)
	{
		setFireCalendarEvent(fireCalendarEvent);
	}
	
	


	public FireCalendarEvent getFireFireEvent() {
		return fireCalendar;
	}
	


	public void setFireCalendarEvent(FireCalendarEvent fireCalendar) {
		this.fireCalendar = fireCalendar;
	}


	
}

