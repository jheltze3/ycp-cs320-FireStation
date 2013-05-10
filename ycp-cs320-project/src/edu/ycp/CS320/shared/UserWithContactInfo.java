package edu.ycp.CS320.shared;

import java.io.Serializable;

public class UserWithContactInfo implements Serializable {
	private User user;
	private ContactInfo contactInfo;

	public UserWithContactInfo() {

	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}
}