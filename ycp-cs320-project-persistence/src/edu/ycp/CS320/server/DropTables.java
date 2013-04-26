package edu.ycp.CS320.server;

import java.sql.SQLException;

public class DropTables {

	public static void main(String[] args) throws SQLException {
		DerbyDatabase db = new DerbyDatabase();
		db.dropTables();
		System.out.println("Successfully dropped tables");
	}

}
