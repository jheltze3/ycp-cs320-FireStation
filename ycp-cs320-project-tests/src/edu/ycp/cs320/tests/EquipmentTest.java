package edu.ycp.cs320.tests;

	import static org.junit.Assert.*;
import org.junit.Test;

import edu.ycp.CS320.shared.Equipment;

public class EquipmentTest {

@Test
		public void test() {
			
			Equipment testEquipment = new Equipment();
			testEquipment.setName("Jaws of life");
			testEquipment.setPrice(10);
			testEquipment.setCondition("Good");
	
			
			assertEquals("Jaws of life", testEquipment.getName());
			assertEquals(10, testEquipment.getPrice());
			assertEquals("Good", testEquipment.getCondition());
		}

}
