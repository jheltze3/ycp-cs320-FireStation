package edu.ycp.CS320.client;


import com.google.gwt.user.client.rpc.AsyncCallback;
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

import edu.ycp.CS320.shared.ContactInfo;
import edu.ycp.CS320.shared.Form;

public class FormView extends Composite {
	private TextBox nameTextBox;	
	private Label nameLabel;
	private Button backButton;
	private Label lblPrimaryCarePhysician;
	private Label lblPhysiciansContactNumber;
	private TextBox physicianContactNumberTextBox;
	private Label lblMedicalForms;
	private TextBox primCarePhysicianTextBox;		
	private TextBox textBoxAddress;
	private TextBox preferredNumberBox;
	private TextBox cellPhoneBox;
	private TextBox homePhoneBox;
	private TextBox contactNameBox;
	private Label lblSubmitStatus;
	
	public FormView(){
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
		
		Label lblContactName = new Label("Name:");
		layout.add(lblContactName);
		layout.setWidgetLeftWidth(lblContactName, 424.0, Unit.PX, 56.0, Unit.PX);
		layout.setWidgetTopHeight(lblContactName, 116.0, Unit.PX, 18.0, Unit.PX);
		
		contactNameBox = new TextBox();
		layout.add(contactNameBox);
		layout.setWidgetLeftWidth(contactNameBox, 424.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(contactNameBox, 146.0, Unit.PX, 34.0, Unit.PX);
		
		homePhoneBox = new TextBox();
		layout.add(homePhoneBox);
		layout.setWidgetLeftWidth(homePhoneBox, 424.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(homePhoneBox, 216.0, Unit.PX, 34.0, Unit.PX);
		
		cellPhoneBox = new TextBox();
		layout.add(cellPhoneBox);
		layout.setWidgetLeftWidth(cellPhoneBox, 424.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(cellPhoneBox, 280.0, Unit.PX, 34.0, Unit.PX);
		
		preferredNumberBox = new TextBox();
		layout.add(preferredNumberBox);
		layout.setWidgetLeftWidth(preferredNumberBox, 424.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(preferredNumberBox, 351.0, Unit.PX, 34.0, Unit.PX);
		
		Label lblHomePhone = new Label("Home Phone");
		layout.add(lblHomePhone);
		layout.setWidgetLeftWidth(lblHomePhone, 424.0, Unit.PX, 83.0, Unit.PX);
		layout.setWidgetTopHeight(lblHomePhone, 186.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblCellPhone = new Label("Cell phone");
		layout.add(lblCellPhone);
		layout.setWidgetLeftWidth(lblCellPhone, 424.0, Unit.PX, 71.0, Unit.PX);
		layout.setWidgetTopHeight(lblCellPhone, 256.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblPreferredNumber = new Label("Preferred Number:");
		layout.add(lblPreferredNumber);
		layout.setWidgetLeftWidth(lblPreferredNumber, 424.0, Unit.PX, 123.0, Unit.PX);
		layout.setWidgetTopHeight(lblPreferredNumber, 327.0, Unit.PX, 18.0, Unit.PX);
		
		Button btnSubmitMedicalInfo = new Button("SUBMIT");
		btnSubmitMedicalInfo.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Form form = new Form();
				ContactInfo contactInfo = new ContactInfo();
				
				form.setAddress(textBoxAddress.getText());
				form.setName(nameTextBox.getText());
				form.setDoctor(primCarePhysicianTextBox.getText());
				form.setDoctorPhone(physicianContactNumberTextBox.getText());
				
				contactInfo.setName(contactNameBox.getText());
				contactInfo.setHomephoneNumber(homePhoneBox.getText());
				contactInfo.setCellphoneNumber(cellPhoneBox.getText());
				
				
				RPC.formService.addForms(form, new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						lblSubmitStatus.setText("Successfully submitted");
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						lblSubmitStatus.setText("Failed to submit");
						
					}
				});
				
				
			}
		});
		btnSubmitMedicalInfo.setText("SUBMIT MEDICAL INFO");
		layout.add(btnSubmitMedicalInfo);
		layout.setWidgetLeftWidth(btnSubmitMedicalInfo, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(btnSubmitMedicalInfo, 473.0, Unit.PX, 30.0, Unit.PX);
		
		textBoxAddress = new TextBox();
		layout.add(textBoxAddress);
		layout.setWidgetLeftWidth(textBoxAddress, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(textBoxAddress, 216.0, Unit.PX, 34.0, Unit.PX);
		
		Label lblAddress = new Label("Address:");
		layout.add(lblAddress);
		layout.setWidgetLeftWidth(lblAddress, 86.0, Unit.PX, 83.0, Unit.PX);
		layout.setWidgetTopHeight(lblAddress, 186.0, Unit.PX, 18.0, Unit.PX);
		
		Button btnSubmitContactInfo = new Button("New button");
		btnSubmitContactInfo.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ContactInfo contact = new ContactInfo();
				contact.setCellphoneNumber(cellPhoneBox.getText());
				contact.setHomephoneNumber(homePhoneBox.getText());
				contact.setName(contactNameBox.getText());
				
				//TODO: implement contact service
				
			}
		});
		btnSubmitContactInfo.setText("SUBMIT CONTACT INFO");
		layout.add(btnSubmitContactInfo);
		layout.setWidgetLeftWidth(btnSubmitContactInfo, 424.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(btnSubmitContactInfo, 473.0, Unit.PX, 30.0, Unit.PX);
		
		lblSubmitStatus = new Label("Submit Status: ");
		layout.add(lblSubmitStatus);
		layout.setWidgetLeftWidth(lblSubmitStatus, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(lblSubmitStatus, 539.0, Unit.PX, 18.0, Unit.PX);
		
		backButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Ycp_cs320_project_ui.setView(new HomePageView());
			}
		});
		
		
		
		
	}
}
