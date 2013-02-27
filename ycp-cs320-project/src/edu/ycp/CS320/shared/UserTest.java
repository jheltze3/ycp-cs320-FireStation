package edu.ycp.CS320.shared;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {
	
	@Test
	public void test() {
		
		User testUser = new User(521252, "Bob","Password"); // in the form of ID, username, password
		assertEquals(521252, testUser.getId());
		assertEquals("Bob", testUser.getUsername());
		assertEquals("Password", testUser.getPassword());
	}

}
