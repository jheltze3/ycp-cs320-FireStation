package edu.ycp.CS320.shared;

import java.io.Serializable;

public class FireApparatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private FireApparatusSpec fireApparatusSpec;
	
	public FireApparatus(){
		//default constructor		
	}

	public FireApparatus(FireApparatusSpec spec)
	{
		setFireApparatusSpec(spec);
	}

	public FireApparatusSpec getFireApparatusSpec() {
		return fireApparatusSpec;
	}

	public void setFireApparatusSpec(FireApparatusSpec fireApparatusSpec) {
		this.fireApparatusSpec = fireApparatusSpec;
	}
	
	public String getFireApparatusName(){
		return this.name;		
	}
	
	
}
