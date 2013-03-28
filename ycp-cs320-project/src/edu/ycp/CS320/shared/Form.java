package edu.ycp.CS320.shared;

import java.io.Serializable;

public class Form implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * TODO: create FormView page
	 */
	
	private String name;
	private String password;
	private String address;
	private ContactInfo contact = new ContactInfo();
	private int id = -1;	
	
	
	public Form(){
		//default constructor
	}
	
	public Form(String name, String password, String address, ContactInfo contact, int id){
		this.name = name;
		this.password = password;
		this.address = address;
		this.contact = contact;
		this.id = id;
	}

	/**
	 * all field getters and setters 
	 * live below --
	 * 
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ContactInfo getContact() {
		return contact;
	}

	public void setContact(ContactInfo contact) {
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
