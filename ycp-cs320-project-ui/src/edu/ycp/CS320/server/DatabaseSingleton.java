package edu.ycp.CS320.server;

import edu.ycp.CS320.shared.IDatabase;

public class DatabaseSingleton {
	private static IDatabase theInstance = new /*FakeDatabase*/DerbyDatabase();
	
	public static IDatabase instance() {
		return theInstance;
	}
}
