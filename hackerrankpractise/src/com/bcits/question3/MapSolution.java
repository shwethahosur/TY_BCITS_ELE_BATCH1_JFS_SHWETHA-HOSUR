package com.bcits.question3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class MapSolution {
	static LinkedHashMap m = new LinkedHashMap();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
         int i;
		System.out.println(" enter the no. of contacts");
		int n = Integer.parseInt(sc.nextLine());
		
		for (i = 0; i <= n; i++) {
			System.out.println(" enter the person name");
			
			String name = sc.nextLine();
			System.out.println(" enter number");
			int num=Integer.parseInt(sc.nextLine());
			m.put(name,num);
			
		}
		System.out.println(m.toString());

		
		System.out.println("enter the no.of queries");
		int q= Integer.parseInt(sc.nextLine());
		System.out.println(" enter name for searching");
		String name1= sc.nextLine();
		for(int i1=1;i1<=q;i1++) {
	   System.out.println(m.get(name1));
   
}}}
