package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface LoginServiceAsync {
	void login(String username, String userPassword,
			AsyncCallback<Boolean> callback);
}
