package edu.ycp.cs320.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import edu.ycp.CS320.shared.ContactInfo;
import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.CS320.shared.UserWithContactInfo;


public class GetContactInfoController implements Serializable {


	private static final long serialVersionUID = 1L;

	public ArrayList<UserWithContactInfo> getInfo(IDatabase db){
		return db.getContactsFromDB();
	}
}