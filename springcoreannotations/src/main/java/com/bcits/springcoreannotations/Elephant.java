package com.bcits.springcoreannotations;

import com.bcits.springannotation.Interface.Animal;

public class Elephant implements Animal {

	@Override
	public void eat() {
		System.out.println("eating sugarcane....");

	}

	@Override
	public void speak() {
		System.out.println("trumphet....");

	}

}
