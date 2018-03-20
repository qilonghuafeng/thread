package com.atguigu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	private static final int NUMBER = 7;
	public static void main(String[] args) {
		CyclicBarrier cc = new CyclicBarrier(7, ()->{
			System.out.println("成功召唤神龙");
		});
		for(int i=1; i<=NUMBER; i++) {
			int temp = i;
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"获取第"+temp+"龙珠");
			    try {
					cc.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}
	}

}
