package edu.ycp.CS320.client;

import java.util.ArrayList;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;

import edu.ycp.CS320.shared.ContactInfo;
import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireApparatusSpec;

import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.TextBox;


/**
 * @author drew
 *this is the homepage which the logged in user will see after clicking log in
 *right now it is lonely and needs features
 */
public class AddApparatusPageView extends Composite{
	private Button btnForms = new Button();
	private TextBox textBoxName;
	private TextBox textBoxMake;
	private TextBox textBoxModel;
	private TextBox textBoxYear;
	private TextBox textBoxType;
	private TextBox textBoxDescription;
	private Button btnSubmit;
	private String name;
	private String make;
	private String model;
	private String year;
	private String type;
	private String description;
	private Label labelStatus;
	
	public AddApparatusPageView(){

		final LayoutPanel layout = new LayoutPanel();
		layout.setStyleName("AddApparatusStyle");

		initWidget(layout);		
		layout.setSize("2200px", "1200px");
		Label InstructionLabel = new Label("Please fill in the information and hit submit.");		
		layout.add(InstructionLabel);
		layout.setWidgetLeftWidth(InstructionLabel, 0.0, Unit.PX, 450.0, Unit.PX);
		layout.setWidgetTopHeight(InstructionLabel, 0.0, Unit.PX, 63.0, Unit.PX);
		
		Label lblAddName = new Label("Add Fire Apparatus Name:");
		lblAddName.setStyleName("AddApparatusLabels");
		layout.add(lblAddName);
		layout.setWidgetLeftWidth(lblAddName, 0.0, Unit.PX, 184.0, Unit.PX);
		layout.setWidgetTopHeight(lblAddName, 100.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblAddMake = new Label("Add Make:");
		lblAddMake.setStyleName("AddApparatusLabels");
		layout.add(lblAddMake);
		layout.setWidgetLeftWidth(lblAddMake, 0.0, Unit.PX, 184.0, Unit.PX);
		layout.setWidgetTopHeight(lblAddMake, 140.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblAddModel = new Label("Add Model:");
		lblAddModel.setStyleName("AddApparatusLabels");
		layout.add(lblAddModel);
		layout.setWidgetLeftWidth(lblAddModel, 0.0, Unit.PX, 184.0, Unit.PX);
		layout.setWidgetTopHeight(lblAddModel, 180.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblAddYear = new Label("Add Year:");
		lblAddYear.setStyleName("AddApparatusLabels");
		layout.add(lblAddYear);
		layout.setWidgetLeftWidth(lblAddYear, 0.0, Unit.PX, 184.0, Unit.PX);
		layout.setWidgetTopHeight(lblAddYear, 220.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblAddType = new Label("Add Type:");
		lblAddType.setStyleName("AddApparatusLabels");
		layout.add(lblAddType);
		layout.setWidgetLeftWidth(lblAddType, 0.0, Unit.PX, 184.0, Unit.PX);
		layout.setWidgetTopHeight(lblAddType, 260.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblAddDescription = new Label("Add Description:");
		lblAddDescription.setStyleName("AddApparatusLabels");
		layout.add(lblAddDescription);
		layout.setWidgetLeftWidth(lblAddDescription, 0.0, Unit.PX, 184.0, Unit.PX);
		layout.setWidgetTopHeight(lblAddDescription, 300.0, Unit.PX, 18.0, Unit.PX);
		
		textBoxName = new TextBox();
		layout.add(textBoxName);
		layout.setWidgetLeftWidth(textBoxName, 190.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(textBoxName, 100.0, Unit.PX, 34.0, Unit.PX);
		textBoxName.getText();
		
		textBoxMake = new TextBox();
		layout.add(textBoxMake);
		layout.setWidgetLeftWidth(textBoxMake, 190.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(textBoxMake, 140.0, Unit.PX, 34.0, Unit.PX);
		
		textBoxModel = new TextBox();
		textBoxModel.setText("");
		layout.add(textBoxModel);
		layout.setWidgetLeftWidth(textBoxModel, 190.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(textBoxModel, 180.0, Unit.PX, 34.0, Unit.PX);
		
		textBoxYear = new TextBox();
		layout.add(textBoxYear);
		layout.setWidgetLeftWidth(textBoxYear, 190.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(textBoxYear, 220.0, Unit.PX, 34.0, Unit.PX);
		
		textBoxType = new TextBox();
		layout.add(textBoxType);
		layout.setWidgetLeftWidth(textBoxType, 190.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(textBoxType, 260.0, Unit.PX, 34.0, Unit.PX);
		
		textBoxDescription = new TextBox();
		layout.add(textBoxDescription);
		layout.setWidgetLeftWidth(textBoxDescription, 190.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(textBoxDescription, 300.0, Unit.PX, 34.0, Unit.PX);
		
		btnSubmit = new Button("Submit");
		btnSubmit.setStyleName("submitButton");
		layout.add(btnSubmit);
		layout.setWidgetLeftWidth(btnSubmit, 190.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(btnSubmit, 380.0, Unit.PX, 40.0, Unit.PX);
		
		labelStatus = new Label("");
		layout.add(labelStatus);
		layout.setWidgetLeftWidth(labelStatus, 369.0, Unit.PX, 212.0, Unit.PX);
		layout.setWidgetTopHeight(labelStatus, 380.0, Unit.PX, 40.0, Unit.PX);
		
		btnSubmit.addClickHandler(new ClickHandler() {
			

			@Override
			public void onClick(ClickEvent event) {
				this.GetText();				
			}

			private void GetText() {				
				if(textBoxName.getText().equals("")||textBoxMake.getText().equals("")||textBoxModel.getText().equals("")||textBoxYear.getText().equals("")||textBoxType.getText().equals("")||textBoxDescription.getText().equals("")){
					labelStatus.setText("Please fill in all Fire Apparatus details!");
				}
				else{					
					RPC.apparatusService.addApparatus(new FireApparatus(new FireApparatusSpec(textBoxMake.getText(), textBoxModel.getText(), textBoxName.getText(), Integer.parseInt(textBoxYear.getText()), textBoxType.getText(), textBoxDescription.getText())), new AsyncCallback<Boolean>() {
						@Override
						public void onSuccess(Boolean result) {		
							labelStatus.setText("Succesfully Added Fire Apparatus!");	
							textBoxName.setText(""); textBoxMake.setText(""); textBoxModel.setText(""); textBoxYear.setText(""); textBoxType.setText(""); textBoxDescription.setText("");
						}
						
						@Override
						public void onFailure(Throwable caught) {
							labelStatus.setText("Failed to Add Fire Apparatus!");							
						}
					});
				}
				
			}
		});
	}
}
