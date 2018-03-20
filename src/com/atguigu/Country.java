package com.atguigu;

import java.util.concurrent.CountDownLatch;

public class Country {

	public static void main(String[] args) {
		CountDownLatch cd = new CountDownLatch(6);
		for(int i=1; i<=6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"����");
				cd.countDown();
			},String.valueOf(i))  .start();
		}
		try {
			cd.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"����������һͳ����");

	}
	
	public static void closedoor() {
		CountDownLatch c = new CountDownLatch(6);
		for(int i=1;i<=6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"�뿪");
				c.countDown();
			},String.valueOf(i)) .start();
		}
		try {
			c.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�೤�뿪����");
		
	}

}
enum Status{
	ONE(1,"��"),TWO(1,"��"),THREE(1,"��"),FOUR(1,"��"),FIVE(1,"��"),SIX(1,"��");
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
