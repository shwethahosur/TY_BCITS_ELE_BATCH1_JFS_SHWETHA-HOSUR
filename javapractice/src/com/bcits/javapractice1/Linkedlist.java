package com.bcits.javapractice1;

import java.util.LinkedList;

public class Linkedlist {
public static void main(String[] args) {
	LinkedList<Integer> l=new LinkedList<Integer>();
	l.add(33);
	l.add(36);
	l.add(39);
	l.add(390);
	System.out.println(l);
	
	
	System.out.println("=============");
	l.remove(1);
	System.out.println(l);
	
	
	System.out.println("=============");
	
	System.out.println(l.isEmpty());
	System.out.println("=============");
	
	System.out.println(l.contains(36));
	System.out.println(l.indexOf(390));
	System.out.println(l.lastIndexOf(39));
	System.out.println(l.size());
	System.out.println(l.removeFirst());
	System.out.println(l.removeLast());
	for (int i = 0; i < l.size(); i++) {
		
	
	System.out.println(l.get(0));
}
}}
