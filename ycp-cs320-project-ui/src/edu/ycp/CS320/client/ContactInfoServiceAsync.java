package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;
import edu.ycp.CS320.shared.UserWithContactInfo;
public interface ContactInfoServiceAsync {

	void loadContactInfo(AsyncCallback<ArrayList<UserWithContactInfo>> callback);
}