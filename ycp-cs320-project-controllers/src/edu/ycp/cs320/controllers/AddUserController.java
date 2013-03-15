package edu.ycp.cs320.controllers;

import edu.ycp.CS320.shared.FakeDatabase;
import edu.ycp.CS320.shared.User;

/**
 * @author drew
 *this class takes a database and adds the user object to it
 */
public class AddUserController {
	
	/**
	 * @param db	this is the database that is attached to the system
	 * @param user	this user object will be added to that database
	 */
	public void addUser(FakeDatabase db, User user){
		db.addUserToDatabase(user);
	}
}
