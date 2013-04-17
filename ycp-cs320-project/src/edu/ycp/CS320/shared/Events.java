package edu.ycp.CS320.shared;

import edu.ycp.CS320.equipment.EquipmentSpec;

public class Events {
	private String equipmentName = "";
	private int amount;
	private String condition = "";
	private EquipmentSpec spec;
	
	
	public void setName(String equipmentName ) {
		this.equipmentName = equipmentName;
	}
	
	public String getName() {
		return  equipmentName;
	}
	
	public void setPrice(int amount ) {
		this.amount = amount;
	}
	
	public int getPrice() {
		return  amount;
	}
	
	public void setCondition(String condition ) {
		this.condition = condition;
	}
	
	public String getCondition() {
		return  condition;
	}
	
	public EquipmentSpec getSpec()
	{
		return null;
	}
	
	
	

}
