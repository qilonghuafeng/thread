package com.atguigu;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("I am Callable Interface");
		return 200;
	}
	
}

public class CallableTest {

	public static void main(String[] args) throws Exception, ExecutionException {
		FutureTask<Integer> ft = new FutureTask<Integer>(new MyThread());
		new Thread(ft, "AA").start();
		new Thread(ft, "BB").start();
		Integer i = ft.get();
		System.out.println("call÷¥––ÕÍ≥…");
		System.out.println(i);

	}

}
