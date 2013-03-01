package edu.ycp.CS320.shared;

/**
 * @author dho7
 * interface for the controller classes to implement. The methods can be defined in the 
 * actual controller classes then after they implement this interface.
 *
 */
public interface IDatabase {
	public void addToDatabase();
	public String getFromDatabase();
}
