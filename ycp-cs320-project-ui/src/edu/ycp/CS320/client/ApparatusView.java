package edu.ycp.CS320.client;

import java.util.ArrayList;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import edu.ycp.CS320.shared.*;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.FlowPanel;

//mws

public class ApparatusView extends Composite implements ISubscriber {
	private Label lblEquipmentHeader;
	private LayoutPanel layoutPanel;
//	private Label lblName;
//	private Label lblName01;
	private Label lblTitle;
//	private ArrayList<FireApparatus> fireApparatusList;
//	private Label lblType;
//	private Label lblModel;
//	private Label lblMake;
//	private Label lblmake_1;
	private Label lblName_1;
//	private Label lblName_2;
//	private Label lblmodel_1;
//	private Label lbltype_1;
//	private Label lbldescription_1;
//	private Label lblDescription;
//	private Label lblYear;
//	private Label lblYear_1;
	private Button btnHomePage;
	private FlowPanel scrollPanelContents;
	
	
	public ApparatusView() {			
		layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("ApparatusViewStyle");
//		layoutPanel.setStyleName("fireStation-panelBackground");
		initWidget(layoutPanel);
		layoutPanel.setSize("2200px", "1200px");
		
		lblTitle = new Label("Apparatus Page!!!");
		lblTitle.setStyleName("Title");
		lblTitle.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		layoutPanel.add(lblTitle);
		layoutPanel.setWidgetLeftWidth(lblTitle, 333.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblTitle, 20.0, Unit.PX, 40.0, Unit.PX);
		
		lblEquipmentHeader = new Label("Equipment");
		lblEquipmentHeader.setStyleName("ApparatusLabels");
		layoutPanel.add(lblEquipmentHeader);
		
		layoutPanel.setWidgetLeftWidth(lblEquipmentHeader, 0.0, Unit.PX, 92.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblEquipmentHeader, 17.0, Unit.PX, 30.0, Unit.PX);

		btnHomePage = new Button("Home Page");
		layoutPanel.add(btnHomePage);
		layoutPanel.setWidgetLeftWidth(btnHomePage, 1039.0, Unit.PX, 103.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnHomePage, 0.0, Unit.PX, 30.0, Unit.PX);
		
		btnHomePage.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Ycp_cs320_project_ui.setView(new HomePageView());				
			}
		});
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("ApparatusViewScrollPanelStyle");
		layoutPanel.add(scrollPanel);

		layoutPanel.setWidgetLeftWidth(scrollPanel, 0.0, Unit.PX, 1915.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(scrollPanel, 100.0, Unit.PX, 952.0, Unit.PX);
		this.scrollPanelContents = new FlowPanel();
		scrollPanelContents.setStyleName("ApparatusViewStyle");
		scrollPanel.add(scrollPanelContents);
		
//		loadApparatusList(scrollPanelContents);	
	}

	public void activate() {
		loadApparatusList();
	}

	private void loadApparatusList() {
		RPC.apparatusService.loadApparatus(new AsyncCallback<ArrayList<FireApparatus>>() {
			@Override
			public void onSuccess(ArrayList<FireApparatus> fireApparatusList) {		
				scrollPanelContents.clear();
				if(fireApparatusList != null){					
					for(int i=0; i<fireApparatusList.size(); i++){						
						ApparatusDetailsView view = new ApparatusDetailsView();
						scrollPanelContents.add(view);
						view.setModel(fireApparatusList.get(i));
					}	
					fireApparatusList.clear();
				}
				else{
					lblEquipmentHeader.setText("Fail");							
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				lblEquipmentHeader.setText("RPC failure");						
			}
		});
	}	

	
	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {		
		
	}		
}
