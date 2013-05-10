package edu.ycp.CS320.server;

import java.util.ArrayList;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.ycp.CS320.client.ContactInfoService;
import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.CS320.shared.UserWithContactInfo;
import edu.ycp.cs320.controllers.GetContactInfoController;

public class ContactInfoServiceImpl extends RemoteServiceServlet implements ContactInfoService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<UserWithContactInfo> loadContactInfo() {
		System.out.println("Getting contact info from database...");
		GetContactInfoController contactInfoController = new GetContactInfoController();

		IDatabase db = DatabaseSingleton.instance();

		ArrayList<UserWithContactInfo> result = contactInfoController.getInfo(db);
		if (result == null) {
			System.out.println("Database returned a null contact info list?");
			result = new ArrayList<UserWithContactInfo>();
		} else {
			System.out.println("Received " + result.size() + " contacts from database");
		}
		return result;

	}

}