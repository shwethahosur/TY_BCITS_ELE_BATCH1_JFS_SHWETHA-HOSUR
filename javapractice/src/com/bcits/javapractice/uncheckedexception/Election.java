package com.bcits.javapractice.uncheckedexception;

public class Election {
public void vote(int age) {
	if(age>18) {
		System.out.println(" eligible to vote");
	}else {
		throw new AgelimitException();
	}
}
}
