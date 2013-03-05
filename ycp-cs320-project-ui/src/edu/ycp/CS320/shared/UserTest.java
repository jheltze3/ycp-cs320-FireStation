package edu.ycp.CS320.shared;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author drew
 *
 */
public class UserTest {
	
	@Test
	public void test() {
		
		User testUser = new User(); 
		testUser.setId(521252);
		testUser.setUsername("Bob");
		testUser.setPassword("Password");
		assertEquals(521252, testUser.getId());
		assertEquals("Bob", testUser.getUsername());
		assertEquals("Password", testUser.getPassword());
	}

}
