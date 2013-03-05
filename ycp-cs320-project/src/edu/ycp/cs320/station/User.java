package edu.ycp.cs320.station;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * allows serialization
	 */
	private static final long serialVersionUID = 8812779888704000801L;
	/**
	 * 
	 */

	/**
	 * each user has fields such as id, name, and password. The id will be used to get it from and add it to
	 * the database
	 * 
	 * the name string will be the User's username
	 * 
	 * the password string will be their password
	 */
	private int id;
	private String name = "";
	private String password = "";

	
	/**
	 * 
	 * standard accessor methods
	 *
	 */
	public void setUsername(String username){
		this.name = username;
	}
	
	public void setPassword(String pw){
		this.password = pw;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsername(){
		return name;
	}
	
	public String getPassword(){
		return password;
	}
	
	
}
