 package edu.ycp.CS320.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.CS320.client.LoginService;
import edu.ycp.CS320.shared.FakeDatabase;
import edu.ycp.CS320.shared.User;
/**
 * The server side implementation of the RPC service.
 */
import edu.ycp.cs320.controllers.ValidateUserController;

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
	public boolean login(FakeDatabase db, User user) {
		ValidateUserController userController = new ValidateUserController();
		boolean validate = userController.containsUser(db, user);
		if(validate == true){
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean addNewUser(FakeDatabase db, User user){
		ValidateUserController userController = new ValidateUserController();
		boolean validate = userController.containsUser(db, user);
		if(validate == false){
			db.addUserToDatabase(user);
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
