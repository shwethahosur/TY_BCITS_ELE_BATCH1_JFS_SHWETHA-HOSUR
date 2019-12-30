package com.bcits.threads.p1;

public class ThreadTest1 {
public static void main(String[] args) {
	System.out.println("main started");
	Thread2 t1 =new Thread2();
	Thread2 t3 =new Thread2();
	Thread t=new Thread(t1);
	Thread t4=new Thread(t3);
	try {
		t.join();
		t4.join();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	t.start();
	t4.start();
	try {
		t.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("main ended");
}
}
