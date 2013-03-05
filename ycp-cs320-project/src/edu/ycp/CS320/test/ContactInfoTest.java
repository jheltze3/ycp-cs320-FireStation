package edu.ycp.CS320.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ycp.CS320.common.ContactInfo;

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
