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
		db.addUserToDB(user);
		assertTrue(userController.containsUser(db, user));
		assertFalse(userController.containsUser(db, user2));
	}

}
