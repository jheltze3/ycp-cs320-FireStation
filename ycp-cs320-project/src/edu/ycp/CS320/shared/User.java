package edu.ycp.CS320.shared;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * allows serialization
	 */
	private static final long serialVersionUID = 8812779888704000801L;
	//user fields that will be checked against the database to determine if the credentials are valid
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
