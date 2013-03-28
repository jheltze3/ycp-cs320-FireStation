package edu.ycp.cs320.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ycp.CS320.shared.FakeDatabase;
import edu.ycp.CS320.shared.User;


public class AddUserControllerTest {

	@Test
	public void test() {
		FakeDatabase db = new FakeDatabase();
		AddUserController addUserController = new AddUserController();
		User user = new User();
		User user2 = new User();		
		addUserController.addUser(db, user);
		assertTrue(db.getUsersFromDB().containsValue(user));
		assertFalse(db.getUsersFromDB().containsValue(user2));
	}

}
