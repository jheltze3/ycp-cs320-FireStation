package edu.ycp.CS320.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Label;

import edu.ycp.CS320.shared.IPublisher;
import edu.ycp.CS320.shared.ISubscriber;

public class ContactInfoView extends Composite implements ISubscriber {
	
	public ContactInfoView() {
		
		final LayoutPanel layout = new LayoutPanel();
		initWidget(layout);
		layout.setSize("627px", "523px");
		
		ListBox listBox = new ListBox();
		listBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				
				
			}
		});
		layout.add(listBox);
		layout.setWidgetLeftWidth(listBox, 58.0, Unit.PX, 210.0, Unit.PX);
		layout.setWidgetTopHeight(listBox, 48.0, Unit.PX, 339.0, Unit.PX);
		listBox.setVisibleItemCount(5);
		
		ListBox listBox_1 = new ListBox();
		layout.add(listBox_1);
		layout.setWidgetLeftWidth(listBox_1, 365.0, Unit.PX, 235.0, Unit.PX);
		layout.setWidgetTopHeight(listBox_1, 48.0, Unit.PX, 339.0, Unit.PX);
		listBox_1.setVisibleItemCount(5);
		
		Label lblContactInformation = new Label("Contact Information");
		layout.add(lblContactInformation);
		layout.setWidgetLeftWidth(lblContactInformation, 253.0, Unit.PX, 170.0, Unit.PX);
		layout.setWidgetTopHeight(lblContactInformation, 15.0, Unit.PX, 18.0, Unit.PX);
	}

	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {
		// TODO Auto-generated method stub
		
	}
}
