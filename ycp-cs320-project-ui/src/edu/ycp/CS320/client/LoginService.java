package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.CS320.shared.User;

/**
 * @author drew
 *these are the general methods that the login service implementation will perform
 */
@RemoteServiceRelativePath("LoginServiceImpl")
public interface LoginService extends RemoteService {

	/**
	 * @param user
	 * @return returns true if the user is contained in the database 
	 * AND if they entered valid credentials
	 */
	public boolean login(User user);
	
	/**
	 * @param message
	 * @return returns true if the message made it to the server
	 */
	public boolean message(String message);
	
	/**
	 * @param user
	 * @return returns true if the user was not in the database
	 * AND they were added to the database
	 */
	public boolean addNewUser(User user);

}
