package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.CS320.shared.Form;

@RemoteServiceRelativePath("FormServiceImpl")
public interface FormService extends RemoteService {
	
	/**
	 * @param form
	 * 
	 * the form parameter in this method will be send to the server
	 * and added to the derby database.
	 */
	void addForms(Form form);
	
}
