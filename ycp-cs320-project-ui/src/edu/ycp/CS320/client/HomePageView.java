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



/**
 * @author drew
 *this is the homepage which the logged in user will see after clicking log in
 *right now it is lonely and needs features
 */
public class HomePageView extends Composite{
	private Button btnApparatus;
	private ApparatusView apparatusView = new ApparatusView();
	private Button btnCalendar;
	private theCalendar cal = new theCalendar();
	private ContactInfoView contact = new ContactInfoView();
	private Button btnContact;
	
	public HomePageView(){

		final LayoutPanel layout = new LayoutPanel();
		
//		initWidget(layout);
//		Label hi = new Label("HOMEPAGE...\nAdd Links and Features here");

//		LayoutPanel layout = new LayoutPanel();


		initWidget(layout);		
		Label hi = new Label("Welcome To York Fire Station");		
		layout.add(hi);
		layout.setWidgetLeftWidth(hi, 0.0, Unit.PX, 637.0, Unit.PX);
		layout.setWidgetTopHeight(hi, 0.0, Unit.PX, 542.0, Unit.PX);
		

		btnApparatus = new Button("Apparatus");
		layout.add(btnApparatus);
		layout.setWidgetLeftWidth(btnApparatus, 21.0, Unit.PX, 81.0, Unit.PX);
		layout.setWidgetTopHeight(btnApparatus, 84.0, Unit.PX, 30.0, Unit.PX);
		
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
		
		
		btnCalendar = new Button("Calendar");
		layout.add(btnCalendar);
		layout.setWidgetLeftWidth(btnCalendar, 21.0, Unit.PX, 81.0, Unit.PX);
		layout.setWidgetTopHeight(btnCalendar, 48.0, Unit.PX, 30.0, Unit.PX);
		
		btnContact = new Button("Contacts");
		layout.add(btnContact);
		layout.setWidgetLeftWidth(btnContact, 21.0, Unit.PX, 81.0, Unit.PX);
		layout.setWidgetTopHeight(btnContact, 120.0, Unit.PX, 30.0, Unit.PX);
		
		Button btnVolunteer = new Button("Volunteer");
		layout.add(btnVolunteer);
		layout.setWidgetLeftWidth(btnVolunteer, 21.0, Unit.PX, 81.0, Unit.PX);
		layout.setWidgetTopHeight(btnVolunteer, 156.0, Unit.PX, 30.0, Unit.PX);
		
		btnCalendar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				layout.clear();
				layout.add(cal);				
			}			
		});		
		
		
		btnContact.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				layout.clear();
				layout.add(btnContact);
			}
		});
		
//
//		=======
//import com.google.gwt.dom.client.Style.Unit;
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//
//
//
//
///**
// * @author drew
// *this is the homepage which the logged in user will see after clicking log in
// *right now it is lonely and needs features
// */
//public class HomePageView extends Composite{
//	private Button btnApparatus;
//	private ApparatusView apparatusView = new ApparatusView();
//	private Button btnCalendar;
//	private theCalendar cal = new theCalendar();
//	
//	public HomePageView(){
//
//		final LayoutPanel layout = new LayoutPanel();
//		
////		initWidget(layout);
////		Label hi = new Label("HOMEPAGE...\nAdd Links and Features here");
//
////		LayoutPanel layout = new LayoutPanel();
//
//
//		initWidget(layout);		
//		Label hi = new Label("HOMEPAGE...\nAdd Links and Features here");		
//		layout.add(hi);
//		
//
//		btnApparatus = new Button("Apparatus");
//		layout.add(btnApparatus);
//		layout.setWidgetLeftWidth(btnApparatus, 21.0, Unit.PX, 120.0, Unit.PX);
//		layout.setWidgetTopHeight(btnApparatus, 84.0, Unit.PX, 30.0, Unit.PX);
//	
//		
//		
//		
//		
//		
//		btnApparatus.addClickHandler(new ClickHandler() {
//			/* (non-Javadoc)
//			 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
//			 * 
//			 * this method creates a local User object this is used to login to the system
//			 * an async callback is created that will confirm if the RPC was successful or not
//			 * 
//			 */
//			@Override
//			public void onClick(ClickEvent event) {
//				System.out.println("Apparatus!");
//				layout.clear();
//				layout.add(apparatusView);				
//			}		
//			
//		});
//		
//		
//		btnCalendar = new Button("Calendar");
//		layout.add(btnCalendar);
//		layout.setWidgetLeftWidth(btnCalendar, 21.0, Unit.PX, 81.0, Unit.PX);
//		layout.setWidgetTopHeight(btnCalendar, 48.0, Unit.PX, 30.0, Unit.PX);
//		
//		btnCalendar.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				layout.clear();
//				layout.add(cal);				
//			}			
//		});		
//>>>>>>> refs/remotes/Jake/master
	}
}
