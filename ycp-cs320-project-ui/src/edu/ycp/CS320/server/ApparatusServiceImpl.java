 package edu.ycp.CS320.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.ArrayList;
import edu.ycp.CS320.client.ApparatusService;
import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireApparatusList;
import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.cs320.controllers.GetApparatusController;

/**
 * The server side implementation of the RPC service.
 */

public class ApparatusServiceImpl extends RemoteServiceServlet implements ApparatusService{

	private static final long serialVersionUID = 1L;


	@Override
	public boolean message(String message) {
		System.out.println("Message is: " + message);
		return true;
	}


	@Override
	public ArrayList<FireApparatus> loadApparatus() {
		GetApparatusController apparatusController = new GetApparatusController();
		
		IDatabase db = DatabaseSingleton.instance();
		
		ArrayList<FireApparatus> result = apparatusController.getApparatus(db);
		if (result == null) {
			result = new ArrayList<FireApparatus>();
		}
		return result;
		
//		if(apparatusController.getApparatus(db) != null){	
//			return apparatusController.getApparatus(db);
//		} 
//		return null;
	}

}
