package com.bcits.hugecase1.consumer_db;

import java.util.Scanner;

public class BillCalculator {
	public static void main(String args[]) {
		long units;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the type of consumer");
		String typeOfConsumer = sc.nextLine();
		System.out.println("enter number of units");

		units = sc.nextLong();

		double billpay = 0;
		if (typeOfConsumer.equalsIgnoreCase("Residential consumers")) {
			if (units <= 100)
				billpay = units * 4;

			else if (units <= 200)
				billpay = 100 * 4 + (units - 100) * 5;

			else if (units > 200)
				billpay = 100 * 4 + 100 * 5 + (units - 200) * 8;

			System.out.println("Bill to pay : " + billpay);
		} else if (typeOfConsumer.equalsIgnoreCase("Commercial  consumers")) {
			if (units <= 100)
				billpay = units * 10;

			else if (units <= 200)
				billpay = 100 * 10 + (units - 100) * 15;

			else if (units > 200)
				billpay = 100 * 10 + 100 * 15 + (units - 200) * 18;

			System.out.println("Bill to pay : " + billpay);
		}else if(typeOfConsumer .equalsIgnoreCase("Industries   consumers")) {
			if (units <= 100)
				billpay = units * 15;

			else if (units <= 200)
				billpay = 100 * 15 + (units - 100) * 20;

			else if (units > 200)
				billpay = 100 * 15 + 100 * 20 + (units - 200) * 25;

			System.out.println("Bill to pay : " + billpay);
		}
	}
}
