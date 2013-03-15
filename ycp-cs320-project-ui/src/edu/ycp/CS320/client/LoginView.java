package edu.ycp.CS320.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.CS320.shared.Station;

public class LoginView extends Composite {
	private InlineLabel usernameLabel;
	private InlineLabel passwordLabel;
	private Station station;

	public LoginView(){
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		
		usernameLabel = new InlineLabel("Username:");
		layoutPanel.add(usernameLabel);
		layoutPanel.setWidgetLeftWidth(usernameLabel, 43.0, Unit.PX, 64.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(usernameLabel, 57.0, Unit.PX, 18.0, Unit.PX);
		
		passwordLabel = new InlineLabel("Password:");
		layoutPanel.add(passwordLabel);
		layoutPanel.setWidgetLeftWidth(passwordLabel, 43.0, Unit.PX, 64.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(passwordLabel, 81.0, Unit.PX, 18.0, Unit.PX);
		
		TextBox usernameTextBox = new TextBox();
		layoutPanel.add(usernameTextBox);
		usernameTextBox.setSize("160", "25");
		layoutPanel.setWidgetLeftWidth(usernameTextBox, 107.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(usernameTextBox, 57.0, Unit.PX, 25.0, Unit.PX);
		
		TextBox passwordTextBox = new TextBox();
		layoutPanel.add(passwordTextBox);
		passwordTextBox.setSize("160", "25");
		layoutPanel.setWidgetLeftWidth(passwordTextBox, 107.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(passwordTextBox, 81.0, Unit.PX, 25.0, Unit.PX);
	}

	public void setModel(Station model) {
		this.station = model;  		
	}

	public void update() {
		
	}
}
