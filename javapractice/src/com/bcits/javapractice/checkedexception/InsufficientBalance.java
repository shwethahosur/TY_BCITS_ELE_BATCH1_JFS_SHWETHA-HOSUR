package com.bcits.javapractice.checkedexception;

public class InsufficientBalance extends Exception {
String msg=" insufficient balance";

public InsufficientBalance(String msg) {
	this.msg = msg;
}
public InsufficientBalance() {
	
}
public String getMessage() {
	return msg;
}
}
