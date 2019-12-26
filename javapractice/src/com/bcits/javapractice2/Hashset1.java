package com.bcits.javapractice2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Hashset1 {
public static void main(String[] args) {
	System.out.println("-------linkedhashset----");
	
	
	LinkedHashSet<Integer>l=new LinkedHashSet<Integer>();
	l.add(null);
	l.add(10);
	l.add(20);
	l.add(10);
	l.add(90);
	l.add(1001);
	l.add(010);
	System.out.println(l);
	
	System.out.println("------Hashset------");
	
	
	HashSet<Integer>h=new HashSet<Integer>();
	h.add(null);
	h.add(10);
	h.add(20);
	h.add(10);
	h.add(90);
	h.add(1001);
	h.add(010);
	System.out.println(h);
	
	System.out.println("----------Treeset------------");
	
	
	TreeSet<Integer>t=new TreeSet<Integer>();
	
	t.add(10);
	t.add(20);
	t.add(10);
    t.add(90);
	t.add(1001);
	t.add(010);
	System.out.println(t);
}
}
