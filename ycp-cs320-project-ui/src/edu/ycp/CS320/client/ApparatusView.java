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


public class ApparatusView extends Composite implements ISubscriber {
	private Label lblEquipmentHeader;
	private LayoutPanel layoutPanel;
	private Label lblTitle;
	private Button btnHomePage;
	private FlowPanel scrollPanelContents;
	
	public ApparatusView() {			
		layoutPanel = new LayoutPanel();
		layoutPanel.setStyleName("ApparatusViewStyle");
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
		layoutPanel.setWidgetLeftWidth(btnHomePage, 1039.0, Unit.PX, 121.0, Unit.PX);
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

		layoutPanel.setWidgetLeftWidth(scrollPanel, 0.0, Unit.PX, 1925.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(scrollPanel, 100.0, Unit.PX, 860.0, Unit.PX);
		this.scrollPanelContents = new FlowPanel();
		scrollPanelContents.setStyleName("ApparatusViewStyle");
		scrollPanel.add(scrollPanelContents);
		
		Button btnAddEquipment = new Button("Add Equipment");
		layoutPanel.add(btnAddEquipment);
		layoutPanel.setWidgetLeftWidth(btnAddEquipment, 1039.0, Unit.PX, 121.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnAddEquipment, 36.0, Unit.PX, 30.0, Unit.PX);
		
		btnAddEquipment.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Ycp_cs320_project_ui.setView(new AddApparatusPageView());				
			}
		});
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
