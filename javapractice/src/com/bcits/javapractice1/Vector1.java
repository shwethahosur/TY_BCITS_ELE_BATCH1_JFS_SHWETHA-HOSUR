package com.bcits.javapractice1;
import java.util.*;
public class Vector1 {

	public static void main(String[] args) {
	Vector<Integer> v= new Vector<Integer>();
	
		v.add(125);
		v.add(500);
		System.out.println(v);
		
		v.insertElementAt(120, 1);
		System.out.println(v);
		
		v.removeElement(new Integer(125));
		System.out.println(v);
		
		v.setElementAt(500, 1);
		System.out.println(v);
		
		v.setSize(5);
		System.out.println(v.capacity());
		
		v.trimToSize();
		System.out.println(v.capacity());
		
		v.ensureCapacity(5);
		System.out.println(v.capacity());
		
		
		System.out.println(v.capacity());
		
		System.out.println("-------------");
		
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v);
			
		}
		
		
		for (Integer integer : v) {
			System.out.println(integer);
		}
		Iterator<Integer>i=v.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
				
			}
			v.add(25);
			
			ListIterator<Integer>l=v.listIterator(v.size());
			while (l.hasNext()) {
				System.out.println(i.next()); 
				
			}
			
			ListIterator<Integer>l1=v.listIterator(v.size());
			while (l1.hasPrevious()) {
				System.out.println(l.next());
	}
}}
