package com.jsp.p1;

import java.time.Duration;
import java.time.Instant;

public class linearSearch {
	public static void LinearSearch(int[] arr, int key){    
		int flag=0;
		int pos=0;
		for(int i=0;i<arr.length;i++){    
			if(arr[i] == key)   
			{
				flag=1;
				pos=i+1;
			}
		}
		if(flag==1)
			System.out.println(key+" is found at index: "+ pos);
		else
			System.out.println("element not found");
	}
	public static void main(String a[]){    
		randomArray rd=new randomArray();
		int a1[]= rd.randomArrayCreation(20);   
		int key = 110; 
		Instant start= Instant.now();
		LinearSearch(a1, key);
		Instant end =Instant.now();
		Long duration = Duration.between(start, end).toMillis();
		double seconds = duration /1000.0;
		System.out.println("linear search took "+ seconds+ "seconds");
	}    
}
