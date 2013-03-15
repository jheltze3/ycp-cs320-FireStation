package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.AsyncCallback;


import edu.ycp.CS320.shared.User;

import edu.ycp.CS320.shared.*;


/**
 * @author drew
 *asynchronous version of LoginService
 */
public interface LoginServiceAsync {
	void message(String message, AsyncCallback<Boolean> callback);
	
	void login(FakeDatabase db, User user, AsyncCallback<Boolean> callback);

	void addNewUser(FakeDatabase db, User user, AsyncCallback<Boolean> callback);
}
