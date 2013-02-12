package edu.ycp.CS320.jjda;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectoryTest {

	
	@Test
	public void test() {
		
		Directory testDirectory = new Directory();
		testDirectory.addPhoneNumber("Bob", "1-000-000-0000");
		
		assertEquals("1-000-000-0000", testDirectory.getPhoneNumber("Bob"));
	}

}
