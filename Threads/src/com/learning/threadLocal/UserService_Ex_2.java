package com.learning.threadLocal;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService_Ex_2 {
	private static ExecutorService threapool=Executors.newFixedThreadPool(10);
	private static LocalDateTime localDateTime= LocalDateTime.now();
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			new Thread(() -> {
				System.out.println(localDateTime);
			}).start();
		}
		Thread.sleep(1000);
	}


}
