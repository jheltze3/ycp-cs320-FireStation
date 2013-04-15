package edu.ycp.CS320.client;

import java.util.ArrayList;

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

import edu.ycp.CS320.shared.*;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.FlowPanel;

//mws

public class ApparatusDetailsView extends Composite implements ISubscriber {
	private LayoutPanel layoutPanel;
	private Label lblName;
	//private ArrayList<FireApparatus> fireApparatusList;
	private FireApparatus model;
	private Label lblType;
	private Label lblModel;
	private Label lblMake;
	private Label lblMake_1;
	private Label lblName_1;
	private Label lblModel_1;
	private Label lblType_1;
	private Label lblDescription_1;
	private Label lblDescription;
	private Label lblYear;
	private Label lblYear_1;
	
	
	public ApparatusDetailsView(/*String name, String make, String model, String type, String description, String year*/) {			
		layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("fireStation-panelBackground");
		initWidget(layoutPanel);
		layoutPanel.setSize("400px", "200px");
		
//		lblTitle = new Label("Apparatus Page!!!");
//		lblTitle.setStyleName("Title");
//		lblTitle.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//		layoutPanel.add(lblTitle);
//		layoutPanel.setWidgetLeftWidth(lblTitle, 333.0, Unit.PX, 193.0, Unit.PX);
//		layoutPanel.setWidgetTopHeight(lblTitle, 17.0, Unit.PX, 25.0, Unit.PX);
		
		lblName = new Label("Name: ");
		layoutPanel.add(lblName);		
		lblMake = new Label("Make: ");
		layoutPanel.add(lblMake);		
		lblModel = new Label("Model: ");
		layoutPanel.add(lblModel);		
		lblType = new Label("Type: ");
		layoutPanel.add(lblType);		
		lblDescription = new Label("Description: ");
		layoutPanel.add(lblDescription);		
		lblYear = new Label("Year: ");
		layoutPanel.add(lblYear);
		
		lblName_1 = new Label("");
		layoutPanel.add(lblName_1);		
		lblMake_1 = new Label("");
		layoutPanel.add(lblMake_1);		
		lblModel_1 = new Label("");
		layoutPanel.add(lblModel_1);		
		lblType_1 = new Label("");
		layoutPanel.add(lblType_1);		
		lblDescription_1 = new Label("");
		layoutPanel.add(lblDescription_1);		
		lblYear_1 = new Label("");
		layoutPanel.add(lblYear_1);
	}	

	public void setModel(FireApparatus model) {
		this.model = model;
		update();
	}
	
	private void update() {
		lblName_1.setText(model.getFireApparatusSpec().getName());
		lblMake_1.setText(model.getFireApparatusSpec().getMake());
		lblModel_1.setText(model.getFireApparatusSpec().getModel());
		lblType_1.setText(model.getFireApparatusSpec().getType());
		lblDescription_1.setText(model.getFireApparatusSpec().getDescription());
		lblYear_1.setText(model.getFireApparatusSpec().getYear());
	}

	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {		
		
	}		
}
