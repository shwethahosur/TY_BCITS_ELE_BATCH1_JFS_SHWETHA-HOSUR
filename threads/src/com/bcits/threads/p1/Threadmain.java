package com.bcits.threads.p1;

public class Threadmain {
public static void main(String[] args) {
	
	Thread3 t1=new Thread3();
	Thread3 t2=new Thread3();
	t1.start();
	t2.start();
	t1.leaveme();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		System.out.println(e.getMessage());
	}
	
		
	
	
}
}
