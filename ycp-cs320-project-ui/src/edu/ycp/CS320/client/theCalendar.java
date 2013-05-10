package edu.ycp.CS320.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


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
import edu.ycp.CS320.shared.FireCalendar;
import edu.ycp.CS320.shared.FireCalendarEvent;
import edu.ycp.CS320.shared.IPublisher;
import edu.ycp.CS320.shared.ISubscriber;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;

/*
 * 
 * author Jake
 * 
 */
public class theCalendar extends Composite implements ISubscriber {

	private final AbsolutePanel absolutePanel = new AbsolutePanel();
	private DatePicker datePicker;
	private ListBox listBox;
	private InlineLabel lblDate;
	private InlineLabel numEvents;
	private int count;
	private int  counter;
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
	private String[] dates;
	private String[] events;
	private int[] tracker = new int[50];
	private int[] trackerID = new int[50];
	private int[] ids;
	private Label lblEventTitle;
	private Label lblEventLocation;
	private Label lblEventStartTime;
	private AbsolutePanel absolutePanel_2;
	private FormPanel formPanel_1;
	private Label lblEventNotes;
	private Label lblEventEndTime;
	private Label lblStatus;
	private AbsolutePanel absolutePanel_1;

	private boolean titleLegnth = false;

	@SuppressWarnings("deprecation")
	public theCalendar() {



		this.formPanel = new FormPanel();
		absolutePanel.add(formPanel, 21, 269);
		formPanel.setSize("613px", "322px");

		formPanel_1 = new FormPanel();
		absolutePanel.add(formPanel_1, 756, 74);
		formPanel_1.setSize("397px", "357px");

		absolutePanel_2 = new AbsolutePanel();
		formPanel_1.setWidget(absolutePanel_2);
		absolutePanel_2.setSize("100%", "357px");

		absolutePanel_1 = new AbsolutePanel();
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

		txtTitle = new TextBox();
		absolutePanel_1.add(txtTitle, 94, 8);
		txtTitle.setSize("159px", "18px");

		Button btnNewButton = new Button("Add Event"); // to add the actual event to the database.
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {			

			if (txtTitle.getText().isEmpty())
			{
				lblStatus.setText("Please Fill in a title");

			}
			else
			{
				formPanel.setVisible(false);					

			// get the information		
		final String title = txtTitle.getText();
		final String location = txtLocation.getText();
		final String date = lblDate.getText();
		final String notes = txtNotes.getText();	

		// get the starting information
		int Shourin = cmbStartHour.getSelectedIndex();
		int Sminin = cmbStartMinute.getSelectedIndex();
		int Stime = cmbStartTime.getSelectedIndex();
		final String StartTime = cmbStartHour.getItemText(Shourin) + " : "  + cmbStartMinute.getItemText(Sminin) + " " +  cmbStartTime.getItemText(Stime);

		// get the ending information
		int Ehourin = cmbEndHour.getSelectedIndex();
		int Eminin = cmbEndMinute.getSelectedIndex();
		int Etime = cmbEndTime.getSelectedIndex();
		final String EndTime = cmbEndHour.getItemText(Ehourin) +  " : "  + cmbEndMinute.getItemText(Eminin) + " " + cmbEndTime.getItemText(Etime);
		RPC.calenderService.addcalendar(new FireCalendar(new FireCalendarEvent(0, title, location, StartTime, EndTime, date,notes)),new AsyncCallback<Boolean>() {
					@Override
					public void onSuccess(Boolean result) {
					clear(); // clears the list Box
					getEvents(); // populates the events
					txtTitle.setText(""); txtLocation.setText(""); txtNotes.setText(""); 					
					}

					@Override
					public void onFailure(Throwable caught) {						
					}
				}); // ends the RPC call
			} // ends the if
			}// on click				
	}); // ends the event handler



		absolutePanel_1.add(btnNewButton, 508, 281);		
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

		lblStatus = new Label("");
		absolutePanel_1.add(lblStatus, 314, 8);

		formPanel.setVisible(false);
		formPanel_1.setVisible(false);

		count = 0;
		initWidget(absolutePanel);
		absolutePanel.setSize("1175px", "601px");
		getEvents();
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
				final int itemToRemove = trackerID[index];					
				RPC.calenderService.removeFireCalendarEvent(itemToRemove, new AsyncCallback<Boolean>() {
					@Override
					public void onSuccess(Boolean result) {	
						formPanel_1.setVisible(false);
						txtTitle.setText(""); txtLocation.setText(""); txtNotes.setText(""); 	
						clear(); // clears the info
						getEvents(); // gets the events from the calendar					
					}

					@Override
					public void onFailure(Throwable caught) {	
						//System.out.println("Could not Removed: "+ itemToRemove);
					}
				});
			}
		});
		absolutePanel.add(btnDeleteEvent, 256, 233);

		this.lblDate = new InlineLabel("");
		absolutePanel.add(lblDate, 549, 26);
		lblDate.setSize("102px", "20px");
		this.listBox = new ListBox();
		listBox.addDoubleClickHandler(new DoubleClickHandler() {
			public void onDoubleClick(DoubleClickEvent event) {

				if (listBox.getItemCount() > 0)
				{
				/// display the event details
				formPanel_1.setVisible(true);				

				RPC.calenderService.loadEvents(new AsyncCallback<ArrayList<FireCalendar>>() {

					@Override
					public void onSuccess(ArrayList<FireCalendar> fireCalendarEvents) {	
						int itemSelected = listBox.getSelectedIndex();

						if(fireCalendarEvents != null){	

						int index = tracker[itemSelected];	 // get the value at the tracker location		

							lblEventTitle.setText(fireCalendarEvents.get(index).getFireFireEvent().getTitle());
							lblEventLocation.setText(fireCalendarEvents.get(index).getFireFireEvent().getLocation());	
							lblEventStartTime.setText(fireCalendarEvents.get(index).getFireFireEvent().getStartTime());
							lblEventEndTime.setText(fireCalendarEvents.get(index).getFireFireEvent().getEndTime());
							lblEventNotes.setText(fireCalendarEvents.get(index).getFireFireEvent().getDescription());											
						}	

							fireCalendarEvents.clear();					

					}

					@Override
					public void onFailure(Throwable caught) {

					}
				});	

				}
			}


		});

		absolutePanel.add(listBox, 444, 74);
		listBox.setSize("267px", "155px");

		// sets the current date label to the current date
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// get current date time with Date()
		Date date = new Date();
		lblDate.setText(dateFormat.format(date));

		listBox.setVisibleItemCount(4);		


			// gets the date
		this.datePicker = new DatePicker();
		datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {

			@SuppressWarnings("unused")
			private String nEvents;

			public void onValueChange(ValueChangeEvent<Date> event) {

				// clears the text boxes
				lblEventTitle.setText("");
				lblEventLocation.setText("");
				lblEventStartTime.setText("");
				lblEventEndTime.setText("");
				lblEventNotes.setText("");			

				formPanel_1.setVisible(false);
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date date1 = datePicker.getValue();
				count = 0;
				numEvents.setText(Integer.toString(count));
				lblDate.setText(dateFormat.format(date1));
				clear();
				getEvents();
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


		InlineLabel nlnlblTitle = new InlineLabel("Title:");
		absolutePanel_2.add(nlnlblTitle, 10, 32);
		nlnlblTitle.setSize("49px", "18px");

		InlineLabel nlnlblLocation = new InlineLabel("Location: ");
		absolutePanel_2.add(nlnlblLocation, 10, 73);
		nlnlblLocation.setSize("62px", "18px");

		InlineLabel nlnlblStartTime = new InlineLabel("Start Time:");
		absolutePanel_2.add(nlnlblStartTime, 10, 114);
		nlnlblStartTime.setSize("83px", "18px");

		InlineLabel nlnlblEndTime = new InlineLabel("End Time:");
		absolutePanel_2.add(nlnlblEndTime, 10, 166);
		nlnlblEndTime.setSize("83px", "18px");

		InlineLabel nlnlblNotes = new InlineLabel("Notes:");
		absolutePanel_2.add(nlnlblNotes, 10, 209);
		nlnlblNotes.setSize("83px", "18px");

		lblEventTitle = new Label("");
		absolutePanel_2.add(lblEventTitle, 63, 32);
		lblEventTitle.setSize("221px", "27px");

		lblEventLocation = new Label("");
		absolutePanel_2.add(lblEventLocation, 78, 73);
		lblEventLocation.setSize("221px", "27px");

		lblEventStartTime = new Label("");
		absolutePanel_2.add(lblEventStartTime, 78, 115);
		lblEventStartTime.setSize("221px", "27px");

		lblEventEndTime = new Label("");
		absolutePanel_2.add(lblEventEndTime, 78, 166);
		lblEventEndTime.setSize("221px", "27px");

		lblEventNotes = new Label("");
		absolutePanel_2.add(lblEventNotes, 63, 209);
		lblEventNotes.setSize("299px", "119px");

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

	public void clear()
	{
		// clear everything
		listBox.clear();
		count = 0;
		counter = 0;
		numEvents.setText(Integer.toString(count));
		int length = events.length;

		for(int i =0; i< length; i++)
		{
			events[i] = "";
			dates[i] = "";
			ids[i] = 0;
			tracker[i] = 0;		
		}
	}

	//this gets changed to load the info from the database
	private void getEvents() {		

		RPC.calenderService.loadEvents(new AsyncCallback<ArrayList<FireCalendar>>() {

			@Override
			public void onSuccess(ArrayList<FireCalendar> fireCalendarEvents) {	

				 events = new String[fireCalendarEvents.size()];
				 dates = new String[fireCalendarEvents.size()];
				 ids = new int[fireCalendarEvents.size()];
				if(fireCalendarEvents != null){	
					for(int i=0; i<fireCalendarEvents.size(); i++){	

							// gets the event title and stores it in the events array
						String Events = (fireCalendarEvents.get(i).getFireFireEvent().getTitle());					
						events[i] = Events;	

						// gets the dates and stores them in the date array
						String Dates = (fireCalendarEvents.get(i).getFireFireEvent().getDate());
						dates[i] = Dates;

						// gets the ID and stores it in the ID array
						int IDS = (fireCalendarEvents.get(i).getFireFireEvent().getId());
						ids[i] = IDS;
						}
				}
					// this matches the dates and displays them
					for(int j = 0; j < dates.length; j++)
					{

						if(dates[j].equals(lblDate.getText()))
						{
							listBox.addItem(events[j]);		
							count++;	
							numEvents.setText(Integer.toString(count));

							tracker[counter] = j ; // keeps track of the values going into the list
							trackerID[counter] = ids[j] ; // keeps track of the IDS going into the list

							counter++;
						}			
					}	

					fireCalendarEvents.clear();


			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});	 // ends the RPC call		
	} // ends the function
}