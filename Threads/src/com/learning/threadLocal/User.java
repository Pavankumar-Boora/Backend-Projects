package com.learning.threadLocal;

public class User {
	private String name;
	private int id;
	
	
	public User(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}


	public static User getUser() {
		return new User("Pavan",1);
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + "]";
	}
	
	
}
