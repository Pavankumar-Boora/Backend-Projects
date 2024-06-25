package com.learning.threadLocal;

import java.time.LocalDateTime;

public class UserService_Ex_3 {
	
	public static void main(String[] args) throws InterruptedException {
		UserService_Ex_3 user = new UserService_Ex_3();
		for (int i = 0; i < 1000; i++) {
			new Thread(() -> {
				System.out.println(user.birthDate());
			}).start();
		}
		Thread.sleep(1000);
	}
	private LocalDateTime birthDate() {
		return ThreadSafeFormatter.localDate.get();
	}
}
