package com.jdc.mkt;

@SuppressWarnings("unused")
public class User {

	private int id;
	private String name;
	private Gender gender;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		if(null != name)
		this.name = name;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	
	public Gender getGender() {
		return gender;
		
		
	}
	
	public enum Gender{
		MALE,FEMALE,OTHER;
	}
}
