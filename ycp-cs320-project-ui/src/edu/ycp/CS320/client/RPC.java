package edu.ycp.CS320.client;
import com.google.gwt.core.client.GWT;

public class RPC {
	public static final LoginServiceAsync loginService = GWT.create(LoginService.class);
}
