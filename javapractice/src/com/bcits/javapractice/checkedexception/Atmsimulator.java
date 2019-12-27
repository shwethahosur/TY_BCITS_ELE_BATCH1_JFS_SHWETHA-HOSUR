package com.bcits.javapractice.checkedexception;

public class Atmsimulator  {
int balance=40000;
void withdraw(int amt)throws InsufficientBalance {
	if(amt<=40000) {
		System.out.println(" withdraw successfull");
	}else {
		throw new InsufficientBalance();
	}
}
}
