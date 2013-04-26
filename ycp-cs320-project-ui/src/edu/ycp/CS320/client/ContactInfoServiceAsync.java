package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.CS320.shared.ContactInfo;
import edu.ycp.CS320.shared.FireApparatus;
//add commment
public interface ContactInfoServiceAsync {

	void loadContactInfo(AsyncCallback<ArrayList<ContactInfo>> callback);
}
