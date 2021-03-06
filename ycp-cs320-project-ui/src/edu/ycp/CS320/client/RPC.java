package edu.ycp.CS320.client;
import com.google.gwt.core.client.GWT;

public class RPC {
	public static final LoginServiceAsync loginService = GWT.create(LoginService.class);	
	public static final ApparatusServiceAsync apparatusService = GWT.create(ApparatusService.class);	
	public static final CalendarServiceAsync calenderService = GWT.create(CalendarService.class);
	public static final FormServiceAsync formService = GWT.create(FormService.class);
	public static final ContactInfoServiceAsync contactinfoservice = GWT.create(ContactInfoService.class);
}
