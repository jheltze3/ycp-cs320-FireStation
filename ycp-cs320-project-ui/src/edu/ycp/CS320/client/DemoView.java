package edu.ycp.CS320.client;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Button;

public class DemoView extends Composite {
	public DemoView() {
		
		LayoutPanel layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("fireStation-panelBackground");
		initWidget(layoutPanel);
		
		Label lblWelcomeToYork = new Label("Welcome To York Fire Station");
		lblWelcomeToYork.setStyleName("Title");
		lblWelcomeToYork.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		layoutPanel.add(lblWelcomeToYork);
		layoutPanel.setWidgetLeftWidth(lblWelcomeToYork, 333.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblWelcomeToYork, 17.0, Unit.PX, 25.0, Unit.PX);
		
		Label lblUsername = new Label("Username:");
		layoutPanel.add(lblUsername);
		layoutPanel.setWidgetLeftWidth(lblUsername, 269.0, Unit.PX, 62.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblUsername, 106.0, Unit.PX, 18.0, Unit.PX);
		
		InlineLabel nlnlblPassword = new InlineLabel("Password:");
		layoutPanel.add(nlnlblPassword);
		layoutPanel.setWidgetLeftWidth(nlnlblPassword, 269.0, Unit.PX, 66.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(nlnlblPassword, 141.0, Unit.PX, 18.0, Unit.PX);
		
		TextBox textBox = new TextBox();
		layoutPanel.add(textBox);
		layoutPanel.setWidgetLeftWidth(textBox, 341.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(textBox, 96.0, Unit.PX, 34.0, Unit.PX);
		
		PasswordTextBox passwordTextBox = new PasswordTextBox();
		layoutPanel.add(passwordTextBox);
		layoutPanel.setWidgetLeftWidth(passwordTextBox, 341.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(passwordTextBox, 136.0, Unit.PX, 34.0, Unit.PX);
		
		Button btnLogIn = new Button("Log In");
		layoutPanel.add(btnLogIn);
		layoutPanel.setWidgetLeftWidth(btnLogIn, 387.0, Unit.PX, 75.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnLogIn, 176.0, Unit.PX, 25.0, Unit.PX);
		
		Button btnNewUser = new Button("New User?");
		layoutPanel.add(btnNewUser);
		layoutPanel.setWidgetLeftWidth(btnNewUser, 387.0, Unit.PX, 90.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnNewUser, 207.0, Unit.PX, 25.0, Unit.PX);
	}
}

