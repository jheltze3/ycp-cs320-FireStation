package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireApparatusList;

public interface ApparatusServiceAsync {
	void message(String message, AsyncCallback<Boolean> callback);

	void loadApparatus(AsyncCallback<ArrayList<FireApparatus>> callback);
	
}
