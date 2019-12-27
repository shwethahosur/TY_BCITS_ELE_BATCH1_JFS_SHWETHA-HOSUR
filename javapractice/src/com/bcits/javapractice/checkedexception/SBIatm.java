package com.bcits.javapractice.checkedexception;

public class SBIatm {
public static void main(String[] args) {
	Atmsimulator a1=new Atmsimulator();
	try {
	a1.withdraw(41000);
	
}catch(InsufficientBalance e) {
	System.out.println(e.getMessage());
}
}
}