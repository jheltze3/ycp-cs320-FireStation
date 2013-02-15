package edu.ycp.CS320.jjda;

public class ContactInfo {
	
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
