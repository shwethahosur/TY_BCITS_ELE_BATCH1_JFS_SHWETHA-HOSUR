package com.bcits.javapractice4;

import java.util.Comparator;
import java.util.TreeSet;

public class Studentmap {
	

	 int age;
	String name;
	
	

	public Studentmap (int age, String name) {
	
		this.age = age;
		this.name = name;
	}


	@Override
	public String toString() {
		return "Studentmap [age=" + age + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		TreeSet<Studentmap >t=new TreeSet<Studentmap>(new StudentmainTreemap());
		t.add(new Studentmap(18,"shwetha"));
		t.add(new Studentmap(28,"sushma"));
        t.add(new Studentmap(88,"girija"));
        t.add(new Studentmap(108,"shwetha"));
        for (Studentmap person : t) {
			System.out.println(person);
		} 
	
}
}