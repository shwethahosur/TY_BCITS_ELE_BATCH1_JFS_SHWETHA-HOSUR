package com.bcits.threads.p1;

public class Thread3 extends Thread {
	public synchronized void run() {
		System.out.println(" running thread");
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		
try {
	wait();
} catch (InterruptedException e) {
	System.out.println(e.getMessage());
}
		}
}
	
	public  synchronized void leaveme() {
		System.out.println(" notify called");
		notify();
		
	}
}