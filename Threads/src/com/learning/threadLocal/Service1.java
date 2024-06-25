package com.learning.threadLocal;

public class Service1 {
	public void process() {
		User user = User.getUser();
		System.out.println("Set the user values to the ThreadLocal n Service ");
		UserContextholder.holder.set(user);
	}
}
