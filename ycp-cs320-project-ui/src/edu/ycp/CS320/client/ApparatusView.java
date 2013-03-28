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

//mws

public class ApparatusView extends Composite implements ISubscriber {
	
	
	public ApparatusView() {			
		/**
		 * 
		 * widgets
		 * 
		 */
		final LayoutPanel layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("fireStation-panelBackground");
		initWidget(layoutPanel);
		layoutPanel.setSize("780px", "413px");
		
		Label lblWelcomeToYork = new Label("Apparatus Page!!!");
		lblWelcomeToYork.setStyleName("Title");
		lblWelcomeToYork.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		layoutPanel.add(lblWelcomeToYork);
		layoutPanel.setWidgetLeftWidth(lblWelcomeToYork, 333.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblWelcomeToYork, 17.0, Unit.PX, 25.0, Unit.PX);
	}

	/* (non-Javadoc)
	 * @see edu.ycp.CS320.shared.ISubscriber#eventOccurred(java.lang.Object, edu.ycp.CS320.shared.IPublisher, java.lang.Object)
	 * 
	 * TODO: implement subscribing/publishing events
	 */
	
	
	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {		
		
	}		
	
}
