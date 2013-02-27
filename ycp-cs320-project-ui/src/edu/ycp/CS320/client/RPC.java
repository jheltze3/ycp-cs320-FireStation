package edu.ycp.CS320.client;

import com.google.gwt.core.client.GWT;

public class RPC {
	
	public static final LoginServiceAsync LoginService = GWT.create(LoginService.class);
	protected static Object loginService;
	
}

