package com.bcits.question4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Hashset {
static Scanner sc= new Scanner(System.in);
static HashSet<String> h=new HashSet<String>();
public static void main(String[] args) {
	ArrayList<Integer>a=new ArrayList<Integer>(); 
	System.out.println(" enter the no. of pairs");
	int T = Integer.parseInt(sc.nextLine());
	
	System.out.println(" enter  strings");
	for(int i=1;i<=T;i++) {
	String str = sc.nextLine();	
	int count=0;
	h.add(str);
	for(Object t1:h) {
		count++;	
		
	}
	a.add(count);
	}
	for (int pair:a) {
		System.out.println(" the unique pair are"+pair);
} 
}
}