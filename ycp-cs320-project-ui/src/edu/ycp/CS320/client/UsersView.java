package edu.ycp.CS320.client;

import java.util.Map;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.dom.client.Style.Unit;

import edu.ycp.CS320.server.DerbyDatabase;
import edu.ycp.CS320.shared.User;

public class UsersView extends Composite{
	private Label lblUsers;
	
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
	}
}
