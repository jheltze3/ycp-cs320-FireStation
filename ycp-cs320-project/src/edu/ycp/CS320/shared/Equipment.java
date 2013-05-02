package edu.ycp.CS320.shared;

public class Equipment {
	private String equipmentName = "";
	private int amount;
	private String condition = "";
	private EquipmentSpec spec;
	private int id;
	
	public Equipment(){
		
	}
	
	public Equipment(int id, String name, int amount, String condition, EquipmentSpec spec){
		this.id = id;
		this.equipmentName = name;
		this.amount = amount;
		this.condition = condition;
		this.spec = spec;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	
	public void setSpec(EquipmentSpec es){
		this.spec = es;
	}
	
	
	

}
