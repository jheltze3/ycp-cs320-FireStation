package edu.ycp.CS320.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import edu.ycp.CS320.shared.*;
import com.google.gwt.user.client.ui.Button;

public class ApparatusDetailsView extends Composite implements ISubscriber {
	private LayoutPanel layoutPanel;
	private Label lblName;
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
	
	
	public ApparatusDetailsView() {			
		layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("ApparatusViewStyle");
		initWidget(layoutPanel);

		layoutPanel.setSize("2200px", "150px");


		layoutPanel.setSize("271px", "203px");
		
//		lblTitle = new Label("Apparatus Page!!!");
//		lblTitle.setStyleName("Title");
//		lblTitle.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//		layoutPanel.add(lblTitle);
//		layoutPanel.setWidgetLeftWidth(lblTitle, 333.0, Unit.PX, 193.0, Unit.PX);
//		layoutPanel.setWidgetTopHeight(lblTitle, 17.0, Unit.PX, 25.0, Unit.PX);
		

		lblName = new Label("Name: ");
		layoutPanel.add(lblName);	
		layoutPanel.setWidgetLeftWidth(lblName, 0.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblName, 0.0, Unit.PX, 20.0, Unit.PX);
		
		lblMake = new Label("Make: ");
		layoutPanel.add(lblMake);	
		layoutPanel.setWidgetLeftWidth(lblMake, 0.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblMake, 20.0, Unit.PX, 20.0, Unit.PX);
		
		lblModel = new Label("Model: ");
		layoutPanel.add(lblModel);	
		layoutPanel.setWidgetLeftWidth(lblModel, 0.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblModel, 40.0, Unit.PX, 20.0, Unit.PX);
			
		lblType = new Label("Type: ");
		layoutPanel.add(lblType);	
		layoutPanel.setWidgetLeftWidth(lblType, 0.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblType, 60.0, Unit.PX, 20.0, Unit.PX);
			
		lblDescription = new Label("Description: ");
		layoutPanel.add(lblDescription);
		layoutPanel.setWidgetLeftWidth(lblDescription, 0.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblDescription, 80.0, Unit.PX, 20.0, Unit.PX);
				
		lblYear = new Label("Year: ");
		layoutPanel.add(lblYear);
		layoutPanel.setWidgetLeftWidth(lblYear, 0.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblYear, 100.0, Unit.PX, 20.0, Unit.PX);
		
		
		
		
		lblName_1 = new Label("add Text");
		layoutPanel.add(lblName_1);	
		layoutPanel.setWidgetLeftWidth(lblName_1, 100.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblName_1, 0.0, Unit.PX, 20.0, Unit.PX);
			
		lblMake_1 = new Label("add Text");
		layoutPanel.add(lblMake_1);	
		layoutPanel.setWidgetLeftWidth(lblMake_1, 100.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblMake_1, 20.0, Unit.PX, 20.0, Unit.PX);
			
		lblModel_1 = new Label("add Text");
		layoutPanel.add(lblModel_1);
		layoutPanel.setWidgetLeftWidth(lblModel_1, 100.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblModel_1, 40.0, Unit.PX, 20.0, Unit.PX);
				
		lblType_1 = new Label("add Text");
		layoutPanel.add(lblType_1);	
		layoutPanel.setWidgetLeftWidth(lblType_1, 100.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblType_1, 60.0, Unit.PX, 20.0, Unit.PX);
			
		lblDescription_1 = new Label("add Text");
		layoutPanel.add(lblDescription_1);	
		layoutPanel.setWidgetLeftWidth(lblDescription_1, 100.0, Unit.PX, 1134.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblDescription_1, 80.0, Unit.PX, 20.0, Unit.PX);
			
		lblYear_1 = new Label("add Text");
		layoutPanel.add(lblYear_1);
		layoutPanel.setWidgetLeftWidth(lblYear_1, 100.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblYear_1, 100.0, Unit.PX, 20.0, Unit.PX);
		
		Button btnDeleteEntry = new Button("Delete Entry");
		layoutPanel.add(btnDeleteEntry);
		layoutPanel.setWidgetLeftWidth(btnDeleteEntry, 0.0, Unit.PX, 117.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnDeleteEntry, 126.0, Unit.PX, 30.0, Unit.PX);
		btnDeleteEntry.addClickHandler(new ClickHandler() {
			

			@Override
			public void onClick(ClickEvent event) {
				this.GetText();				
			}

			private void GetText() {
				RPC.apparatusService.removeApparatus(lblName_1.getText(), new AsyncCallback<Boolean>() {
					@Override
					public void onSuccess(Boolean result) {	
						System.out.println("Removed: "+lblName_1.getText());
						ApparatusView view = new ApparatusView();
						Ycp_cs320_project_ui.setView(view);
						view.activate();
					}
					
					@Override
					public void onFailure(Throwable caught) {	
						System.out.println("Could not Removed: "+lblName_1.getText());
					}
				});
			}
		});
		
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
		//lblYear_1.setText(model.getFireApparatusSpec().getYear());
	}

	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {		
		
	}		
}
