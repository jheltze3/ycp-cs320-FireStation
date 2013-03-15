package edu.ycp.CS320.client;



import com.google.gwt.thirdparty.javascript.jscomp.Scope.Var;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.LayoutPanel;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Button;

import edu.ycp.CS320.shared.FakeDatabase;
import edu.ycp.CS320.shared.IPublisher;
import edu.ycp.CS320.shared.ISubscriber;
import edu.ycp.CS320.shared.User;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import java.util.Date;
import com.google.gwt.event.logical.shared.ValueChangeEvent;



//mws

public class calendar extends Composite implements ISubscriber {
	

	private final AbsolutePanel absolutePanel = new AbsolutePanel();
	private DatePicker datePicker;
	private DateLabel lblDate;
	
	public calendar() {
		
		initWidget(absolutePanel);
		absolutePanel.setSize("852px", "284px");
		
		Button btnAddEvent = new Button("Add Event");
		absolutePanel.add(btnAddEvent, 90, 233);
		
		Button btnDeleteEvent = new Button("Delete Event");
		absolutePanel.add(btnDeleteEvent, 256, 233);
		
		
		this.lblDate = new DateLabel();
		absolutePanel.add(lblDate, 589, 26);
		
		
		this.datePicker = new DatePicker();
		datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				
		Date date = datePicker.getValue();
		
		lblDate.setValue(date);
			//datePicker.getElement() 
			}
		});
		absolutePanel.add(datePicker, 24, 10);
		datePicker.setSize("356px", "195px");
		
		InlineLabel nlnlblDateSelected = new InlineLabel("Date Selected:");
		absolutePanel.add(nlnlblDateSelected, 444, 26);
		
		InlineLabel nlnlblOfEvents = new InlineLabel("# of Events that day:");
		absolutePanel.add(nlnlblOfEvents, 444, 50);
		
		InlineLabel inlineLabel = new InlineLabel("0");
		absolutePanel.add(inlineLabel, 589, 50);
		inlineLabel.setSize("64px", "18px");

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

