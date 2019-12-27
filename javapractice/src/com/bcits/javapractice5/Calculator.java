package com.bcits.javapractice5;

public class Calculator {

	void add(int a,int b) {
		
		System.out.println(a+b);
	}
	
	void division( int a,int b) {
		try {
		System.out.println(a/b);
	}catch(ArithmeticException e) {
		System.out.println(" math error");
	}
}
}
