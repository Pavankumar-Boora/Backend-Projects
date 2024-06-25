package com.learning.runnable_collable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableEx implements Callable<String> {
	@Override
	public String call() throws Exception {
		return "Thread is running with Callable interface";
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<String> future = executorService.submit(new CallableEx());
		String result = future.get();
		System.out.println(result);
		executorService.shutdown();
	}
}
