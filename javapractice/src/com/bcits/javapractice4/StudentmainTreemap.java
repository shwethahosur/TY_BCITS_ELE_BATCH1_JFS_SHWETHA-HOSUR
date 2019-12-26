package com.bcits.javapractice4;

import java.util.Comparator;



public class StudentmainTreemap implements Comparator<Studentmap > {

	

	@Override
	public int compare(Studentmap o1, Studentmap o2) {
		// TODO Auto-generated method stub
		return  o1.age-o2.age;
	}}