package com.bcits.javapractice4;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Student12  {
int age;
String name;
public Student12(int age, String name) {
	this.age = age;
	this.name = name;
}
@Override
public String toString() {
	return "Student12 [age=" + age + ", name=" + name + "]";
}
public static void main(String[] args) {
	TreeMap<Integer, String> t=new TreeMap<Integer, String>();
	t.put(25, "shwetha");
	t.put(257, "sushma");
	t.put(205, "girija");
	t.put(265, "akshata");
	Set<Entry<Integer,String>>s1=t.entrySet();
	for (Map.Entry<Integer, String> entry : s1) {
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
	
}
}


}
