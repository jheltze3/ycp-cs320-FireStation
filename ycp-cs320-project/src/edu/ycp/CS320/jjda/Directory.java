package edu.ycp.CS320.jjda;

import java.util.Map;
import java.util.TreeMap;

public class Directory {

	//the directory can use a tree map to store the names/phone numbers in alphabetical order
	//the directory controller should eventually get these numbers and store them in the database permanently 
	//after we have a working database
	Map<String, String> phoneNumbers = new TreeMap<String, String>();
	
	//adds a phone number
	public void addPhoneNumber(String name, String number){
		phoneNumbers.put(name , number);
	}
	
	//retrieves a phone number by person's name
	public String getPhoneNumber(String name){
		return phoneNumbers.get(name);
	}
	
}
