package com.learning.threadLocal;

public class UserController {
	public static void main(String[] args) {
		new Service1().process();
		new Service2().process();
		new Service3().process();
	}
}
