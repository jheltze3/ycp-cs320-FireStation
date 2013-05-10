package edu.ycp.CS320.client;

import java.util.ArrayList;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import edu.ycp.CS320.server.DerbyDatabase;
import edu.ycp.CS320.shared.ContactInfo;
import edu.ycp.CS320.shared.User;
import com.google.gwt.user.client.ui.ListBox;

public class UsersView extends Composite{
	private Label lblUsers;
	private ListBox listBox;
	private Button btnHomePage;

	public UsersView() {
//		DerbyDatabase derbyDB = new DerbyDatabase();
		final LayoutPanel layout = new LayoutPanel();
		initWidget(layout);

		lblUsers = new Label("Users:");
		layout.add(lblUsers);
		layout.setWidgetLeftWidth(lblUsers, 22.0, Unit.PX, 56.0, Unit.PX);
		layout.setWidgetTopHeight(lblUsers, 17.0, Unit.PX, 18.0, Unit.PX);

		Label lblResults = new Label("empty");
		layout.add(lblResults);
		layout.setWidgetLeftWidth(lblResults, 22.0, Unit.PX, 137.0, Unit.PX);
		layout.setWidgetTopHeight(lblResults, 58.0, Unit.PX, 64.0, Unit.PX);		

		listBox = new ListBox();
		listBox.addItem("users");
		layout.add(listBox);
		layout.setWidgetLeftWidth(listBox, 22.0, Unit.PX, 63.0, Unit.PX);
		layout.setWidgetTopHeight(listBox, 102.0, Unit.PX, 100.0, Unit.PX);
		listBox.setVisibleItemCount(5);
		
		btnHomePage = new Button("Home Page");
		layout.add(btnHomePage);
		layout.setWidgetLeftWidth(btnHomePage, 1039.0, Unit.PX, 121.0, Unit.PX);
		layout.setWidgetTopHeight(btnHomePage, 0.0, Unit.PX, 30.0, Unit.PX);
		
		btnHomePage.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Ycp_cs320_project_ui.setView(new HomePageView());				
			}
		});


	}


}