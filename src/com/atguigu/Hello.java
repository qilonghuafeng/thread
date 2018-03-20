package com.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @Description: 多线程之间按顺序调用，实现A->B->C 三个线程启动，要求如下：
 * 
 *               AA打印5次，BB打印10次，CC打印15次 接着 AA打印5次，BB打印10次，CC打印15次 ......来10轮
 * @author zzyy
 * @date 2018年3月17日
 */

class ShareData {
	private int numbers = 1;
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();

	public void print1(int totalloop) {
		lock.lock();
		try {
			while (numbers != 1) {
				c1.await();
			}
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() +"--"+ i + "-" + totalloop);
			}
			numbers = 2;
			c2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void print2(int totalloop) {
		lock.lock();
		try {
			while (numbers != 2) {
				c2.await();
			}
			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName() + "--"+i + "--" + totalloop);
			}
			numbers = 3;
			c3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void print3(int totalloop) {
		lock.lock();
		try {
			while (numbers != 3) {
				c3.await();
			}
			for (int i = 1; i <= 15; i++) {
				System.out.println(Thread.currentThread().getName() +"--"+i + "--" + totalloop);
			}
			numbers = 1;
			c1.signal();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

public class Hello {
	public static void main(String[] args) {
		ShareData s = new ShareData();

		new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				s.print1(i);
			}
		}, "AA").start();

		new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				s.print2(i);
			}
		}, "BB").start();

		new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				s.print3(i);
			}
		}, "CC").start();

	}

}
