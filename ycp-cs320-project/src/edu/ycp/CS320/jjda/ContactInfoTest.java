package edu.ycp.CS320.jjda;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContactInfoTest {

	
	@Test
	public void test() {
		
		ContactInfoTest testDirectory = new ContactInfoTest();
		testDirectory.setPhoneNumber("1-000-000-0000");
		
		assertEquals("1-000-000-0000", testDirectory.getPhoneNumber());
	}

	private void setPhoneNumber(String string) {
		// TODO Auto-generated method stub
		
	}

	private Object getPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}

}
