package edu.ycp.CS320.equipment;

import java.util.ArrayList;

public class EquipmentInventory {

	private ArrayList<Equipment> inventory;
	
	public EquipmentInventory(){
		inventory = new ArrayList<Equipment>();
	}
	
	public void addEquipment(Equipment equipment) {
		inventory.add(equipment);		
	}
	
	public Equipment getEquipment(int index) {
		return inventory.get(index);
	}

}
