package edu.ycp.CS320.shared;

import java.io.Serializable;

public class FireApparatusSpec implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String make;
	private String model;
	private String name;
	private String year;
	private String type;
	private String description;
	
	public FireApparatusSpec(String make, String model, String name, String year){
		this.make = make;
		this.model = model;
		this.name = name;
		this.year = year; 
	}
	
	public FireApparatusSpec(){
		
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
