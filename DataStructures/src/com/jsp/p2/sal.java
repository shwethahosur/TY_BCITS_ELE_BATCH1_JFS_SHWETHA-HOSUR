package com.jsp.p2;

public class sal {
	public static void main(String[] args) {
		int x=30;
		if(x<20||x>100)
		{
			System.out.println("throw new no exception");
		}else {
			try {
				NumberRangeException obj=new NumberRangeException(" exception occured");
				throw obj;
			}
			catch(NumberRangeException b) {
				System.out.println("exception handed");
			}
		}
		
	}
}
