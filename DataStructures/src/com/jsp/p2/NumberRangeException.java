package com.jsp.p2;

public class NumberRangeException extends RuntimeException {

	String msg;
	NumberRangeException(String msg){
	msg=new String("enter no b/w 20 & 100");
	
	}
}
