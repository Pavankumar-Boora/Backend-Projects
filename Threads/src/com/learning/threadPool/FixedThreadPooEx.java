package com.learning.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPooEx {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 10; i++) {
			executorService.execute(new RunnableTask(i));
		}
		executorService.shutdown();
	}
}

class RunnableTask implements Runnable {
	private int taskId;

	public RunnableTask(int taskId) {
		this.taskId = taskId;
	}

	@Override
	public void run() {
		System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task " + taskId + " completed on " + Thread.currentThread().getName());
	}
}
