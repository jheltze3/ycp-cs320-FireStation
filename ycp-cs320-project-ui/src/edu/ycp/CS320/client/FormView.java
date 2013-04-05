
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
	private TextBox cellTextBox;
	private Label nameLabel;
	private Label cellLabel;
	
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
		
		cellLabel = new Label();
		cellLabel.setText("Cell Phone: ");
		layout.add(cellLabel);
		layout.setWidgetLeftWidth(cellLabel, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(cellLabel, 90.0, Unit.PX, 24.0, Unit.PX);
		
		cellTextBox = new TextBox();
		cellTextBox.setText("");
		layout.add(cellTextBox);
		layout.setWidgetLeftWidth(cellTextBox, 86.0, Unit.PX, 173.0, Unit.PX);
		layout.setWidgetTopHeight(cellTextBox, 117.0, Unit.PX, 34.0, Unit.PX);
		
		//TODO: create contact info from textbox info
		
		
	}
}

