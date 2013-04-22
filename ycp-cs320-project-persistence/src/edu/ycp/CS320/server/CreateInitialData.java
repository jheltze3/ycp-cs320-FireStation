package edu.ycp.CS320.server;

import java.sql.SQLException;

import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireApparatusSpec;
import edu.ycp.CS320.shared.User;

public class CreateInitialData {

	public static void main(String[] args) throws SQLException {
		DerbyDatabase db = new DerbyDatabase();	

		User drew = new User(-1, "drew", "pw");
		User jake = new User(-1, "jake", "pw");
		User josh = new User(-1, "josh", "pw");
		User alana = new User(-1, "alana", "pw");				

		db.addUserToDB(drew);
		db.addUserToDB(jake);
		db.addUserToDB(josh);
		db.addUserToDB(alana);
		
//		//Add fire apparatus to database
//		FireApparatus fireApparatus = new FireApparatus();
//		fireApparatus.getFireApparatusSpec().setName("Engine 62-1");		
//		fireApparatus.getFireApparatusSpec().setDescription("A Fire Engine");
//		fireApparatus.getFireApparatusSpec().setMake("Pierce");
//		fireApparatus.getFireApparatusSpec().setModel("Arrow XT PUC");
//		fireApparatus.getFireApparatusSpec().setYear("2009");
//		fireApparatus.getFireApparatusSpec().setType("Pumper-Rescue");
//		db.addFireApparatusToDB(fireApparatus);
//		
//		for(int i=0; i<4; i++){
//			FireApparatus fireApparatus_1 = new FireApparatus();
//			fireApparatus_1.getFireApparatusSpec().setName("Engine "+Integer.toString(i));			
//			fireApparatus_1.getFireApparatusSpec().setDescription("A Fire Engine");
//			fireApparatus_1.getFireApparatusSpec().setMake("Pierce");
//			fireApparatus_1.getFireApparatusSpec().setModel("Arrow XT PUC");
//			fireApparatus_1.getFireApparatusSpec().setYear("2009");
//			fireApparatus_1.getFireApparatusSpec().setType("Pumper-Rescue");
//			db.addFireApparatusToDB(fireApparatus_1);
//		}
//		
//		
//		
//		FireApparatusSpec spec1 = new FireApparatusSpec("x", "y", "z", "2013");
//		FireApparatus app1 = new FireApparatus();
//		app1.setFireApparatusSpec(spec1);
//		
//		db.addFireApparatusToDB(app1);
		
		System.out.println("Successfully created initial data");
	}

}
