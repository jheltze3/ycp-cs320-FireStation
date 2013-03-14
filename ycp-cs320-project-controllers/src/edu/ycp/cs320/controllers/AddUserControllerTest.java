package edu.ycp.cs320.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ycp.CS320.server.FakeDatabase;
import edu.ycp.CS320.shared.User;


public class AddUserControllerTest {

	@Test
	public void test() {
		FakeDatabase db = new FakeDatabase();
		AddUserController addUserController = new AddUserController();
		User user = new User(1, "Bob", "bobpw");
		User user2 = new User(2, "Steve", "stevepw");
		
		addUserController.addUser(db, user);
		assertTrue(db.getUsersFromDatabase().contains(user));
		assertFalse(db.getUsersFromDatabase().contains(user2));
	}

}
