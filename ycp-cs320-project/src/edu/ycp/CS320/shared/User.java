package edu.ycp.CS320.shared;

public class User {
	
	//user fields that will be checked against the database to determine if the credentials are valid
	private int id;
	private String name = "";
	private String password = "";

	//this fields can be taken from the html web page and will instantiate the user object
	public User(int id, String username, String password){
		this.name = username;
		this.password = password;
		this.id = id;
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
