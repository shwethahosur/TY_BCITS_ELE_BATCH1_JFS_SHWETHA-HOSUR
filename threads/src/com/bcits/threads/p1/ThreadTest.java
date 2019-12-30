package com.bcits.threads.p1;

public class ThreadTest {
public static void main(String[] args) {
	System.out.println("main method started");
	Thread1 t1=new Thread1();
	t1.start();
	try {
		t1.sleep(3000);
	} catch (InterruptedException e) {
		
		System.out.println(e.getMessage());
	}
	System.out.println("main ended");
			
}
}
