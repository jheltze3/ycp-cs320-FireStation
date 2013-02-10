package edu.ycp.CS320.jjda;

public class User {
	
	//user fields that will be checked against the database to determine if the credentials are valid
	String name = "";
	String password = "";

	//this fields can be taken from the html web page and will instantiate the user object
	public User(String username, String password){
		this.name = username;
		this.password = password;
	}
	
	public String getUsername(){
		return name;
	}
	
	public String getPassword(){
		return password;
	}
}
