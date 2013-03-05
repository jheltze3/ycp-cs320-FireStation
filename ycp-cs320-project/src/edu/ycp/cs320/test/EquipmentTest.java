package edu.ycp.cs320.test;

	import static org.junit.Assert.*;
import org.junit.Test;

import edu.ycp.cs320.equipment.Equipment;

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
