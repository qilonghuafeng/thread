package com.atguigu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ClassLoaderTest {
	public static void main(String[] args) throws IOException {
     long maxMemory = Runtime.getRuntime().maxMemory();
     System.out.println(maxMemory);
     long totalMemory = Runtime.getRuntime().totalMemory();
     System.out.println(totalMemory);
     long freeMemory = Runtime.getRuntime().freeMemory();
     System.out.println(freeMemory);
     System.out.println(1886912512/1024/1024/1024);
		
	}

}
class Dog{
	private String color;
}
