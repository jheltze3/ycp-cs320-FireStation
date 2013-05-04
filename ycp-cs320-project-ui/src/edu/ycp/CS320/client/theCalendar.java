
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
import com.google.gwt.user.client.rpc.AsyncCallback;
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
import edu.ycp.CS320.shared.FireApparatusSpec;
import edu.ycp.CS320.shared.FireCalendar;
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
	private TextBox txtTitle;
	private TextBox txtLocation;
	private ListBox cmbStartHour;
	private ListBox cmbStartMinute;
	private ListBox cmbStartTime;
	private ListBox cmbEndHour;
	private ListBox cmbEndMinute;
	private TextArea txtNotes;
	private ListBox cmbEndTime;
	private Label lblStatus;

	@SuppressWarnings("deprecation")
	public theCalendar() {

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
		
		txtNotes = new TextArea();
		absolutePanel_1.add(txtNotes, 35, 224);
		txtNotes.setSize("413px", "73px");
		
		Button btnNewButton = new Button("Add Event");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// send the information to the database
				formPanel.setVisible(false);
				
				//	db.addFireCalendarEventToDB( fireCalendar);
				DerbyDatabase db = new DerbyDatabase();
					
					
			// get the information		
		final String title = txtTitle.getText();
		final String location = txtLocation.getText();
		final String date = lblDate.getText();
		final String notes = txtNotes.getText();	
		
		// get the starting information
		int Shourin = cmbStartHour.getSelectedIndex();
		int Sminin = cmbStartMinute.getSelectedIndex();
		int Stime = cmbStartTime.getSelectedIndex();
		final String StartTime = cmbStartHour.getItemText(Shourin) +  cmbStartMinute.getItemText(Sminin) + cmbStartTime.getItemText(Stime);
		
		// get the ending information
		int Ehourin = cmbEndHour.getSelectedIndex();
		int Eminin = cmbEndMinute.getSelectedIndex();
		int Etime = cmbEndTime.getSelectedIndex();
		final String EndTime = cmbEndHour.getItemText(Ehourin) +  cmbEndMinute.getItemText(Eminin) + cmbEndTime.getItemText(Etime);

				
		if (txtTitle.getText().equals(""))
				{
				lblStatus.setText("Please fill in title!");
			}
		
			else{					
				RPC.calenderService.addcalendar(new FireCalendar(new FireCalendarEvent(0, title, location, StartTime, EndTime, date,notes)),new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						lblStatus.setText("Failed to Add Event!");	
						
					}

					@Override
					public void onSuccess(Boolean result) {
						lblStatus.setText("Succesfully Added Event!");	
						//textBoxName.setText(""); textBoxMake.setText(""); textBoxModel.setText(""); textBoxYear.setText(""); textBoxType.setText(""); textBoxDescription.setText("");
						txtTitle.setText("");
						
						System.out.println(title+location+StartTime+EndTime+date+notes);
					}
				});
			}
			
		}
	});



		absolutePanel_1.add(btnNewButton, 508, 281);
		
		txtTitle = new TextBox();
		absolutePanel_1.add(txtTitle, 94, 8);
		txtTitle.setSize("159px", "18px");
		
		cmbStartHour = new ListBox();
		cmbStartHour.addItem("1");
		cmbStartHour.addItem("2");
		cmbStartHour.addItem("3");
		cmbStartHour.addItem("4");
		cmbStartHour.addItem("5");
		cmbStartHour.addItem("6");
		cmbStartHour.addItem("7");
		cmbStartHour.addItem("8");
		cmbStartHour.addItem("9");
		cmbStartHour.addItem("10");
		cmbStartHour.addItem("11");
		cmbStartHour.addItem("12");
		absolutePanel_1.add(cmbStartHour, 105, 91);
		cmbStartHour.setSize("44px", "22px");
		
		cmbEndHour = new ListBox();
		cmbEndHour.addItem("1");
		cmbEndHour.addItem("2");
		cmbEndHour.addItem("3");
		cmbEndHour.addItem("4");
		cmbEndHour.addItem("5");
		cmbEndHour.addItem("6");
		cmbEndHour.addItem("7");
		cmbEndHour.addItem("8");
		cmbEndHour.addItem("9");
		cmbEndHour.addItem("10");
		cmbEndHour.addItem("11");
		cmbEndHour.addItem("12");
		absolutePanel_1.add(cmbEndHour, 105, 121);
		cmbEndHour.setSize("44px", "22px");
		
		cmbStartMinute = new ListBox();
		cmbStartMinute.addItem("00");
		cmbStartMinute.addItem("05");
		cmbStartMinute.addItem("10");
		cmbStartMinute.addItem("15");
		cmbStartMinute.addItem("20");
		cmbStartMinute.addItem("25");
		cmbStartMinute.addItem("30");
		cmbStartMinute.addItem("35");
		cmbStartMinute.addItem("40");
		cmbStartMinute.addItem("45");
		cmbStartMinute.addItem("50");
		cmbStartMinute.addItem("55");
		absolutePanel_1.add(cmbStartMinute, 184, 91);
		cmbStartMinute.setSize("44px", "22px");
		
		cmbEndMinute = new ListBox();
		cmbEndMinute.addItem("00");
		cmbEndMinute.addItem("05");
		cmbEndMinute.addItem("10");
		cmbEndMinute.addItem("15");
		cmbEndMinute.addItem("20");
		cmbEndMinute.addItem("25");
		cmbEndMinute.addItem("30");
		cmbEndMinute.addItem("35");
		cmbEndMinute.addItem("40");
		cmbEndMinute.addItem("45");
		cmbEndMinute.addItem("50");
		cmbEndMinute.addItem("55");
		absolutePanel_1.add(cmbEndMinute, 184, 121);
		cmbEndMinute.setSize("44px", "22px");
		
		cmbStartTime = new ListBox();
		cmbStartTime.addItem("AM");
		cmbStartTime.addItem("PM");
		absolutePanel_1.add(cmbStartTime, 255, 91);
		cmbStartTime.setSize("54px", "22px");
		
		cmbEndTime = new ListBox();
		cmbEndTime.addItem("AM");
		cmbEndTime.addItem("PM");
		absolutePanel_1.add(cmbEndTime, 255, 121);
		cmbEndTime.setSize("54px", "22px");
		
		Label label = new Label(":");
		absolutePanel_1.add(label, 163, 91);
		
		Label label_1 = new Label(":");
		absolutePanel_1.add(label_1, 163, 125);
		label_1.setSize("4px", "18px");
		
		txtLocation = new TextBox();
		absolutePanel_1.add(txtLocation, 94, 44);
		txtLocation.setSize("159px", "18px");
		
		formPanel.setVisible(false);
		
		count = 0;
		initWidget(absolutePanel);
		absolutePanel.setSize("822px", "601px");

		Button btnAddEvent = new Button("Add Event");
		btnAddEvent.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				formPanel.setVisible(true);		
	
				
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
		
		lblStatus = new Label("44");
		absolutePanel.add(lblStatus, 653, 351);
		lblStatus.setSize("106px", "53px");
		
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

