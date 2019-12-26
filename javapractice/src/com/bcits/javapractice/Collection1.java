package com.bcits.javapractice;

import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {

	public static void main(String[] args) {
		Collection<Integer> c= new ArrayList<Integer>();
		c.add(30);
		c.add(45);
		c.add(42);
		c.remove(42);
		System.out.println(c);
		System.out.println(c.isEmpty());
		System.out.println(c.size());
		System.out.println(c.contains(45));
		System.out.println(c.stream());
		
	}
}
