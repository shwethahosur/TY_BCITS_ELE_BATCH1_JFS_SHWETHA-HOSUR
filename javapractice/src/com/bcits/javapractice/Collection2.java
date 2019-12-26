package com.bcits.javapractice;

import java.util.ArrayList;
import java.util.Collection;

public class Collection2 {
public static void main(String[] args) {
	Collection<Integer> c2= new ArrayList<Integer>();
	c2.add(25);
	c2.add(250);
	
	Collection<Integer> c3= new ArrayList<Integer>();
	c3.add(45);
	c3.add(550);
	
	Collection<Integer> c4= new ArrayList<Integer>();
	c4.add(152);
	c4.add(2510);
	
	Collection<Integer> c5= new ArrayList<Integer>();
	c5.add(2512);
	c5.add(250358);
	
	System.out.println(c2);
	System.out.println(c3);
	
	System.out.println("----------------------------");
	c3.addAll(c2);
	
	System.out.println(c2);
	System.out.println(c3);
	System.out.println("----------------------------");
	
	
	c3.removeAll(c2);
	
	System.out.println(c2);
	System.out.println(c3);
	System.out.println("----------------------------");
	
	c3.containsAll(c4);
	System.out.println(c4);
	System.out.println(c3);
	System.out.println("----------------------------");
	
	
	c3.retainAll(c4);
	System.out.println(c4);
	System.out.println(c3);
	
	
System.out.println("---------to array-----------");
	
	Object[] o1= c2.toArray();
	for (int i = 0; i < o1.length; i++) {
		System.out.println(o1[i]);
	}
	
	
}
}
