package edu.ycp.CS320.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.ui.ListBox;

public class theCalendar extends Composite implements ISubscriber {

	private final AbsolutePanel absolutePanel = new AbsolutePanel();
	private DatePicker datePicker;
	private ListBox listBox;
	private InlineLabel lblDate;
	private InlineLabel numEvents;
	private int count;

	public theCalendar() {
		count = 0;
		initWidget(absolutePanel);
		absolutePanel.setSize("755px", "284px");

		Button btnAddEvent = new Button("Add Event");
		absolutePanel.add(btnAddEvent, 90, 233);

		Button btnDeleteEvent = new Button("Delete Event");
		absolutePanel.add(btnDeleteEvent, 256, 233);

		this.lblDate = new InlineLabel("");
		absolutePanel.add(lblDate, 549, 26);
		lblDate.setSize("102px", "20px");
		
		this.listBox = new ListBox();
		absolutePanel.add(listBox, 444, 74);
		listBox.setSize("267px", "155px");

		// sets the current date label to the current date
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// get current date time with Date()
		Date date = new Date();
		lblDate.setText(dateFormat.format(date));
		////////////////////////////////////////////////
		listBox.setVisibleItemCount(4);		
		
		if (count == 0)
		{
			listBox.addItem(count + " Events Today");	
			//numEvents.setText(Integer.toString(count));
		}

		this.datePicker = new DatePicker();
		datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {

			private String nEvents;

			public void onValueChange(ValueChangeEvent<Date> event) {
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date date1 = datePicker.getValue();
				count++;
				lblDate.setText(dateFormat.format(date1));
				this.nEvents = numEvents.getText(); // this is be updated when
				
				// if (nEvents.equals("0"))
				if (count > 0) {
					// listBox.addItem("No Events Today");
					// listBox.removeItem(0);
					listBox.addItem(count + " Events Today");
					numEvents.setText(Integer.toString(count));
				} else {
					// listBox.removeItem(0);
					// listBox.addItem("1 Events Today");
					

				}

			}
		});

		absolutePanel.add(datePicker, 24, 10);
		datePicker.setSize("356px", "195px");

		InlineLabel nlnlblDateSelected = new InlineLabel("Date Selected:");
		absolutePanel.add(nlnlblDateSelected, 444, 26);

		InlineLabel nlnlblOfEvents = new InlineLabel("# of Events that day:");
		absolutePanel.add(nlnlblOfEvents, 444, 50);

		this.numEvents = new InlineLabel("0");
		absolutePanel.add(numEvents, 587, 50);
		numEvents.setSize("64px", "18px");

	}




	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {

	}
}
