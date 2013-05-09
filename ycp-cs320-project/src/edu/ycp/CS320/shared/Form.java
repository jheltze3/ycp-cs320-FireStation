package edu.ycp.CS320.shared;

import java.io.Serializable;

public class Form implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private String name;	
	private String address;
	private String doctor;
	private String doctorPhone;	
	private int id = -1;		
	
	public Form(){
		//default constructor
	}
	
	public Form(int id, String name, String address, String doctor, String doctorPhone){
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.doctor = doctor;
		this.doctorPhone = doctorPhone;		
		
	}

	/**
	 * all field getters and setters 
	 * live below --
	 * 
	 */
	
	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDoctorPhone() {
		return doctorPhone;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
