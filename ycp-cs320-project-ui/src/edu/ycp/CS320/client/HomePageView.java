package edu.ycp.CS320.client;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;

/**
 * @author drew
 *this is the homepage which the logged in user will see after clicking log in
 */
public class HomePageView extends Composite{
	
	public HomePageView(){
		LayoutPanel layout = new LayoutPanel();
		initWidget(layout);
		Label hi = new Label("HOMEPAGE...\nAdd Links and Features here");
		layout.add(hi);
		
	}

}
