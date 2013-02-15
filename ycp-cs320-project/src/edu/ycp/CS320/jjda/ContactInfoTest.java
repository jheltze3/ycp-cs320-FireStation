package edu.ycp.CS320.jjda;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContactInfoTest {

	
	@Test
	public void test() {
		
		ContactInfo testDirectory = new ContactInfo();
		testDirectory.setPhoneNumber("1-000-000-0000");
		
		assertEquals("1-000-000-0000", testDirectory.getPhoneNumber());
	}



}
