package com.bcits.threads.p1;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("thread called");
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

}
