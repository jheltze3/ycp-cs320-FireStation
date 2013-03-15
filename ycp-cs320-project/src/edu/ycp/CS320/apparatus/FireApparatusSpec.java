package edu.ycp.CS320.apparatus;

public class FireApparatusSpec {
	private String make;
	private String model;
	private String name;
	private String year;
	
	public FireApparatusSpec(String make, String model, String name, String year){
		this.make = make;
		this.model = model;
		this.name = name;
		this.year = year; 
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

}
