package edu.ycp.CS320.server;

import java.sql.SQLException;

import edu.ycp.CS320.shared.FireApparatus;
import edu.ycp.CS320.shared.FireApparatusSpec;
import edu.ycp.CS320.shared.FireCalendarEvent;

public class CreateInitialData {

	public static void main(String[] args) throws SQLException {
		DerbyDatabase db = new DerbyDatabase();			

//		User drew = new User(-1, "drew", "pw");
//		User jake = new User(-1, "jake", "pw");
//		User josh = new User(-1, "josh", "pw");
//		User alana = new User(-1, "alana", "pw");				
//		
//		db.addUserToDB(drew);
//		db.addUserToDB(jake);
//		db.addUserToDB(josh);
//		db.addUserToDB(alana);
		



		
	//FireApparatusSpec spec1 = new FireApparatusSpec("x", "y", "z", 2013, "engine", "this an engine");		
	//	db.addFireApparatusSpecToDB(spec1);

	//	User drew = new User(-1, "drew", "pw");
		//User jake = new User(-1, "jake", "pw");
		//User josh = new User(-1, "josh", "pw");
	//	User alana = new User(-1, "alana", "pw");				
		
	//	db.addUserToDB(drew);
	//	db.addUserToDB(jake);
	//	db.addUserToDB(josh);
	//	db.addUserToDB(alana);
		
		/*
		
		FireApparatusSpec spec1 = new FireApparatusSpec("x", "y", "z", "2013");
		FireApparatus app1 = new FireApparatus();
		app1.setFireApparatusSpec(spec1);
		
		db.addFireApparatusToDB(app1);*/

//		FireApparatus app1 = new FireApparatus();
//		app1.setFireApparatusSpec(spec1); TODO: implement addFireApparatus derby method
		
		

	//	FireCalendar fireApparatus = new FireApparatus(null, new FireApparatusSpec("Pierce", "Arrow XTC PUC", "Engine 62-1", 2009, "Pumper", "This is the first out engine to fire calls"));		
		//db.addFireApparatusToDB(fireApparatus);


		FireApparatus fireApparatus = new FireApparatus(null, new FireApparatusSpec("Pierce", "Arrow XTC PUC", "Engine 62-1", 2009, "Pumper", "This is the first out engine to fire calls"));		
		db.addFireApparatusToDB(fireApparatus);
		
		fireApparatus = new FireApparatus(null, new FireApparatusSpec("Pierce", "Arrow XTC PUC", "Rescue 62", 2013, "Rescue", "This is the new rescue unit on order."));		
		db.addFireApparatusToDB(fireApparatus);
		
		fireApparatus = new FireApparatus(null, new FireApparatusSpec("American Le France", "Unknown", "Engine 62-5", 2002, "Tanker", "This pumper-tanker supplies water at a fire scene"));		
		db.addFireApparatusToDB(fireApparatus);

		System.out.println("Successfully created initial data");
	}

}
