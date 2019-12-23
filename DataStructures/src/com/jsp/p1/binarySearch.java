package com.jsp.p1;

import java.time.Duration;
import java.time.Instant;

public class binarySearch {
	static void BinarySearch(int arr[],int first,int last,int key){  
		   int mid = (first + last)/2;  
		   while( first <= last ){  
		      if ( arr[mid] < key ){  
		        first = mid + 1;     
		      }else if ( arr[mid] == key ){  
		        System.out.println("Element is found at index: " + mid);  
		        break;  
		      }else{  
		         last = mid - 1;  
		      }  
		      mid = (first + last)/2;  
		   }  
		   if ( first > last ){  
		      System.out.println("Element is not found");  
		   }  
		 }  
		 public static void main(String args[]){  
		        int arr[] = {10,20,30,40,50,60,70,80,90,100};  
		        int key = 30;  
		        int last=arr.length-1;  
		        Instant start= Instant.now();
		        BinarySearch(arr,0,last,key); 
				Instant end =Instant.now();
				Long duration = Duration.between(start, end).toMillis();
				double seconds = duration /1000.0;
				System.out.println("binary search took "+ seconds+ "seconds");
		 }  
}
