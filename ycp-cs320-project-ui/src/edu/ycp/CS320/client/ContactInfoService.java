package edu.ycp.CS320.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.CS320.shared.ContactInfo;
//add commment
@RemoteServiceRelativePath("ContactInfoServiceImpl")
public interface ContactInfoService extends RemoteService {
	
	public ArrayList<ContactInfo> loadContactInfo();
}
