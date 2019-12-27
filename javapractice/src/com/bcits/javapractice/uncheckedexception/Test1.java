package com.bcits.javapractice.uncheckedexception;

public class Test1 {
public static void main(String[] args) {
	String name=null;
	try {
		System.out.println(name.length());
	
	System.out.println(name.length());
}catch(ArithmeticException |NullPointerException e) {
	System.out.println(e.getMessage());
}
}
}
