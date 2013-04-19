package edu.ycp.cs320.controllers;
import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.CS320.shared.ContactInfo;
import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.IDatabase;


public class GetContactInfoController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	public ArrayList<ContactInfo> getInfo(IDatabase db){
		return db.getContactsFromDB();
	}
}
