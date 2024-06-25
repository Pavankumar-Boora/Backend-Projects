package com.learning.runnable_collable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExUsingLamda {
	public static void main(String[] args) throws ExecutionException, InterruptedException  {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> "Result from Callable");
        String result = future.get();
        System.out.println(result);
        executorService.shutdown();
    }
}
