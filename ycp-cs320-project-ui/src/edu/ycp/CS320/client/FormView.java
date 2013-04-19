package edu.ycp.CS320.client;


import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Unit;



import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class FormView extends Composite {
	private TextBox nameTextBox;	
	private TextBox cellTextBox;
	private Label nameLabel;
	private Label idLabel;
	private Button backButton;
	private Label lblPrimaryCarePhysician;
	private Label lblPhysiciansContactNumber;
	private TextBox physicianContactNumberTextBox;
	private Label lblMedicalForms;
	private TextBox primCarePhysicianTextBox;		
	
	FormView(){
		final LayoutPanel layout = new LayoutPanel();
		initWidget(layout);
		layout.setSize("931px", "606px");
		
		nameLabel = new Label();
		nameLabel.setText("Name: ");
		layout.add(nameLabel);
		layout.setWidgetLeftWidth(nameLabel, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(nameLabel, 116.0, Unit.PX, 24.0, Unit.PX);
		
		nameTextBox = new TextBox();
		nameTextBox.setText("");
		layout.add(nameTextBox);
		layout.setWidgetLeftWidth(nameTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(nameTextBox, 146.0, Unit.PX, 34.0, Unit.PX);
		
		idLabel = new Label();
		idLabel.setText("Employee ID:");
		layout.add(idLabel);
		layout.setWidgetLeftWidth(idLabel, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(idLabel, 186.0, Unit.PX, 24.0, Unit.PX);
		
		cellTextBox = new TextBox();
		cellTextBox.setText("");
		layout.add(cellTextBox);
		layout.setWidgetLeftWidth(cellTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(cellTextBox, 216.0, Unit.PX, 34.0, Unit.PX);
		
		backButton = new Button("Home Page");
		layout.add(backButton);
		layout.setWidgetLeftWidth(backButton, 784.0, Unit.PX, 102.0, Unit.PX);
		layout.setWidgetTopHeight(backButton, 40.0, Unit.PX, 30.0, Unit.PX);
		
		primCarePhysicianTextBox = new TextBox();
		layout.add(primCarePhysicianTextBox);
		layout.setWidgetLeftWidth(primCarePhysicianTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(primCarePhysicianTextBox, 280.0, Unit.PX, 34.0, Unit.PX);
		
		lblPrimaryCarePhysician = new Label("Primary Care Physician:");
		layout.add(lblPrimaryCarePhysician);
		layout.setWidgetLeftWidth(lblPrimaryCarePhysician, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(lblPrimaryCarePhysician, 256.0, Unit.PX, 18.0, Unit.PX);
		
		lblPhysiciansContactNumber = new Label("Physician's Contact Number:");
		layout.add(lblPhysiciansContactNumber);
		layout.setWidgetLeftWidth(lblPhysiciansContactNumber, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(lblPhysiciansContactNumber, 327.0, Unit.PX, 18.0, Unit.PX);
		
		physicianContactNumberTextBox = new TextBox();
		layout.add(physicianContactNumberTextBox);
		layout.setWidgetLeftWidth(physicianContactNumberTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(physicianContactNumberTextBox, 351.0, Unit.PX, 34.0, Unit.PX);
		
		lblMedicalForms = new Label("Medical Info");
		layout.add(lblMedicalForms);
		layout.setWidgetLeftWidth(lblMedicalForms, 86.0, Unit.PX, 139.0, Unit.PX);
		layout.setWidgetTopHeight(lblMedicalForms, 92.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblContactInfo = new Label("Contact Info");
		layout.add(lblContactInfo);
		layout.setWidgetLeftWidth(lblContactInfo, 424.0, Unit.PX, 83.0, Unit.PX);
		layout.setWidgetTopHeight(lblContactInfo, 92.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblName = new Label("Name:");
		layout.add(lblName);
		layout.setWidgetLeftWidth(lblName, 424.0, Unit.PX, 56.0, Unit.PX);
		layout.setWidgetTopHeight(lblName, 116.0, Unit.PX, 18.0, Unit.PX);
		
		TextBox textBox = new TextBox();
		layout.add(textBox);
		layout.setWidgetLeftWidth(textBox, 424.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(textBox, 146.0, Unit.PX, 34.0, Unit.PX);
		
		TextBox textBox_1 = new TextBox();
		layout.add(textBox_1);
		layout.setWidgetLeftWidth(textBox_1, 424.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(textBox_1, 216.0, Unit.PX, 34.0, Unit.PX);
		
		TextBox textBox_2 = new TextBox();
		layout.add(textBox_2);
		layout.setWidgetLeftWidth(textBox_2, 424.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(textBox_2, 280.0, Unit.PX, 34.0, Unit.PX);
		
		TextBox textBox_3 = new TextBox();
		layout.add(textBox_3);
		layout.setWidgetLeftWidth(textBox_3, 424.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(textBox_3, 351.0, Unit.PX, 34.0, Unit.PX);
		
		Label lblNewLabel = new Label("Home Phone");
		layout.add(lblNewLabel);
		layout.setWidgetLeftWidth(lblNewLabel, 424.0, Unit.PX, 83.0, Unit.PX);
		layout.setWidgetTopHeight(lblNewLabel, 186.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblNewLabel_1 = new Label("Cell phone");
		layout.add(lblNewLabel_1);
		layout.setWidgetLeftWidth(lblNewLabel_1, 424.0, Unit.PX, 71.0, Unit.PX);
		layout.setWidgetTopHeight(lblNewLabel_1, 256.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblNewLabel_2 = new Label("Preferred Number:");
		layout.add(lblNewLabel_2);
		layout.setWidgetLeftWidth(lblNewLabel_2, 424.0, Unit.PX, 123.0, Unit.PX);
		layout.setWidgetTopHeight(lblNewLabel_2, 327.0, Unit.PX, 18.0, Unit.PX);
		
		Button btnSubmit = new Button("SUBMIT");
		btnSubmit.setText("SUBMIT ANY INFO");
		layout.add(btnSubmit);
		layout.setWidgetLeftWidth(btnSubmit, 384.0, Unit.PX, 163.0, Unit.PX);
		layout.setWidgetTopHeight(btnSubmit, 479.0, Unit.PX, 30.0, Unit.PX);
		
		backButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Ycp_cs320_project_ui.setView(new HomePageView());
			}
		});
		
		//TODO: create contact info from textbox info
		
		
	}
}
