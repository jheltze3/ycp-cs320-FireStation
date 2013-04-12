package edu.ycp.CS320.client;


import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Unit;



import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
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
		layout.setWidgetTopHeight(nameLabel, 30.0, Unit.PX, 24.0, Unit.PX);
		
		nameTextBox = new TextBox();
		nameTextBox.setText("");
		layout.add(nameTextBox);
		layout.setWidgetLeftWidth(nameTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(nameTextBox, 49.0, Unit.PX, 34.0, Unit.PX);
		
		idLabel = new Label();
		idLabel.setText("Employee ID:");
		layout.add(idLabel);
		layout.setWidgetLeftWidth(idLabel, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(idLabel, 90.0, Unit.PX, 24.0, Unit.PX);
		
		cellTextBox = new TextBox();
		cellTextBox.setText("");
		layout.add(cellTextBox);
		layout.setWidgetLeftWidth(cellTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(cellTextBox, 117.0, Unit.PX, 34.0, Unit.PX);
		
		backButton = new Button("Home Page");
		layout.add(backButton);
		layout.setWidgetLeftWidth(backButton, 572.0, Unit.PX, 102.0, Unit.PX);
		layout.setWidgetTopHeight(backButton, 49.0, Unit.PX, 30.0, Unit.PX);
		
		primCarePhysicianTextBox = new TextBox();
		layout.add(primCarePhysicianTextBox);
		layout.setWidgetLeftWidth(primCarePhysicianTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(primCarePhysicianTextBox, 181.0, Unit.PX, 34.0, Unit.PX);
		
		lblPrimaryCarePhysician = new Label("Primary Care Physician:");
		layout.add(lblPrimaryCarePhysician);
		layout.setWidgetLeftWidth(lblPrimaryCarePhysician, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(lblPrimaryCarePhysician, 157.0, Unit.PX, 18.0, Unit.PX);
		
		lblPhysiciansContactNumber = new Label("Physician's Contact Number:");
		layout.add(lblPhysiciansContactNumber);
		layout.setWidgetLeftWidth(lblPhysiciansContactNumber, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(lblPhysiciansContactNumber, 221.0, Unit.PX, 18.0, Unit.PX);
		
		physicianContactNumberTextBox = new TextBox();
		layout.add(physicianContactNumberTextBox);
		layout.setWidgetLeftWidth(physicianContactNumberTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(physicianContactNumberTextBox, 245.0, Unit.PX, 34.0, Unit.PX);
		
		lblMedicalForms = new Label("Medical Forms");
		layout.add(lblMedicalForms);
		layout.setWidgetLeftWidth(lblMedicalForms, 409.0, Unit.PX, 139.0, Unit.PX);
		layout.setWidgetTopHeight(lblMedicalForms, 15.0, Unit.PX, 18.0, Unit.PX);
		
		backButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Ycp_cs320_project_ui.setView(new HomePageView());
			}
		});
		
		//TODO: create contact info from textbox info
		
		
	}
}
