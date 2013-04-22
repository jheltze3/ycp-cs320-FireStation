
package edu.ycp.CS320.shared;

import java.io.Serializable;


public class FireCalendarEvent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String location;
	private String startTime;
	private String endTime;
	private String description;
	private String date;
	
	public FireCalendarEvent(String title, String location, String startTime, String endTime, String description, String date){
		this.title = title;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime; 
		this.description = description; 
		this.date = date; 
	}
	
	public FireCalendarEvent(){
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndtime(String endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}

