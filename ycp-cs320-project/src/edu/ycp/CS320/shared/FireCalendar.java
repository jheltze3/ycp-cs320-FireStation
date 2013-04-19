package edu.ycp.CS320.shared;

import java.io.Serializable;

public class FireCalendar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FireCalendarEvent fireCalendar;

	public FireCalendar()
	{
		setFireCalendarEvent(new FireCalendarEvent());
	}
	
	public FireCalendarEvent getFireCalendarSpec() {
		// TODO Auto-generated method stub
		return fireCalendar;
	}
	


	public void setFireCalendarEvent(FireCalendarEvent fireCalendar) {
		this.fireCalendar = fireCalendar;
	}


	
}
