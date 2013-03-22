 package edu.ycp.CS320.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.CS320.client.LoginService;
import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.CS320.shared.User;
import edu.ycp.cs320.controllers.AddUserController;
import edu.ycp.cs320.controllers.ValidateUserController;

/**
 * The server side implementation of the RPC service.
 */

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService{

	private static final long serialVersionUID = 1L;
/**
 * 
 * at this point in time if an RPC call is received, the async callback returns with "true"
 * the next implementation should incorporate logic to determine whether or not a user has entered valid 
 * credentials and if they are in the database already or not.
 * 
 */
	@Override
	public boolean login(User user) {
		ValidateUserController userController = new ValidateUserController();
		
		IDatabase db = DatabaseSingleton.instance();
		
		boolean validate = userController.containsUser(db, user);
		if(validate == true){
			return true;
		}
		
		return false;
	}
	
	@Override
	/**
	 * TODO: hovemeyer question - will this work with an embedded database
	 * since this IDatabase(db) is instantiated
	 * every time the method is called...
	 */
	public boolean addNewUser(User user){
		ValidateUserController userController = new ValidateUserController();
		AddUserController addController = new AddUserController();
		
		IDatabase db = DatabaseSingleton.instance();

		boolean contains = userController.containsUser(db, user);
		if(contains == false){
			addController.addUser(db, user);
			return true;
		}		
		return false;
	}

	@Override
	public boolean message(String message) {
		System.out.println("Message is: " + message);
		return true;
	}

}
