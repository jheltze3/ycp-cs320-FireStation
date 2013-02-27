package edu.ycp.CS320.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.CS320.client.LoginService;


/**
 * The server side implementation of the RPC service.
 */

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	private static final long serialVersionUID = 1L;

	@Override
	public Boolean login(String username, String userPassword) {
		// TODO Auto-generated method stub
		return null;
	}
}
