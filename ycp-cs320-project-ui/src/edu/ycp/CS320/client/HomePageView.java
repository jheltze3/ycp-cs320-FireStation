package edu.ycp.CS320.client;


import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import edu.ycp.CS320.shared.User;

/**
 * @author drew
 *this is the homepage which the logged in user will see after clicking log in
 */
public class HomePageView extends Composite{
	private Button btnApparatus;
	private ApparatusView apparatusView = new ApparatusView();
	
	public HomePageView(){
		final LayoutPanel layout = new LayoutPanel();
		
		initWidget(layout);
		Label hi = new Label("HOMEPAGE...\nAdd Links and Features here");
		layout.add(hi);
		
		btnApparatus = new Button("Apparatus");
		layout.add(btnApparatus);
		layout.setWidgetLeftWidth(btnApparatus, 33.0, Unit.PX, 120.0, Unit.PX);
		layout.setWidgetTopHeight(btnApparatus, 50.0, Unit.PX, 30.0, Unit.PX);
		
		btnApparatus.addClickHandler(new ClickHandler() {

			
			/* (non-Javadoc)
			 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
			 * 
			 * this method creates a local User object this is used to login to the system
			 * an async callback is created that will confirm if the RPC was successful or not
			 * 
			 */
			@Override
			public void onClick(ClickEvent event) {
				System.out.println("Apparatus!");
				layout.clear();
				layout.add(apparatusView);
				
			}			
			
		});

		
	}
}
