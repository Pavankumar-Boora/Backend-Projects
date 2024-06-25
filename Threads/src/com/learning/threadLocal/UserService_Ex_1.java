package com.learning.threadLocal;

import java.time.LocalDateTime;

public class UserService_Ex_1 {
	public static void main(String[] args) throws InterruptedException {
//		new Thread(()->{
//			String birthDate=new UserService().birthDate();
//			System.out.println(birthDate);
//		}).start();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				LocalDateTime birthDate = new UserService_Ex_1().birthDate();
				System.out.println(birthDate);
			}).start();
		}
		Thread.sleep(1000);
	}

	private LocalDateTime birthDate() {
		return LocalDateTime.now();
	}
}
