package edu.ycp.CS320.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ycp.CS320.shared.User;

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
