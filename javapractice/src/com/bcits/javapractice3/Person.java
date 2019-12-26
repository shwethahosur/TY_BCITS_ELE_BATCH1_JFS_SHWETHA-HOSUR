package com.bcits.javapractice3;

import java.util.Comparator;
import java.util.TreeSet;

public class Person {
	

	public int age;
	String name;
	

	public Person(int age, String name) {
	
		this.age = age;
		this.name = name;
	}


	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		TreeSet<Person >t=new TreeSet<Person>(new Person1());
		t.add(new Person(18,"shwetha"));
		t.add(new Person(28,"sushma"));
        t.add(new Person(88,"girija"));
        t.add(new Person(108,"shwetha"));
        for (Person person : t) {
			System.out.println(person);
		} 
	
}
}