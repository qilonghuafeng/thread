package com.atguigu;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
	
	public static void main(String[] args) {
		Semaphore s = new Semaphore(3);
		for(int i=1; i<=6; i++) {
			new Thread(()->{ 
				try {
					s.acquire();
					System.out.println(Thread.currentThread().getName()+"ͣ���ɹ�");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"�뿪ͣ��λ");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
                    s.release();
				}
			}).start();
		}
	}

}
