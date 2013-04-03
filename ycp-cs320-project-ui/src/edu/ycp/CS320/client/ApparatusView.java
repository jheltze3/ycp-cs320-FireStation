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

public class ApparatusView extends Composite implements ISubscriber {
	private Label lblEquipmentHeader;
	private LayoutPanel layoutPanel;
	private Label lblName;
	private Label lblTitle;
	private FireApparatusList fireApparatusList;
	private Label lblType;
	private Label lblModel;
	private Label lblMake;
	private Label lblmake_1;
	private Label lblName_1;
	private Label lblmodel_1;
	private Label lbltype_1;
	private Label lbldescription_1;
	private Label lblDescription;
	private Label lblYear;
	private Label lblYear_1;
	
	
	public ApparatusView() {			
		layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("fireStation-panelBackground");
		initWidget(layoutPanel);
		layoutPanel.setSize("1142px", "761px");
		
		lblTitle = new Label("Apparatus Page!!!");
		lblTitle.setStyleName("Title");
		lblTitle.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		layoutPanel.add(lblTitle);
		layoutPanel.setWidgetLeftWidth(lblTitle, 333.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblTitle, 17.0, Unit.PX, 25.0, Unit.PX);
		
		lblEquipmentHeader = new Label("Equipment");
		layoutPanel.add(lblEquipmentHeader);
		layoutPanel.setWidgetLeftWidth(lblEquipmentHeader, 20.0, Unit.PX, 79.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblEquipmentHeader, 74.0, Unit.PX, 18.0, Unit.PX);
		
		lblName = new Label("Name:");
		layoutPanel.add(lblName);
		layoutPanel.setWidgetLeftWidth(lblName, 20.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblName, 98.0, Unit.PX, 18.0, Unit.PX);
		
		lblName_1 = new Label("name_1");
		layoutPanel.add(lblName_1);
		layoutPanel.setWidgetLeftWidth(lblName_1, 107.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblName_1, 98.0, Unit.PX, 18.0, Unit.PX);
		
		lblMake = new Label("Make:");
		layoutPanel.add(lblMake);
		layoutPanel.setWidgetLeftWidth(lblMake, 20.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblMake, 146.0, Unit.PX, 18.0, Unit.PX);
		
		lblModel = new Label("Model:");
		layoutPanel.add(lblModel);
		layoutPanel.setWidgetLeftWidth(lblModel, 20.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblModel, 171.0, Unit.PX, 18.0, Unit.PX);
		
		lblType = new Label("Type:");
		layoutPanel.add(lblType);
		layoutPanel.setWidgetLeftWidth(lblType, 20.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblType, 195.0, Unit.PX, 18.0, Unit.PX);
		
		lblDescription = new Label("Description:");
		layoutPanel.add(lblDescription);
		layoutPanel.setWidgetLeftWidth(lblDescription, 20.0, Unit.PX, 79.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblDescription, 219.0, Unit.PX, 18.0, Unit.PX);
		
		lblmake_1 = new Label("make_1");
		layoutPanel.add(lblmake_1);
		layoutPanel.setWidgetLeftWidth(lblmake_1, 107.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblmake_1, 146.0, Unit.PX, 18.0, Unit.PX);
		
		lblmodel_1 = new Label("model_1");
		lblmodel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		layoutPanel.add(lblmodel_1);
		layoutPanel.setWidgetLeftWidth(lblmodel_1, 107.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblmodel_1, 171.0, Unit.PX, 18.0, Unit.PX);
		
		lbltype_1 = new Label("type_1");
		layoutPanel.add(lbltype_1);
		layoutPanel.setWidgetLeftWidth(lbltype_1, 107.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lbltype_1, 195.0, Unit.PX, 18.0, Unit.PX);
		
		lbldescription_1 = new Label("Description_1");
		layoutPanel.add(lbldescription_1);
		layoutPanel.setWidgetLeftWidth(lbldescription_1, 107.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lbldescription_1, 219.0, Unit.PX, 18.0, Unit.PX);
		
		lblYear = new Label("Year:");
		layoutPanel.add(lblYear);
		layoutPanel.setWidgetLeftWidth(lblYear, 20.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblYear, 122.0, Unit.PX, 18.0, Unit.PX);
		
		lblYear_1 = new Label("year_1");
		layoutPanel.add(lblYear_1);
		layoutPanel.setWidgetLeftWidth(lblYear_1, 107.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblYear_1, 122.0, Unit.PX, 18.0, Unit.PX);
		
		ScrollPanel scrollPanel = new ScrollPanel();
		layoutPanel.add(scrollPanel);
		layoutPanel.setWidgetLeftWidth(scrollPanel, 20.0, Unit.PX, 383.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(scrollPanel, 392.0, Unit.PX, 96.0, Unit.PX);
		
		FlowPanel flowPanel = new FlowPanel();
		scrollPanel.setWidget(flowPanel);
		flowPanel.setSize("100%", "100%");
		
		FlowPanel flowPanel_1 = new FlowPanel();
		flowPanel.add(flowPanel_1);
		
		Label lblPanel = new Label("panel 1");
		flowPanel_1.add(lblPanel);
		
		Button btnButton_2 = new Button("Button 1");
		flowPanel_1.add(btnButton_2);
		
		FlowPanel flowPanel_2 = new FlowPanel();
		flowPanel.add(flowPanel_2);
		
		Label lblPanel_1 = new Label("panel 2");
		flowPanel_2.add(lblPanel_1);
		
		Button btnButton_1 = new Button("Button 2");
		flowPanel_2.add(btnButton_1);
		
		FlowPanel flowPanel_3 = new FlowPanel();
		flowPanel.add(flowPanel_3);
		
		Label lblNewLabel = new Label("panel 2");
		flowPanel_3.add(lblNewLabel);
		
		Button btnButton = new Button("button 3");
		flowPanel_3.add(btnButton);
		
	
		fireApparatusList = new FireApparatusList();		
		
		RPC.apparatusService.loadApparatus(new AsyncCallback<ArrayList<FireApparatus>>() {
			@Override
			public void onSuccess(ArrayList<FireApparatus> result) {						
				if(result != null){
						lblName_1.setText(result.get(0).getFireApparatusSpec().getName());
						lblYear_1.setText(result.get(0).getFireApparatusSpec().getYear());
						lblmake_1.setText(result.get(0).getFireApparatusSpec().getMake());
						lblmodel_1.setText(result.get(0).getFireApparatusSpec().getModel());
						lbltype_1.setText(result.get(0).getFireApparatusSpec().getType());	
						lbldescription_1.setText(result.get(0).getFireApparatusSpec().getDescription());
				}
				else{
					lblName_1.setText("Fail");							
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				lblName_1.setText("RPC failure");						
			}
		});
	}	

	
	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {		
		
	}		
}
