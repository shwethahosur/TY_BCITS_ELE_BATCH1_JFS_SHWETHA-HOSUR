package com.jsp.p2;

import java.time.Duration;
import java.time.Instant;

public class Bubblesort {
	void bubbleSort1(int a[]) 
    { 
		Instant start=Instant.now();
    
    	Instant end=Instant.now();
    	Long duration=Duration.between(start, end).toMillis();
    	double seconds=duration/1000.0;
    	System.out.println(" addupto"+seconds+"adduptoquick"+seconds);
        int n = a.length; 

        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (a[j] > a[j+1]) 
                { 
                     
                    int temp = a[j]; 
                    a[j] = a[j+1]; 
                    a[j+1] = temp; 
                } 
    } 
	void bubbleSort2(int b[]) 
    { 
		Instant start=Instant.now();
    
    	Instant end=Instant.now();
    	Long duration=Duration.between(start, end).toMillis();
    	double seconds=duration/1000.0;
    	System.out.println(" addupto"+seconds+"adduptoquick"+seconds);
        int n = b.length; 

        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (b[j] > b[j+1]) 
                { 
                     
                    int temp = b[j]; 
                    b[j] = b[j+1]; 
                    b[j+1] = temp; 
                } 
    } 
	void bubbleSort3(int c[]) 
    { 
		Instant start=Instant.now();
    
    	Instant end=Instant.now();
    	Long duration=Duration.between(start, end).toMillis();
    	double seconds=duration/1000.0;
    	System.out.println(" addupto"+seconds+"adduptoquick"+seconds);
        int n = c.length; 

        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (c[j] >c[j+1]) 
                { 
                     
                    int temp = c[j]; 
                    c[j] = c[j+1]; 
                    c[j+1] = temp; 
                } 
    } 
  
    
    void printArray1(int a[]) 
    { 
        int n = a.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(a[i] + " "); 
        System.out.println(); 
    } 
    void printArray2(int b[]) 
    { 
        int n = b.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(b[i] + " "); 
        System.out.println(); 
    } 
    void printArray3(int c[]) 
    { 
        int n = c.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(c[i] + " "); 
        System.out.println(); 
    } 
  
    
    public static void main(String args[]) 
    { 
        Bubblesort ob = new Bubblesort(); 
        int a[] = {64, 34, 25, 12, 22, 11, 90,110,120,540,4521,45789};
        int b[]= {10,20,30,40,50,60};
        int c[]= {100,90,80,70,60,50,40,30,20,10,00};
        ob.bubbleSort1(a); 
        ob.bubbleSort2(b); 
        ob.bubbleSort3(c); 
        System.out.println("Sorted array"); 
        ob.printArray1(a); 
        ob.printArray2(b);
        ob.printArray3(c); 
    } 
}
