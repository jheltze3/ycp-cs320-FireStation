package edu.ycp.CS320.jjda;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContactInfoTest {

	
	@Test
	public void test() {
		
		ContactInfo testDirectory = new ContactInfo();
		testDirectory.setHomephoneNumber("1-000-000-0000");
		testDirectory.setCellphoneNumber("1-555-000-1958");
		testDirectory.setName("John Smith");
		
		assertEquals("1-000-000-0000", testDirectory.getHomePhoneNumber());
		assertEquals("John Smith", testDirectory.getName());
		assertEquals("1-555-000-1958", testDirectory.getCellPhoneNumber());
	}


}
