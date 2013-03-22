package edu.ycp.CS320.client;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

/**
 * @author drew
 *this is the homepage which the logged in user will see after clicking log in
 *right now it is lonely and needs features
 */
public class HomePageView extends Composite{
	private Button btnCalendar;
	private calendar cal = new calendar();
	
	public HomePageView(){
		
		final LayoutPanel layout = new LayoutPanel();
		initWidget(layout);		
		Label hi = new Label("HOMEPAGE...\nAdd Links and Features here");		
		layout.add(hi);
		
		btnCalendar = new Button("Calendar");
		layout.add(btnCalendar);
		layout.setWidgetLeftWidth(btnCalendar, 21.0, Unit.PX, 81.0, Unit.PX);
		layout.setWidgetTopHeight(btnCalendar, 48.0, Unit.PX, 30.0, Unit.PX);
		
		btnCalendar.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				layout.clear();
				layout.add(cal);
				
			}
			
		});
		
	}
}
