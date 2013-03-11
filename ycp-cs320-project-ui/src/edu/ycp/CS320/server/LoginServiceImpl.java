 package edu.ycp.CS320.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.CS320.client.LoginService;
import edu.ycp.CS320.shared.FakeDatabase;
import edu.ycp.CS320.shared.User;
/**
 * The server side implementation of the RPC service.
 */
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService{

	private FakeDatabase db = new FakeDatabase();
	
	private static final long serialVersionUID = 1L;
/**
 * 
 * at this point in time if an RPC call is received, the async callback returns with "true"
 * the next implementation should incorporate logic to determine whether or not a user has entered valid 
 * credentials and if they are in the database already or not.
 * 
 */
	@Override
	public Boolean login(User user) {
		System.out.println("logging in?");
		return true;
	}
	
	@Override
	public Boolean addNewUser(User user) {
		db.addUserToDatabase(user);		
		System.out.println("hi");
		return true;
	}

	@Override
	public Boolean message(String message) {
		System.out.println("Message is: " + message);
		return true;
	}

}
