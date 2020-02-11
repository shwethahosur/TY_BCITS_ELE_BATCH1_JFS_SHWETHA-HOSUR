package com.bcits.usecase.test;

import java.util.Scanner;

public class BillCalculator {
	public double calculateBill(Integer units,String consumerType) {
		double billpay=0;
		if (consumerType.equalsIgnoreCase("Residential consumers")) {
			if (units <= 100) {
				billpay = units * 4;
			}else if(units <= 200) {
				
				billpay = 100 * 4 + (units - 100) * 5;
			}	else {
				billpay = 100 * 4 + 100 * 5 + (units - 200) * 8;
			}
				
			return 	billpay;
		} else if (consumerType.equalsIgnoreCase("Commercial  consumers")) {
			if (units <= 1000) {
				billpay = units * 10;
			}else if (units <= 2000) {
				billpay = 1000 * 10 + (units - 1000) * 15;
			}else  {
				billpay = 1000 * 10 + 1000 * 15 + (units - 2000) * 18;
			}
			
		}else if(consumerType .equalsIgnoreCase("Industries   consumers")) {
			if (units <= 10000) {
				billpay = units * 15;
			}else if (units <= 20000) {
				billpay = 10000 * 15 + (units - 10000) * 20;
			}	else  {
				billpay = 10000 * 15 + 10000 * 20 + (units - 20000) * 25;
			}
			return billpay;
		}
		return 0.00;
		}
	
}
