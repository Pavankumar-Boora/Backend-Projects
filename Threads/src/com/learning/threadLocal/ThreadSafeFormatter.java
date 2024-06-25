package com.learning.threadLocal;

import java.time.LocalDateTime;

public class ThreadSafeFormatter {
//	public static ThreadLocal<LocalDateTime> localDate=new ThreadLocal<LocalDateTime>() {;
	 
//	@Override
//     protected LocalDateTime initialValue() {
//        return LocalDateTime.now();
//     }
//	 @Override
//	 public LocalDateTime get() {
//		 return super.get();
//	 };	 
//	};
	
	public static ThreadLocal<LocalDateTime> localDate=ThreadLocal.withInitial(()->LocalDateTime.now());

}
