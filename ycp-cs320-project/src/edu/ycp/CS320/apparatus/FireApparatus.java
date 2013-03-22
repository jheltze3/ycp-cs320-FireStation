package edu.ycp.CS320.apparatus;

public class FireApparatus {
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
