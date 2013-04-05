package edu.ycp.CS320.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireApparatusList;

/**
 * @author Joshua
 *
 */
@RemoteServiceRelativePath("ApparatusServiceImpl")
public interface ApparatusService extends RemoteService {
	
	public boolean message(String message);
	public ArrayList<FireApparatus> loadApparatus();
}
