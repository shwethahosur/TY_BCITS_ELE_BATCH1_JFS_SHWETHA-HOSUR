package com.bcits.javapractice.checkedexception;

public class Calculator1 {

	void division(int a,int b) {
		try {
			Class.forName("person");
		} catch (ClassNotFoundException e) {
			
			System.out.println(" class is not found");
		}
	}
}
