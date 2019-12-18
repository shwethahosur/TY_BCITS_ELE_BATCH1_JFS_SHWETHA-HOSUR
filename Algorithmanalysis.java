package com.jsp.p1;

import java.time.Duration;
import java.time.Instant;

public class Algorithmanalysis {
public static long addupto(Long num) {
	Long total=0L;
	for(Long i=0L;i<=num;i++) {
		total=total+i;
	}
	return total;
}
public static  Long adduptoQuick(Long num) {
	return num*(num+1)/2;
}
public static void countDurationaddupto() {
	Long num=99999999L;
	Instant start=Instant.now();
	System.out.println(adduptoQuick(num));
	Instant end=Instant.now();
	Long duration=Duration.between(start, end).toMillis();
	double seconds=(duration/1000.0);
	System.out.println(" addupto"+seconds+"adduptoquick");
	
}
public static void countDurationAdduptoQuick() {
	Long num=999999L;
	Instant start=Instant.now();
	System.out.println(adduptoQuick(num));
	Instant end=Instant.now();
	Long duration=Duration.between(start, end).toMillis();
	double seconds=duration/1000.0;
	System.out.println(" addupto"+seconds+"adduptoquick");
	
	
}
public static void main(String[] args) {
	countDurationaddupto()	;
	countDurationAdduptoQuick();
}
}
