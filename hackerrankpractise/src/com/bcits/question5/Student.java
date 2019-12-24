package com.bcits.question5;

import java.util.Comparator;
import java.util.Scanner;

public class Student implements Comparable<Student> {
	int id;
	String name;
	int cgpa;
	Student(int id,String name,int cgpa){
		id=this.id;
		name=this.name;
		cgpa=this.cgpa;
	}
	public String toString(){
		return id+" "+name+" "+cgpa;	
	}
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println(" enter the no. of pairs");
		int N = Integer.parseInt(sc.nextLine());
		
	}

	
	public int compareTo1(Student obj) {
		
		return this.id-obj.id;
	
	}
	public int compareTo2(Student obj) {
		
		return this.name.compareTo(obj.name);
	}
	@Override
public int compareTo(Student obj) {
		
		return this.cgpa-obj.cgpa;
	}
}
