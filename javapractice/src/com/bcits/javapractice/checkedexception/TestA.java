package com.bcits.javapractice.checkedexception;

public class TestA {
public static void main(String[] args) {
	Person p= new Person();
	try {
	p.clone();
}catch (CloneNotSupportedException e) {
System.out.println(e.getMessage());
}
}}
