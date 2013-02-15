package edu.ycp.CS320.jjda;

public class ContactInfo {
	private int id;
	private int userId;
	private ContactInfoType type;
	private String phoneNumber;
	
	public ContactInfo() {
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setType(ContactInfoType type) {
		this.type = type;
	}
	
	public ContactInfoType getType() {
		return type;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
}
