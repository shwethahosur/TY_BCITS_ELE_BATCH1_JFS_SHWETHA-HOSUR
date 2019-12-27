package com.bcits.javapractice.uncheckedexception;

public class Electionmain {
	public static void main(String[] args) {
		
	
	Election  e1=new Election();
	try {
		e1.vote(12);
	}catch(AgelimitException e) {
		System.out.println(e.getMessage());
	}
}
}