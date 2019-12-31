package com.bcits.abstraction;

public class ClassX implements Connection {

	@Override
	public Statement createStatement() {
		
		return new ClassC();
	}

}
