package edu.ycp.CS320.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.CS320.shared.IPublisher;
import edu.ycp.CS320.shared.ISubscriber;
import edu.ycp.CS320.shared.User;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

//mws

public class MainPage extends Composite implements ISubscriber {
	
		
	
	public MainPage() {			
		/**
		 * 
		 * widgets
		 * 
		 */
		LayoutPanel layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("fireStation-panelBackground");
		initWidget(layoutPanel);
		layoutPanel.setSize("709px", "487px");
		
		Label lblWelcomeToYork = new Label("Welcome To York Fire Station");
		lblWelcomeToYork.setStyleName("Title");
		lblWelcomeToYork.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		layoutPanel.add(lblWelcomeToYork);
		layoutPanel.setWidgetLeftWidth(lblWelcomeToYork, 333.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblWelcomeToYork, 17.0, Unit.PX, 25.0, Unit.PX);
		
		DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.EM);
		layoutPanel.add(dockLayoutPanel);
		layoutPanel.setWidgetLeftWidth(dockLayoutPanel, 34.0, Unit.PX, 655.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(dockLayoutPanel, 48.0, Unit.PX, 424.0, Unit.PX);
		
		Hyperlink hprlnkEquiptment = new Hyperlink("Equiptment", false, "newHistoryToken");
		dockLayoutPanel.addNorth(hprlnkEquiptment, 3.2);
		
		Hyperlink hprlnkVolunteer = new Hyperlink("Volunteer", false, "newHistoryToken");
		dockLayoutPanel.addNorth(hprlnkVolunteer, 3.7);
		
		Hyperlink hprlnkCalendarOfEvents = new Hyperlink("Calendar of Events", false, "newHistoryToken");
		dockLayoutPanel.addNorth(hprlnkCalendarOfEvents, 3.7);
		
		Hyperlink hprlnkContacts = new Hyperlink("Contacts", false, "newHistoryToken");
		dockLayoutPanel.addNorth(hprlnkContacts, 3.6);
		
		Hyperlink hprlnkApplication = new Hyperlink("Application", false, "newHistoryToken");
		dockLayoutPanel.addNorth(hprlnkApplication, 4.2);
		hprlnkApplication.setHeight("");
	
		
	}

	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {
		// TODO Auto-generated method stub
		
	}
}
