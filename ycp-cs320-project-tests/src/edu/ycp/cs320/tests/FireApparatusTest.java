package edu.ycp.cs320.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ycp.CS320.server.FakeDatabase;
import edu.ycp.CS320.shared.FireApparatus;

public class FireApparatusTest {
	@Test
	public void test() {
		FakeDatabase fireApparatusDB = new FakeDatabase();
		
		FireApparatus testFireApparatus01 = new FireApparatus(); // in the form of ID, username, password		
		FireApparatus testFireApparatus02 = new FireApparatus(); // in the form of ID, username, password
		
		int indexFireApparatus01 = fireApparatusDB.addFireApparatusToDBOld(testFireApparatus01);		
		int indexFireApparatus02 = fireApparatusDB.addFireApparatusToDBOld(testFireApparatus02);
		
		/*
		 * Test first fire truck
		 */
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus01).
		getFireApparatusSpec().setMake("Pierce");
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus01).
		getFireApparatusSpec().setModel("Arrow XT PUC");
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus01).
		getFireApparatusSpec().setName("Engine 62-1");
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus01).
		getFireApparatusSpec().setYear(2009);
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus01).
		getFireApparatusSpec().setType("Pumper-Rescue");
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus01).
		getFireApparatusSpec().setDescription("Engine 62-1 is a 2009 Pierce six man " +
				"Arrow XT PUC Pumper-Rescue, with a 1500 GPM pump, 750 Gallons of water, 50 gallons of " +
				"class A foam, and a Harrison 10Kw Hydraulic generator.");
		
		assertEquals("Pierce", 			fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus01).getFireApparatusSpec().getMake());
		assertEquals("Arrow XT PUC", 	fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus01).getFireApparatusSpec().getModel());
		assertEquals("Engine 62-1", 	fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus01).getFireApparatusSpec().getName());
		assertEquals(2009, 			fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus01).getFireApparatusSpec().getYear());
		assertEquals("Pumper-Rescue", 	fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus01).getFireApparatusSpec().getType());
		assertEquals("Engine 62-1 is a 2009 Pierce six man " +
				"Arrow XT PUC Pumper-Rescue, with a 1500 GPM pump, 750 Gallons of water, 50 gallons of " +
				"class A foam, and a Harrison 10Kw Hydraulic generator.", 
										fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus01).getFireApparatusSpec().getDescription());
		
		/*
		 * Test second fire truck
		 */
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus02).
		getFireApparatusSpec().setMake("Pierce");
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus02).
		getFireApparatusSpec().setModel("Arrow XT PUC");
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus02).
		getFireApparatusSpec().setName("Rescue 62");
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus02).
		getFireApparatusSpec().setYear(2013);
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus02).
		getFireApparatusSpec().setType("Pumper-Rescue");
		fireApparatusDB.getFireApparatusFromDB().get(indexFireApparatus02).
		getFireApparatusSpec().setDescription("Rescue 62 is a 2013 Pierce six man Arrow XT PUC Pumper-Rescue, " +
				"with a 1500 GPM pump, 750 Gallons of water, 50 gallons of class A foam, and a 20Kw Diesel generator.  The Rescue is still being built and is expected to arrive summer 2013.");
		
		assertEquals("Pierce", 			fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus02).getFireApparatusSpec().getMake());
		assertEquals("Arrow XT PUC", 	fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus02).getFireApparatusSpec().getModel());
		assertEquals("Rescue 62", 		fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus02).getFireApparatusSpec().getName());
		assertEquals(2013, 			fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus02).getFireApparatusSpec().getYear());
		assertEquals("Pumper-Rescue", 	fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus02).getFireApparatusSpec().getType());
		assertEquals("Rescue 62 is a 2013 Pierce six man Arrow XT PUC Pumper-Rescue, with a 1500 GPM pump, 750 Gallons of water, 50 gallons of class A foam, and a 20Kw Diesel generator.  " +
				"The Rescue is still being built and is expected to arrive summer 2013.", 
										fireApparatusDB.getFireApparatusFromDB().
				get(indexFireApparatus02).getFireApparatusSpec().getDescription());
	}
}
