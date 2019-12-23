package com.jsp.p1;

import java.time.Duration;
import java.time.Instant;

public class selectionSort {

	void SelectionSort(int[] arr){  
		for (int i = 0; i < arr.length - 1; i++)  
		{  
			int index = i;  
			for (int j = i + 1; j < arr.length; j++){  
				if (arr[j] < arr[index]){  
					index = j;  
				}  
			}  
			int temp = arr[index];   
			arr[index] = arr[i];  
			arr[i] = temp;  
		}  
	}  

	public static void main(String a[]){  
		randomArray rd=new randomArray();
		int arr1[]= rd.randomArrayCreation(20);
		Instant start= Instant.now();
		selectionSort ss= new selectionSort();
		ss.SelectionSort(arr1);
		for(int i:arr1){  
			System.out.print(i+" ");} 
		Instant end =Instant.now();
		Long duration = Duration.between(start, end).toMillis();
		double seconds = duration /1000.0;
		System.out.println("\nselection sort took "+ seconds+ "seconds");
	}  
}
