package com.bcits.javapractice3;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class LinkedHashmap1 {
	public static void main(String[] args) {
		
		
		LinkedHashMap<Integer, String> m= new LinkedHashMap<Integer,String>();
		m.put(25, "shwetha");
		m.put(26,"sushma");
		m.put(290, "girija");
		m.put(56,"akshata");
		Set<Entry<Integer,String>>s1=m.entrySet();
		for (Map.Entry<Integer, String> entry : s1) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();
		}
		System.out.println(m.get(25));
		Set<Integer>s2=m.keySet();
		for (Integer integer : s2) {
			System.out.println(integer);
			
		}
		Collection<String> c= m.values();
		for (String string : c) {
			System.out.println(string);
			
		}
		}
}
