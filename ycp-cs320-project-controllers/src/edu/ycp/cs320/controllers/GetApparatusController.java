package edu.ycp.cs320.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.IDatabase;

public class GetApparatusController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<FireApparatus> getApparatus(IDatabase db){
		
		FireApparatus fireApparatus = new FireApparatus();
		fireApparatus.getFireApparatusSpec().setName("Engine 62-1");		
		fireApparatus.getFireApparatusSpec().setDescription("A Fire Engine");
		fireApparatus.getFireApparatusSpec().setMake("Pierce");
		fireApparatus.getFireApparatusSpec().setModel("Arrow XT PUC");
		fireApparatus.getFireApparatusSpec().setYear("2009");
		fireApparatus.getFireApparatusSpec().setType("Pumper-Rescue");
		db.addFireApparatusToDB(fireApparatus);
		
		for(int i=0; i<4; i++){
			FireApparatus fireApparatus_1 = new FireApparatus();
			fireApparatus_1.getFireApparatusSpec().setName("Engine "+Integer.toString(i));			
			fireApparatus_1.getFireApparatusSpec().setDescription("A Fire Engine");
			fireApparatus_1.getFireApparatusSpec().setMake("Pierce");
			fireApparatus_1.getFireApparatusSpec().setModel("Arrow XT PUC");
			fireApparatus_1.getFireApparatusSpec().setYear("2009");
			fireApparatus_1.getFireApparatusSpec().setType("Pumper-Rescue");
			db.addFireApparatusToDB(fireApparatus_1);
		}
		
		return db.getFireApparatusFromDB();
	}
}
