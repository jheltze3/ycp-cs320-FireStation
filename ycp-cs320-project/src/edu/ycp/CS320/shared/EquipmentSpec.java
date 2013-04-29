package edu.ycp.CS320.shared;

public class EquipmentSpec {
	private String make;
	private String model;
	
	
	public EquipmentSpec(){
		//default
	}
	
	
	public EquipmentSpec(String make, String model)
	{
		this.make = make;
		this.model = model;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}

}
