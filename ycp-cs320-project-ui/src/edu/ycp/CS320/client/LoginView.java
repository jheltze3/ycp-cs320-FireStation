package edu.ycp.CS320.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.CS320.server.DerbyDatabase;
import edu.ycp.CS320.shared.IPublisher;
import edu.ycp.CS320.shared.ISubscriber;
import edu.ycp.CS320.shared.User;

//mws

public class LoginView extends Composite implements ISubscriber {	
	
	private Button btnLogIn = new Button("Log In");
	private Button btnNewUser = new Button("New User?");
	public TextBox username = new TextBox();
	private PasswordTextBox passwordTextBox = new PasswordTextBox();
	private Label lblLoginStatus = new Label("Log in or Create a new Account");		
	
	public LoginView() {			
		/**
		 * 
		 * widgets
		 * 
		 */		
		final LayoutPanel layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("fireStation-panelBackground");

		initWidget(layoutPanel);		
		layoutPanel.setSize("870px", "432px");



		
		Label lblWelcomeToYork = new Label("Welcome To York Fire Station");
		lblWelcomeToYork.setStyleName("Title");
		lblWelcomeToYork.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		layoutPanel.add(lblWelcomeToYork);
		layoutPanel.setWidgetLeftWidth(lblWelcomeToYork, 333.0, Unit.PX, 269.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblWelcomeToYork, 17.0, Unit.PX, 25.0, Unit.PX);		
		
		layoutPanel.add(lblLoginStatus);
		layoutPanel.setWidgetLeftWidth(lblLoginStatus, 240, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblLoginStatus, 180, Unit.PX, 105.0, Unit.PX);
		
		Label lblUsername = new Label("Username:");
		layoutPanel.add(lblUsername);
		layoutPanel.setWidgetLeftWidth(lblUsername, 269.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblUsername, 90.0, Unit.PX, 34.0, Unit.PX);
		
		InlineLabel nlnlblPassword = new InlineLabel("Password:");
		layoutPanel.add(nlnlblPassword);
		layoutPanel.setWidgetLeftWidth(nlnlblPassword, 269.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(nlnlblPassword, 141.0, Unit.PX, 33.0, Unit.PX);
		
		
		layoutPanel.add(username);

		layoutPanel.setWidgetLeftWidth(username, 341.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(username, 96.0, Unit.PX, 34.0, Unit.PX);		

		layoutPanel.setWidgetLeftWidth(username, 364.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(username, 90.0, Unit.PX, 34.0, Unit.PX);		

		
		layoutPanel.add(passwordTextBox);
		layoutPanel.setWidgetLeftWidth(passwordTextBox, 364.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(passwordTextBox, 141.0, Unit.PX, 34.0, Unit.PX);		
		
		layoutPanel.add(btnLogIn);
		layoutPanel.setWidgetLeftWidth(btnLogIn, 447.0, Unit.PX, 90.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnLogIn, 200.0, Unit.PX, 34.0, Unit.PX);		
		
		btnLogIn.addClickHandler(new ClickHandler() {

			
			/* (non-Javadoc)
			 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
			 * 
			 * this method creates a local User object this is used to login to the system
			 * an async callback is created that will confirm if the RPC was successful or not
			 * 
			 */
			@Override
			public void onClick(ClickEvent event) {
				User user = new User();
				user.setUsername(getUsername());
				user.setPassword(passwordTextBox.getText());
				RPC.loginService.login(user, new AsyncCallback<Boolean>() {		
					
					@Override
					public void onSuccess(Boolean result) {
						if(result == true){
							lblLoginStatus.setText("Logged In");
							//if you successfully login, go to the homepage
				
							Ycp_cs320_project_ui.setView(new HomePageView());
						}
					
						else{
							lblLoginStatus.setText("Fail");							
						}
					}
					
					@Override
					public void onFailure(Throwable caught) {
						lblLoginStatus.setText("Could not Log In");						
					}
				});
			}			
			
		});
		layoutPanel.add(btnNewUser);
		layoutPanel.setWidgetLeftWidth(btnNewUser, 447.0, Unit.PX, 90.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnNewUser, 249.0, Unit.PX, 36.0, Unit.PX);	
		
		
		btnNewUser.addClickHandler(new ClickHandler() {
			
			/* (non-Javadoc)
			 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
			 * 
			 * if the user does not have an account yet they can click this button to create a User object that is
			 * added to the database. From then on they will be able to use the regular login button.
			 */
			@Override
			public void onClick(ClickEvent event) {
				User user = new User();
				user.setUsername(getUsername());
				user.setPassword(passwordTextBox.getText());
				
				RPC.loginService.addNewUser(user, new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						lblLoginStatus.setText("Failed to add");
						
					}

					@Override
					public void onSuccess(Boolean result) {
						if(result == true){
							lblLoginStatus.setText("New user added");
						}
						else{
							lblLoginStatus.setText("User already exists");
						}
						
					}
				});
				
			}
			
			
		});
	}

	/* (non-Javadoc)
	 * @see edu.ycp.CS320.shared.ISubscriber#eventOccurred(java.lang.Object, edu.ycp.CS320.shared.IPublisher, java.lang.Object)
	 * 
	 * TODO: implement subscribing/publishing events
	 */
	
	
	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {		
		
	}

	public String getUsername() {
		return username.getText();
	}

	
}
