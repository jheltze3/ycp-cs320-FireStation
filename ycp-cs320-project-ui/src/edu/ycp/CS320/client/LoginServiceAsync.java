package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.ycp.CS320.shared.*;


/**
 * @author drew
 *asynchronous version of LoginService
 */
public interface LoginServiceAsync {
	void message(String message, AsyncCallback<Boolean> callback);
	
	void login(User user, AsyncCallback<Boolean> callback);

	void addNewUser(User user, AsyncCallback<Boolean> callback);
}
