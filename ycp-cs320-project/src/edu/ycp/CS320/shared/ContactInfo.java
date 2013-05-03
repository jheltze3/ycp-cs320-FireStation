package edu.ycp.CS320.shared;

import java.io.Serializable;

public class ContactInfo implements Serializable {
	private int userId;
	private ContactInfoType type;
	private String homePhoneNumber = "";
	private String cellPhoneNumber = "";
	private String name = "";
	
	public ContactInfo(int id, String homePhone, String cellPhone, String name){
		this.userId = id;		
		this.homePhoneNumber = homePhone;
		this.cellPhoneNumber = cellPhone;
		this.name = name;
	}
	
	public ContactInfo() {
		
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
	
	public void setHomephoneNumber(String homePhoneNumber) {
		
		this.homePhoneNumber = homePhoneNumber;
		
	}

	public String getHomePhoneNumber() {
	
		return homePhoneNumber;
	}
	
	public void setCellphoneNumber(String cellPhoneNumber) {
		
		this.cellPhoneNumber = cellPhoneNumber;
		
	}

	public String getCellPhoneNumber() {
		
		return cellPhoneNumber;
	}
	
	public void setName(String name)
	{
		this.name = name;		
	}
	
	public String getName()
	{
		return name;		
	}
}

