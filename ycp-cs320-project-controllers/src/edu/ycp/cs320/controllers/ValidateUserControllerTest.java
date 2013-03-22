package edu.ycp.cs320.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ycp.CS320.shared.FakeDatabase;
import edu.ycp.CS320.shared.User;

public class ValidateUserControllerTest {

	@Test
	public void test() {
		ValidateUserController userController = new ValidateUserController();
		FakeDatabase db = new FakeDatabase();
		User user = new User();
		User user2 = new User();
		db.getUsersFromDB().put(1, user);
		assertTrue(userController.containsUser(db, user));
		assertFalse(userController.containsUser(db, user2));
	}
	
	/**
	 * addAndLoginTest()
	 * 
	 * this test performs the operation sequence that 
	 * should occur in the scenario that a new User
	 * adds his login credentials via the New User button
	 * then the next scenario that follows is that User
	 * tries to log in
	 */
	@Test
	
	public void addAndLoginTest(){
		ValidateUserController userController = new ValidateUserController();
		AddUserController addController = new AddUserController();
		FakeDatabase db = new FakeDatabase();
		User user = new User();
		User user2 = new User();
		
		addController.addUser(db, user);
		
		assertTrue(userController.containsUser(db, user));
		assertFalse(userController.containsUser(db, user2));
		
	}
}


