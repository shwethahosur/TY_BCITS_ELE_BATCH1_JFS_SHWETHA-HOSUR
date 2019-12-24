package com.bcits.question1;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListsolution {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=0;
		System.out.println("enter the number of lines");
		n=scanner.nextInt();
		ArrayList<ArrayList<Integer>> arraylists=new ArrayList<ArrayList<Integer>>(n);
		ArrayList<Integer> arraylist=new ArrayList<Integer>();
		for(int i=1;i<=n; i++)
		{
			arraylist.clear();
			int d=0;
			System.out.println("enter the number of digits for "+i+"th line");
			d=scanner.nextInt();
			
			arraylist.add(0,d);

			for(int j=1;j<=d;j++) {
				System.out.println("enter the number for "+j+"th position");
				arraylist.add(j,scanner.nextInt());
			}

			System.out.println(arraylist);
			arraylists.add(i-1, arraylist);
		}
		System.out.println(arraylists);
		System.out.println("enter the queries");
		int q=scanner.nextInt();
		for(int i=1;i<=q;i++)
		{
			System.out.println("enter the line number");
			int l=scanner.nextInt();
			System.out.println("enter the position");
			int x=scanner.nextInt();
			if(l>arraylists.size()||x>arraylist.size())
			{
				System.err.println("error");
				return;
			}
			System.out.println(arraylists.get(l-1).get(x-1));
		}
	}
}