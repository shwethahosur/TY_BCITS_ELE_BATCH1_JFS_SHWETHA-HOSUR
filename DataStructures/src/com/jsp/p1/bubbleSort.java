package com.jsp.p1;

import java.time.Duration;
import java.time.Instant;

public class bubbleSort {
	void sort(int arr[])
	{
		int n=arr.length;
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	int[] rev(int arr[]) {

		int n=arr.length;
		int a=0;
		int b[]=new int[n];
		for(int i=n-1;i>=0;i--)
		{
			b[a]=arr[i];
			a++;
		}
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		return b;
	}

	public static void main(String[] args) {
		randomArray rd=new randomArray();
		int arr[]= rd.randomArrayCreation(20);
		bubbleSort bs=new bubbleSort();

		Instant start= Instant.now();
		bs.sort((arr));
		Instant end =Instant.now();
		Long duration = Duration.between(start, end).toMillis();
		double seconds = duration /1000.0;
		System.out.println("bubble sort took "+ seconds+ "seconds");
	}
}
