package edu.ycp.CS320.apparatus;

import java.util.ArrayList;

public class FireApparatusInventory {
	private ArrayList<FireApparatus> inventory;
	
	public FireApparatusInventory() {
		inventory = new ArrayList<FireApparatus>();		
	}
	
	public void addApparatus(FireApparatus apparatus) {
		inventory.add(apparatus);		
	}
	
	public FireApparatus getApparatus(int index) {
		return inventory.get(index);
	}
}
