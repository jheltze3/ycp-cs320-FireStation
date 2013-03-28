package edu.ycp.cs320.controllers;

import java.util.Collection;

import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.CS320.shared.User;

/**
 * @author drew
 *this class is used to apply the logging in logic with a database, the users it contains, and a user object
 *created via the textbox widgets in the UI
 */
public class ValidateUserController {
	
	/**
	 * @param db	the database that is currently attached to the system
	 * @param user	the user object created via the UI textbox fields
	 * @return		if the user does exist in the database then a true is returned
	 * 					otherwise a false is returned and the user can be added to the system
	 */
	public boolean containsUser(IDatabase db, User user){
		/*
		if(db.getUsersFromDB().containsValue(user)){
		//the user does exist and is now logged in
			return true;
		}
		*/
		Collection<User> allUsers = db.getUsersFromDB().values();
		for (User dbUser : allUsers) {
			if (user.getUsername().equals(dbUser.getUsername()) && user.getPassword().equals(dbUser.getPassword())) {
				return true;
			}
		}
		//the user does not exist and can be added as a new user via the DB methods
		return false;
	}
	
	
}
