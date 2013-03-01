package edu.ycp.CS320.shared;

public class Equipment {
	private String equipmentName = "";
	private int amount;
	private String condition = "";
	//String location = "";
	
	
	public void setEquipmentName(String equipmentName )
	{
		this.equipmentName = equipmentName;
	}
	
	public String getEquipmentName()
	{
		return  equipmentName;
	}
	
	public void setAmount(int amount )
	{
		this.amount = amount;
	}
	
	public int getAmount()
	{
		return  amount;
	}
	
	
	public void setCondition(String condition )
	{
		this.condition = condition;
	}
	
	public String getCondition()
	{
		return  condition;
	}
	
	
	

}
