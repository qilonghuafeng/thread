package com.atguigu;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @Description: һ���߳�д��,100���̶߳�ȡ
 * @author zzyy
 * @date 2018��3��17��
 */
class ReadWrite{
	private ReentrantReadWriteLock rr = new ReentrantReadWriteLock();
	private Object obj;
	public void write(Object obj) {
		rr.writeLock().lock();
		try {
			this.obj =  obj;
			System.out.println(Thread.currentThread().getName()+"��д");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rr.writeLock().unlock();
		}
	}
	public void read() {
		rr.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"��ȡ"+obj);
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
