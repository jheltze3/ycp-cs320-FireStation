package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.CS320.shared.Form;

public interface FormServiceAsync {

	/**
	 * @param form
	 * @param callback
	 * 
	 * asynchronous version of FormService, allows work to be done while the method 
	 * executes.
	 */
	void addForms(Form form, AsyncCallback<Void> callback);

}
