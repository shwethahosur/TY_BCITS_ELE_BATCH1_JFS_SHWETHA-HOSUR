package com.bcits.threads.p1;

public class Thread1 extends Thread {
	public void run() {
		System.out.println(" running thread");
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}


