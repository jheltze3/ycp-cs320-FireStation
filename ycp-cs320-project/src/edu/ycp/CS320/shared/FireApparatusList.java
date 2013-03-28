package edu.ycp.CS320.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class FireApparatusList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<FireApparatus> fireApparatusList;

	public ArrayList<FireApparatus> getFireApparatusList() {
		return fireApparatusList;
	}

	public void setFireApparatusList(ArrayList<FireApparatus> fireApparatusList) {
		this.fireApparatusList = fireApparatusList;
	}
	
}
