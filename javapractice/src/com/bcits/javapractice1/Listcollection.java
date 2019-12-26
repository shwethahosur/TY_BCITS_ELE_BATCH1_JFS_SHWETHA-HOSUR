package com.bcits.javapractice1;

import java.util.ArrayList;

public class Listcollection {
public static void main(String[] args) {
	ArrayList<Integer> a=new ArrayList<Integer>();
	ArrayList<Integer> a1=new ArrayList<Integer>();
	
	a.add(25);
	a.add(36);
	a.add(36);
	a.add(56);
	System.out.println(a);
	
	System.out.println("    -----------------------");
	 a.add(1, 26);
	 System.out.println(a);
	 
	 
	 System.out.println("=================");
	 
	 a.remove(0);
	 System.out.println(a);
	 System.out.println("--------------------------");
	 
	 
	 a.set(1, 35);
	 System.out.println(a);
	 System.out.println("====================");
	 
	 
	 System.out.println(a.indexOf(35));
	 System.out.println("====================");
	 
	 
	 System.out.println(a.lastIndexOf(36)
	 );
	 System.out.println("----------------------");
	 
	 for (int i = 0; i < a.size(); i++) {
		 System.out.println(a.get(i));
		 
		 System.out.println("----------------------");
		  
		 a1.add(25);
			a1.add(3006);
			a1.add(3456);
			a1.add(5656);
			System.out.println(a1);
			
			System.out.println("    -----------------------");
			
			a1.addAll(a);
			System.out.println(a);
			System.out.println("    -----------------------");
			a.subList(1, 3);
			System.out.println(a1);
			for (int j = 0; j < a.size(); j++) {
				System.out.println(a);
				
			}
		
	}
	 
}

}
