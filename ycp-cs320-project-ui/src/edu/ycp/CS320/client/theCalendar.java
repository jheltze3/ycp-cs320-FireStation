
package edu.ycp.CS320.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.SQLException;

import java.text.*;     // Used for date formatting.

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimpleRadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import edu.ycp.CS320.server.DerbyDatabase;
import edu.ycp.CS320.shared.FireCalendarEvent;
import edu.ycp.CS320.shared.IPublisher;
import edu.ycp.CS320.shared.ISubscriber;

public class theCalendar extends Composite implements ISubscriber {

	private final AbsolutePanel absolutePanel = new AbsolutePanel();
	private DatePicker datePicker;
	private ListBox listBox;
	private InlineLabel lblDate;
	private InlineLabel numEvents;
	private int count;
	private FormPanel formPanel;
	private SimpleRadioButton simpleRadioButton;
	private SimpleRadioButton simpleRadioButton_1;
	private Button btnHomePage;

	@SuppressWarnings("deprecation")
	public theCalendar() {
		
		// DerbyDatabase db = new DerbyDatabase();	
		//final FireCalendarEvent fireCalendar = new FireCalendarEvent();
		
		this.formPanel = new FormPanel();
		absolutePanel.add(formPanel, 21, 269);
		formPanel.setSize("613px", "322px");
		
		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		formPanel.setWidget(absolutePanel_1);
		absolutePanel_1.setSize("712px", "321px");
		
		Label lblTitle = new Label("Title: ");
		absolutePanel_1.add(lblTitle, 25, 20);
		
		Label lblLocation = new Label("Location: ");
		absolutePanel_1.add(lblLocation, 25, 56);
		lblLocation.setSize("29px", "18px");
		
		Label lblStartTime = new Label("Start Time: ");
		absolutePanel_1.add(lblStartTime, 25, 91);
		lblStartTime.setSize("74px", "18px");
		
		Label lblEndTime = new Label("End Time: ");
		absolutePanel_1.add(lblEndTime, 25, 125);
		lblEndTime.setSize("74px", "18px");
		
		Label lblNotes = new Label("Notes: ");
		absolutePanel_1.add(lblNotes, 25, 200);
		
		Label lblAlert = new Label("Alert:");
		absolutePanel_1.add(lblAlert, 25, 165);
		
		this.simpleRadioButton = new SimpleRadioButton("");
		simpleRadioButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				simpleRadioButton_1.setChecked(false);
			}
		});
		simpleRadioButton.setChecked(true);
		absolutePanel_1.add(simpleRadioButton, 80, 167);
		
		Label lblNone = new Label("None");
		absolutePanel_1.add(lblNone, 107, 165);
		lblNone.setSize("38px", "18px");
		
		this.simpleRadioButton_1 = new SimpleRadioButton("");
		simpleRadioButton_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				simpleRadioButton.setChecked(false);
				
			}
		});
		absolutePanel_1.add(simpleRadioButton_1, 163, 167);
		simpleRadioButton_1.setSize("21px", "16px");
		
		Label lblEmail = new Label("Email");
		absolutePanel_1.add(lblEmail, 190, 165);
		lblEmail.setSize("38px", "18px");
		
		TextArea textArea = new TextArea();
		absolutePanel_1.add(textArea, 35, 224);
		textArea.setSize("413px", "73px");
		
		Button btnNewButton = new Button("Add Event");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// send the information to the database
				formPanel.setVisible(false);
				//addFireCalendarEventToDB(final FireCalendarEvent fireCalendar)
				
			}
		});
		absolutePanel_1.add(btnNewButton, 508, 281);
		
		TextBox textBox = new TextBox();
		absolutePanel_1.add(textBox, 94, 8);
		textBox.setSize("159px", "18px");
		
		ListBox comboBox = new ListBox();
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.addItem("11");
		comboBox.addItem("12");
		absolutePanel_1.add(comboBox, 105, 91);
		comboBox.setSize("44px", "22px");
		
		ListBox listBox_1 = new ListBox();
		listBox_1.addItem("1");
		listBox_1.addItem("2");
		listBox_1.addItem("3");
		listBox_1.addItem("4");
		listBox_1.addItem("5");
		listBox_1.addItem("6");
		listBox_1.addItem("7");
		listBox_1.addItem("8");
		listBox_1.addItem("9");
		listBox_1.addItem("10");
		listBox_1.addItem("11");
		listBox_1.addItem("12");
		absolutePanel_1.add(listBox_1, 105, 121);
		listBox_1.setSize("44px", "22px");
		
		ListBox listBox_2 = new ListBox();
		listBox_2.addItem("00");
		listBox_2.addItem("05");
		listBox_2.addItem("10");
		listBox_2.addItem("15");
		listBox_2.addItem("20");
		listBox_2.addItem("25");
		listBox_2.addItem("30");
		listBox_2.addItem("35");
		listBox_2.addItem("40");
		listBox_2.addItem("45");
		listBox_2.addItem("50");
		listBox_2.addItem("55");
		absolutePanel_1.add(listBox_2, 184, 91);
		listBox_2.setSize("44px", "22px");
		
		ListBox listBox_3 = new ListBox();
		listBox_3.addItem("00");
		listBox_3.addItem("05");
		listBox_3.addItem("10");
		listBox_3.addItem("15");
		listBox_3.addItem("20");
		listBox_3.addItem("25");
		listBox_3.addItem("30");
		listBox_3.addItem("35");
		listBox_3.addItem("40");
		listBox_3.addItem("45");
		listBox_3.addItem("50");
		listBox_3.addItem("55");
		absolutePanel_1.add(listBox_3, 184, 121);
		listBox_3.setSize("44px", "22px");
		
		ListBox listBox_4 = new ListBox();
		listBox_4.addItem("AM");
		listBox_4.addItem("PM");
		absolutePanel_1.add(listBox_4, 255, 91);
		listBox_4.setSize("54px", "22px");
		
		ListBox listBox_5 = new ListBox();
		listBox_5.addItem("AM");
		listBox_5.addItem("PM");
		absolutePanel_1.add(listBox_5, 255, 121);
		listBox_5.setSize("54px", "22px");
		
		Label label = new Label(":");
		absolutePanel_1.add(label, 163, 91);
		
		Label label_1 = new Label(":");
		absolutePanel_1.add(label_1, 163, 125);
		label_1.setSize("4px", "18px");
		
		TextBox textBox_1 = new TextBox();
		absolutePanel_1.add(textBox_1, 94, 44);
		textBox_1.setSize("159px", "18px");
		
		formPanel.setVisible(false);
		
		count = 0;
		initWidget(absolutePanel);
		absolutePanel.setSize("822px", "601px");

		Button btnAddEvent = new Button("Add Event");
		btnAddEvent.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				// this is to add events to the calendar
				formPanel.setVisible(true);		
				
				//	db.addFireCalendarEventToDB( fireCalendar);
				
			}
		});
		absolutePanel.add(btnAddEvent, 90, 233);

		Button btnDeleteEvent = new Button("Delete Event");
		btnDeleteEvent.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				// this is to remove the events from the calendar
				int index = listBox.getSelectedIndex();
				listBox.removeItem(index);
				formPanel.setVisible(false);
				listBox.setSelectedIndex(-1);
				count--;
				numEvents.setText(Integer.toString(count));
				
			}
		});
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

		listBox.setVisibleItemCount(4);		
		
		

		this.datePicker = new DatePicker();
		datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {

			@SuppressWarnings("unused")
			private String nEvents;

			public void onValueChange(ValueChangeEvent<Date> event) {
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date date1 = datePicker.getValue();
				//count++;
				lblDate.setText(dateFormat.format(date1));
				//this.nEvents = numEvents.getText(); // this is be updated when
			
				//	listBox.addItem(count + " Events Today");
				//	numEvents.setText(Integer.toString(count));
				

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
		
		btnHomePage = new Button("Home Page");
		absolutePanel.add(btnHomePage, 698, 10);
		
		btnHomePage.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Ycp_cs320_project_ui.setView(new HomePageView());				
			}
		});
	}
	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {

	}
}

