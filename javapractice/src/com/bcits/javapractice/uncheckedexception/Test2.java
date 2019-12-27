package com.bcits.javapractice.uncheckedexception;

public class Test2 {
	public static void main(String[] args) {
		String name = null;
		try {

			try {

				System.out.println(name.length());
			} catch (NullPointerException n) {
				System.out.println(n.getMessage());
			}
			System.out.println(10 / 0);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
}