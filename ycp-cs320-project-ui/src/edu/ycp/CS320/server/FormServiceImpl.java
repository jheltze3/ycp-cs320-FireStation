package edu.ycp.CS320.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.CS320.client.FormService;
import edu.ycp.CS320.shared.Form;
import edu.ycp.CS320.shared.IDatabase;

public class FormServiceImpl extends RemoteServiceServlet implements FormService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void addForms(Form form) {
		IDatabase db = DatabaseSingleton.instance();
		
		db.addFormsToDB(form);
		
	}
	
}
