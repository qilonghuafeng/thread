package com.atguigu;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
//		ExecutorService service = Executors.newFixedThreadPool(5);
//		ExecutorService service2 = Executors.newSingleThreadExecutor();
//		ExecutorService service3 = Executors.newCachedThreadPool();
//	    Future<Integer> result = null;
//	  try {
//			  for(int i=1;i<=10;i++) {
//	    	result = service.submit(()->{
//	    		Thread.sleep(400);
//	    		System.out.println(Thread.currentThread().getName());
//	    		return new Random().nextInt(8);
//	    	});
//	    	System.err.println(result.get());
//	    }
//		} catch (Exception e) {
//			service.shutdown();
//		}
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		ScheduledFuture<Integer> result = null;
		try {
			for(int i=1;i<=15;i++) {
				result = service.schedule(()->{
					System.out.println(Thread.currentThread().getName());
					return new Random().nextInt(8);
				},2,TimeUnit.SECONDS);
				System.out.println(result.get());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
           service.shutdown();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
