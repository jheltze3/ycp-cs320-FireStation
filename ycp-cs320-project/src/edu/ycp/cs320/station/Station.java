package edu.ycp.cs320.station;

public class Station {

	private String name = "";
	
	//so far every station will at least have a name, you can easily add other parameters to the station constructor
	//if needed in the future
	public Station(String stationName){
		this.name = stationName;
	}
	
	public String getName(){
		return name;
	}
	
	
}
