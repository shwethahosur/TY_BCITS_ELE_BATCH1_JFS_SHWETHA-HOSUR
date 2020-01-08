package com.bcits.jdbcapp.common;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
public static void main(String[] args) {
	ArrayList<String> mydata=new ArrayList<String>();
	mydata.add("One");
	mydata.add("Two");
	mydata.add("Three");
	mydata.add("Four");
	mydata.add("Five");
	
	Iterator<String> itr=mydata.iterator();
	
	while (itr.hasNext()) {
		String val = itr.next();
		System.out.println(val);
		
	}
}
}
