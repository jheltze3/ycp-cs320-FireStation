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

import edu.ycp.CS320.shared.IPublisher;
import edu.ycp.CS320.shared.ISubscriber;
import edu.ycp.CS320.shared.User;

//mws

public class LoginView extends Composite implements ISubscriber {
	
	private HomePageView homePage = new HomePageView();
	private Button btnLogIn = new Button("Log In");
	private Button btnNewUser = new Button("New User?");
	private TextBox textBox = new TextBox();
	private PasswordTextBox passwordTextBox = new PasswordTextBox();
	private Label lblLoginStatus = new Label("Log in or Create a new Account");	
	private Button btnTempHpage;

	
	
	
	public LoginView() {			
		/**
		 * 
		 * widgets
		 * 
		 */		
		final LayoutPanel layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("fireStation-panelBackground");
		initWidget(layoutPanel);		
		
		Label lblWelcomeToYork = new Label("Welcome To York Fire Station");
		lblWelcomeToYork.setStyleName("Title");
		lblWelcomeToYork.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		layoutPanel.add(lblWelcomeToYork);
		layoutPanel.setWidgetLeftWidth(lblWelcomeToYork, 333.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblWelcomeToYork, 17.0, Unit.PX, 25.0, Unit.PX);		
		
		layoutPanel.add(lblLoginStatus);
		layoutPanel.setWidgetLeftWidth(lblLoginStatus, 240, Unit.PX, 100, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblLoginStatus, 180, Unit.PX, 38, Unit.PX);
		
		Label lblUsername = new Label("Username:");
		layoutPanel.add(lblUsername);
		layoutPanel.setWidgetLeftWidth(lblUsername, 269.0, Unit.PX, 62.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblUsername, 106.0, Unit.PX, 18.0, Unit.PX);
		
		InlineLabel nlnlblPassword = new InlineLabel("Password:");
		layoutPanel.add(nlnlblPassword);
		layoutPanel.setWidgetLeftWidth(nlnlblPassword, 269.0, Unit.PX, 66.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(nlnlblPassword, 141.0, Unit.PX, 18.0, Unit.PX);
		
		
		layoutPanel.add(textBox);
		layoutPanel.setWidgetLeftWidth(textBox, 341.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(textBox, 96.0, Unit.PX, 34.0, Unit.PX);
		
		
		layoutPanel.add(passwordTextBox);
		layoutPanel.setWidgetLeftWidth(passwordTextBox, 341.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(passwordTextBox, 136.0, Unit.PX, 34.0, Unit.PX);
		
		
		layoutPanel.add(btnLogIn);
		layoutPanel.setWidgetLeftWidth(btnLogIn, 387.0, Unit.PX, 75.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnLogIn, 176.0, Unit.PX, 25.0, Unit.PX);
		
		
		
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
				user.setUsername(textBox.getText());
				user.setPassword(passwordTextBox.getText());
				RPC.loginService.login(user, new AsyncCallback<Boolean>() {		
					
					@Override
					public void onSuccess(Boolean results) {
						if(results == true){
							lblLoginStatus.setText("Logged In");
							//if you successfully login, go to the homepage
							layoutPanel.clear();
							layoutPanel.add(homePage);
						}
					if(results!=true)
							lblLoginStatus.setText("Fail");	
							results = false;
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						lblLoginStatus.setText("Could not Log In");						
					}
				});
			}			
			
		});
		layoutPanel.add(btnNewUser);
		layoutPanel.setWidgetLeftWidth(btnNewUser, 387.0, Unit.PX, 90.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnNewUser, 207.0, Unit.PX, 25.0, Unit.PX);	
		
		btnTempHpage = new Button("TEMP. HPAGE");
		layoutPanel.add(btnTempHpage);
		layoutPanel.setWidgetLeftWidth(btnTempHpage, 184.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnTempHpage, 51.0, Unit.PX, 30.0, Unit.PX);
		
	
		btnTempHpage.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				layoutPanel.clear();
				layoutPanel.add(homePage);
				
			}
			
		});
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
				user.setUsername(textBox.getText());
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
						if (result != true)
							lblLoginStatus.setText("User already exists");
						result = false;
						
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
}
