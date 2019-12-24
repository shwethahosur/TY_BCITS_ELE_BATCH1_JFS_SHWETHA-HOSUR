package com.bcits.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListSolution {
static Scanner sc= new Scanner(System.in);
static List<Integer> l= new ArrayList();
public static void main(String[] args) {
	System.out.println("enter the the number of values in a line"); 
	int n=Integer.parseInt(sc.nextLine());
	l= new ArrayList<Integer>(n);
	
	for(int i=1;i<=n;i++) {
		System.out.println("enter the values at"+i+  "th index ");
		l.add((i-1), Integer.parseInt(sc.nextLine()));
	}
	System.out.println(l.toString());
	System.out.println("enter the no.of queries");
	int q=Integer.parseInt(sc.nextLine());
	for(int i=1;i<=q;i++) {
	System.out.println("enter query to insert or delete");
	String query=sc.nextLine();
	
	if( query.equalsIgnoreCase("insert")) {
		System.out.println(" enter the index");
		int x= Integer.parseInt(sc.nextLine());
		System.out.println(" enter the value");
		int y=Integer.parseInt(sc.nextLine());
		l.add(x,y);
		n++;
	}
	else if( query.equalsIgnoreCase("delete")) {
		System.out.println(" enter index");
		int x=Integer.parseInt(sc.nextLine());
		l.remove(x);
		n--;
	}
	else {
		System.err.println(" enter the correct query");
	}
	System.out.println(l.toString());
}
}
}