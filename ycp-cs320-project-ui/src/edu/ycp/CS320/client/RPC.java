package edu.ycp.CS320.client;
import com.google.gwt.core.client.GWT;

public class RPC {
	public static final LoginServiceAsync loginService = GWT.create(LoginService.class);
	
	public static final ApparatusServiceAsync apparatusService = GWT.create(ApparatusService.class);
	
	public static final CalendarServiceAsync calenderService = GWT.create(CalendarService.class);
}
