package edu.ycp.CS320.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Unit;

public class FormView extends Composite {
	private TextBox nameTextBox;	
	private TextBox pwTextBox;
	
	/**
	 * TODO: MODIFY DEMO VIEW ADD NEW USER BUTTON TO REDIRECT TO A FORM PAGE WHERE THEY CAN FILL OUT THEIR INFORMATION
	 * AND STORE IT INTO THE DATABASE INSTEAD OF CREATING A NEW ACCOUNT AND LOGGING IN ON THE SAME PAGE
	 * 
	 */
	FormView(){
		final LayoutPanel layout = new LayoutPanel();
		initWidget(layout);
		
		nameTextBox = new TextBox();
		nameTextBox.setText("");
		layout.add(nameTextBox);
		layout.setWidgetLeftWidth(nameTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(nameTextBox, 49.0, Unit.PX, 34.0, Unit.PX);
		
		pwTextBox = new TextBox();
		pwTextBox.setText("");
		layout.add(pwTextBox);
		layout.setWidgetLeftWidth(pwTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(pwTextBox, 117.0, Unit.PX, 34.0, Unit.PX);
		
		
	}
}
