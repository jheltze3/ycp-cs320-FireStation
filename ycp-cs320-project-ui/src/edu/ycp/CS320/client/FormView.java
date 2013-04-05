
package edu.ycp.CS320.client;


import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Unit;



import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Unit;

public class FormView extends Composite {
	private TextBox nameTextBox;	
	private TextBox pwTextBox;
	private Label nameLabel;
	private Label pwLabel;
	
	/**
	 * TODO: MODIFY DEMO VIEW ADD NEW USER BUTTON TO REDIRECT TO A FORM PAGE WHERE THEY CAN FILL OUT THEIR INFORMATION
	 * AND STORE IT INTO THE DATABASE INSTEAD OF CREATING A NEW ACCOUNT AND LOGGING IN ON THE SAME PAGE
	 * 
	 */
	FormView(){
		final LayoutPanel layout = new LayoutPanel();
		initWidget(layout);
		
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
		
		pwLabel = new Label();
		pwLabel.setText("Password: ");
		layout.add(pwLabel);
		layout.setWidgetLeftWidth(pwLabel, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(pwLabel, 90.0, Unit.PX, 24.0, Unit.PX);
		
		pwTextBox = new TextBox();
		pwTextBox.setText("");
		layout.add(pwTextBox);
		layout.setWidgetLeftWidth(pwTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(pwTextBox, 117.0, Unit.PX, 34.0, Unit.PX);
		
		
	}
}

