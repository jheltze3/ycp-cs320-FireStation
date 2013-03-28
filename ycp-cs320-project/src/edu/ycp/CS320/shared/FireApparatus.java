package edu.ycp.CS320.shared;

import java.io.Serializable;

public class FireApparatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FireApparatusSpec fireApparatusSpec;

	public FireApparatus()
	{
		setFireApparatusSpec(new FireApparatusSpec());
	}

	public FireApparatusSpec getFireApparatusSpec() {
		return fireApparatusSpec;
	}

	public void setFireApparatusSpec(FireApparatusSpec fireApparatusSpec) {
		this.fireApparatusSpec = fireApparatusSpec;
	}
	
	
}
