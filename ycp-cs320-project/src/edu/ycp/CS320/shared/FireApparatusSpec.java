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
	private int year;
	private String type;
	private String description;	
	private int id;
	
	public FireApparatusSpec(String make, String model, String name, int year, String type, String desc){
		this.make = make;
		this.model = model;
		this.name = name;
		this.year = year; 
		this.type = type;
		this.description = desc;
	}
	
	public FireApparatusSpec() {
		//default
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
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
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

	public void setId(int id) {
		this.id = id;
		
	}

}
