package com.atguigu;



import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NoSafeCollectons {

	public static void main(String[] args) {
//		CopyOnWriteArrayList<String> list  = new CopyOnWriteArrayList<String>();
//		for(int i=1; i<=15; i++) {
//			new Thread(()->{
//				list.add(UUID.randomUUID().toString().substring(0, 4));
//				System.out.println(list);
//			},String.valueOf(i)).start();
//		}
		
//		CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<Integer>();
//		for(int i=1;i<=15;i++) {
//			new Thread(()->{
//				set.add(new Random().nextInt(8));
//				System.out.println(set);
//			}).start();
//		}

		Map<String,String> map = new ConcurrentHashMap<String,String>();
		for(int i=1;i<=15;i++) {
			new Thread(()->{
				map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 4));
				System.out.println(map);
			},String.valueOf(i)) .start();
			
		}
	}

}
