package com.jsp.p1;

import java.util.Random;

public class randomArray {
	public int[] randomArrayCreation(int size)
	{
		Random rd=new Random();
		int intArray[]= new int[size];
		for(int i=0;i<size; i++)
		{
			intArray[i]=rd.nextInt(100);
		}return intArray;
	}
}
