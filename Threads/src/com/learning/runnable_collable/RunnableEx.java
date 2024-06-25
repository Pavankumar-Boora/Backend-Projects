package com.learning.runnable_collable;

public class RunnableEx implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread is running with Runnable interface");
	}
	public static void main(String[] args) {
		RunnableEx runnableEx = new RunnableEx();
		Thread thread = new Thread(runnableEx);
		thread.start();

	}
}