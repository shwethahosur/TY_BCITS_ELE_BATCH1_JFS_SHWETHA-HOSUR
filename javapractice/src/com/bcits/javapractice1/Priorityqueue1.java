package com.bcits.javapractice1;

import java.util.PriorityQueue;

public class Priorityqueue1 {

	public static void main(String[] args) {
		
		PriorityQueue<Integer>p=new PriorityQueue<Integer>();
		p.add(20);
		p.add(25);
		p.add(200);
		p.add(250);
		p.add(250);
	
		System.out.println(p);
		p.remove(new Integer(200));
		System.out.println(p);
		for (Integer integer : p) {
			System.out.println(integer);
			
		}
		
	}
}
