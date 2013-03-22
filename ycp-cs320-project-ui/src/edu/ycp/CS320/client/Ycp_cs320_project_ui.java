 package edu.ycp.CS320.client;
 
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Ycp_cs320_project_ui implements EntryPoint{
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		LayoutPanel panel = new LayoutPanel();
		
		LoginView demoView = new LoginView();
		
		panel.add(demoView);		
		
		RootLayoutPanel.get().add(panel);
		RootLayoutPanel.get().setWidgetLeftRight(panel, 0.0, Unit.PX, 0.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(panel, 0.0, Unit.PX, 0.0, Unit.PX);		
		
	}
}
