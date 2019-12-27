package com.bcits.javapractice.uncheckedexception;

public class Testmain {
public static void main(String[] args) {
	try {
		A.a();
	}catch (ArithmeticException e) {
		System.out.println(e.getMessage());
	}
}
}
