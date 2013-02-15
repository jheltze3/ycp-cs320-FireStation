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

	
	String homePhoneNumber = "";
	String cellPhoneNumber = "";
	String name = "";
	//String hobbies = "";
	
	
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

