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
		return db.getFireApparatusFromDB();
	}
	
	public void addApparatus(FireApparatus fireApparatus, IDatabase db){
		db.addFireApparatusToDB(fireApparatus);
	}
	
	public void removeApparatus(String name, IDatabase db){
		db.removeFireApparatus(name);
	}
}
