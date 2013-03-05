 package edu.ycp.CS320.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.CS320.client.LoginService;
import edu.ycp.CS320.shared.User;

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
	public boolean login(User user) {
		System.out.print("logging in?");
		return true;
	}
	
	@Override
	public boolean addNewUser(User user){
		db.addUserToDatabase(user);		
		System.out.print("hi");
		return true;
	}

	@Override
	public boolean message(String message) {
		// TODO Auto-generated method stub
		System.out.println("Message is: " + message);
		return true;
	}

}
