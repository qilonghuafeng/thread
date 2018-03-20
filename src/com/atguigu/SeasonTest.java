package com.atguigu;

import java.util.concurrent.CountDownLatch;

public class SeasonTest {
	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(4);
		for(int i=1;i<=4;i++) {
			int temp = i;
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"--"+temp);
				cdl.countDown();
			},Seasons.getSeason(temp).getReDes()).start();
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("四季交替");
		
	}

}
enum Seasons{
	SPRING(1,"春天"),SUMMER(2,"夏天"),AUTUMN(3,"秋天"),WINNER(4,"冬天");
	private int reCode;
	private String reDes;
	
	private Seasons() {
	}
	
	private Seasons(Integer reCode, String reDes) {
		this.reCode = reCode;
		this.reDes = reDes;
	}
	
	public static Seasons getSeason(int reCode) {
		for (Seasons element : values()) {
			if(element.getReCode() == reCode) {
				return element;
			}
		}
		return null;
		
	}
	
	public Integer getReCode() {
		return reCode;
	}
	public void setReCode(Integer reCode) {
		this.reCode = reCode;
	}
	public String getReDes() {
		return reDes;
	}
	public void setReDes(String reDes) {
		this.reDes = reDes;
	}
	
}
