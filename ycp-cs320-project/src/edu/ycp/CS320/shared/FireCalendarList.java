
package edu.ycp.CS320.shared;

import java.io.Serializable;
import java.util.ArrayList;


public class FireCalendarList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<FireCalendar> fireCalendarList;

	public ArrayList<FireCalendar> getFireApparatusList() {
		return fireCalendarList;
	}

	public void setFireApparatusList(ArrayList<FireCalendar> fireCalendarList) {
		this.fireCalendarList = fireCalendarList;
	}
	
}

