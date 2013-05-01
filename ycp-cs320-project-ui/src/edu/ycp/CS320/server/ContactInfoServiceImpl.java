package edu.ycp.CS320.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.CS320.client.ContactInfoService;
import edu.ycp.CS320.shared.ContactInfo;
import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.cs320.controllers.GetContactInfoController;
//add commment
public class ContactInfoServiceImpl extends RemoteServiceServlet implements ContactInfoService {
	@Override
	public ArrayList<ContactInfo> loadContactInfo() {
		GetContactInfoController contactInfoController = new GetContactInfoController();
		
		IDatabase db = DatabaseSingleton.instance();
		
		ArrayList<ContactInfo> result = contactInfoController.getInfo(db);
		if (result == null) {
			result = new ArrayList<ContactInfo>();
		}
		return result;
			
	}
	
}