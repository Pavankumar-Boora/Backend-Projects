package com.learning.threadLocal;

public class Service2 {
	public void process() {
		User user = UserContextholder.holder.get();
		System.out.println("Accessing the user values in Service2 with the help of ThreadLocal\n"+user);
	}
}
