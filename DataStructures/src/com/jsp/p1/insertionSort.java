package com.jsp.p1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class insertionSort {
	void sort(int arr[])
	{
		int n=arr.length;
		for(int i=1;i<n;i++)
		{
			int key=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>key)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
}
	public static void main(String[] args) {
		Random rd= new Random();
		int arr[]= new int[120];
		for(int i=0;i<arr.length;i++) {
			arr[i]=rd.nextInt(10);
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		insertionSort is=new insertionSort();
		
		Instant start= Instant.now();
		is.sort((arr));
		
		Instant end =Instant.now();
		Long duration = Duration.between(start, end).toMillis();
		double seconds = duration /1000.0;
		System.out.println("insertion sort took "+ seconds+ "seconds");
	}
}
