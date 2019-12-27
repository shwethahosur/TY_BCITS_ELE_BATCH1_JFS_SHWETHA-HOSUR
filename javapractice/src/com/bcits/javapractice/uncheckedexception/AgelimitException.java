package com.bcits.javapractice.uncheckedexception;

public class AgelimitException extends RuntimeException {
String msg=" age invalid";


public AgelimitException() {
	
}


public AgelimitException(String msg) {
	this.msg = msg;
}
public String getMessage(){
	return this.msg=msg;
}

}
