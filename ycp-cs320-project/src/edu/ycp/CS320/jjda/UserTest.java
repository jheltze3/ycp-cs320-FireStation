package edu.ycp.CS320.jjda;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		User testUser = new User("Bob", "ninja");
		
		assertEquals("Bob", testUser.getUsername());
		assertEquals("ninja", testUser.getPassword());
	}

}
