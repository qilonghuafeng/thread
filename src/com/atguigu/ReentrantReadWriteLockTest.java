package com.atguigu;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @Description: 一个线程写入,100个线程读取
 * @author zzyy
 * @date 2018年3月17日
 */
class ReadWrite{
	private ReentrantReadWriteLock rr = new ReentrantReadWriteLock();
	private Object obj;
	public void write(Object obj) {
		rr.writeLock().lock();
		try {
			this.obj =  obj;
			System.out.println(Thread.currentThread().getName()+"在写");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rr.writeLock().unlock();
		}
	}
	public void read() {
		rr.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"读取"+obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rr.readLock().unlock();

		}
	}
}
public class ReentrantReadWriteLockTest {

	public static void main(String[] args) {
		ReadWrite rw = new ReadWrite();
		new Thread(() -> { rw.write("welcome to china");},"AA") .start();
        try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        for(int i=1; i<=100; i++) {
        	new Thread(() -> { rw.read();},String.valueOf(i)) .start();
        	
        }
	}

}
