package com.bcits.abstraction;

public class ClassY implements Connection {

	@Override
	public Statement createStatement() {
		
		return new ClassB();
	}

}
