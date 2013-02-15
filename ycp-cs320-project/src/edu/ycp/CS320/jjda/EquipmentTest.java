package edu.ycp.CS320.jjda;

	import static org.junit.Assert.*;
	import org.junit.Test;
	
	
	
	
public class EquipmentTest {

@Test
		public void test() {
			
			Equipment testEquipment = new Equipment();
			testEquipment.setEquipmentName("Jaws of life");
			testEquipment.setAmount(10);
			testEquipment.setCondition("Good");
	
			
			assertEquals("Jaws of life", testEquipment.getEquipmentName());
			assertEquals(10, testEquipment.getAmount());
			assertEquals("Good", testEquipment.getCondition());
		}

}
