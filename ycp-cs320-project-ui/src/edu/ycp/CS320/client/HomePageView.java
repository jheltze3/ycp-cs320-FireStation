package edu.ycp.CS320.client;



import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;



import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import edu.ycp.CS320.shared.ContactInfo;
import com.google.gwt.user.client.ui.InlineLabel;

/**
 * @author drew
 *this is the homepage which the logged in user will see after clicking log in
 *right now it is lonely and needs features
 */
public class HomePageView extends Composite{
	private Button btnForms = new Button();
	private Button btnApparatus;
	private Button btnCalendar;
	private Button btnContact;
	private Button btnBackToLogin;
	private Button btnUsersButton;
	
	public HomePageView(){

		final LayoutPanel layout = new LayoutPanel();

		initWidget(layout);		
		Label hi = new Label("Welcome To York Fire Station");		
		layout.add(hi);
		layout.setWidgetLeftWidth(hi, 0.0, Unit.PX, 637.0, Unit.PX);
		layout.setWidgetTopHeight(hi, 0.0, Unit.PX, 542.0, Unit.PX);
		
		btnForms = new Button("Forms");
		layout.add(btnForms);
		layout.setWidgetLeftWidth(btnForms, 21.0, Unit.PX, 120.0, Unit.PX);
		layout.setWidgetTopHeight(btnForms, 202.0, Unit.PX, 30.0, Unit.PX);
		
		btnForms.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent click){				
				Ycp_cs320_project_ui.setView(new FormView());
			}
		});		

		btnApparatus = new Button("Apparatus");
		layout.add(btnApparatus);
		layout.setWidgetLeftWidth(btnApparatus, 21.0, Unit.PX, 120.0, Unit.PX);
		layout.setWidgetTopHeight(btnApparatus, 96.0, Unit.PX, 30.0, Unit.PX);

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
				ApparatusView view = new ApparatusView();
				Ycp_cs320_project_ui.setView(view);
				view.activate();
			}		
			
		});		
		
		btnCalendar = new Button("Calendar");
		layout.add(btnCalendar);
		layout.setWidgetLeftWidth(btnCalendar, 21.0, Unit.PX, 120.0, Unit.PX);
		layout.setWidgetTopHeight(btnCalendar, 48.0, Unit.PX, 30.0, Unit.PX);
		
		btnContact = new Button("Contacts");
		layout.add(btnContact);
		layout.setWidgetLeftWidth(btnContact, 21.0, Unit.PX, 120.0, Unit.PX);
		layout.setWidgetTopHeight(btnContact, 151.0, Unit.PX, 30.0, Unit.PX);
		
		Button btnVolunteer = new Button("Volunteer");
		layout.add(btnVolunteer);
		layout.setWidgetLeftWidth(btnVolunteer, 21.0, Unit.PX, 120.0, Unit.PX);
		layout.setWidgetTopHeight(btnVolunteer, 246.0, Unit.PX, 30.0, Unit.PX);
		
		btnBackToLogin = new Button("Back to Login");
		layout.add(btnBackToLogin);
		layout.setWidgetLeftWidth(btnBackToLogin, 331.0, Unit.PX, 103.0, Unit.PX);
		layout.setWidgetTopHeight(btnBackToLogin, 48.0, Unit.PX, 30.0, Unit.PX);
		
		btnUsersButton = new Button("Users");
		layout.add(btnUsersButton);
		layout.setWidgetLeftWidth(btnUsersButton, 331.0, Unit.PX, 103.0, Unit.PX);
		layout.setWidgetTopHeight(btnUsersButton, 202.0, Unit.PX, 30.0, Unit.PX);
		
		btnUsersButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			//	Ycp_cs320_project_ui.setView(UsersView);
				
				
			}
		});
		
		btnBackToLogin.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {				
				Ycp_cs320_project_ui.setView(new LoginView());				
			}
			
		});
		
		btnCalendar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {				
				Ycp_cs320_project_ui.setView(new theCalendar());
			}			
		});		
		
		
		btnContact.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Ycp_cs320_project_ui.setView(new ContactInfoView());
			}
		});
	}
}
