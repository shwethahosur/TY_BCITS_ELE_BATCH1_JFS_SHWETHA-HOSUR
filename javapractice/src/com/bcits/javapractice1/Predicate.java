package com.bcits.javapractice1;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Predicate {
public static void main(String[] args) {
	ArrayList<Integer>a=new ArrayList<Integer>();
	a.add(25);
	a.add(45);
	a.add(56);
	a.add(4);
	a.add(12);
	for (Integer integer : a) {
		System.out.println(integer);
	}
	List<Integer> l1= a.stream().filter(i->i%2==0).collect(Collectors.toList());
	System.out.println(l1);
	
	List<Integer> l2= a.stream().map(i->i*2).collect(Collectors.toList());
	System.out.println(l2);
}
}
