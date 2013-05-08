package edu.ycp.CS320.server;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.ycp.CS320.shared.FireApparatus;

public class ViewFireApparatus {

	private static ArrayList<FireApparatus> list;

	public static void main(String[] args) throws SQLException {
		DerbyDatabase db = new DerbyDatabase();
		list = db.getFireApparatusFromDB();
		
		for(int i=0; i<list.size(); i++){
			System.out.println("Name: "+list.get(i).getFireApparatusSpec().getName());
		}
		
	}
}
