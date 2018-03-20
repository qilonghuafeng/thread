package com.atguigu;

import java.util.concurrent.CountDownLatch;

public class Country {

	public static void main(String[] args) {
		CountDownLatch cd = new CountDownLatch(6);
		for(int i=1; i<=6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"国灭");
				cd.countDown();
			},String.valueOf(i))  .start();
		}
		try {
			cd.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"秦灭六国，一统华夏");

	}
	
	public static void closedoor() {
		CountDownLatch c = new CountDownLatch(6);
		for(int i=1;i<=6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"离开");
				c.countDown();
			},String.valueOf(i)) .start();
		}
		try {
			c.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("班长离开教室");
		
	}

}
enum Status{
	ONE(1,"赵"),TWO(1,"赵"),THREE(1,"赵"),FOUR(1,"赵"),FIVE(1,"赵"),SIX(1,"赵");
	private int id;
	private String name;
	private Status(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
