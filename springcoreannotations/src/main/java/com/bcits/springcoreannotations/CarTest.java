package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springannotation.beans.Car;

public class CarTest {
	public static void main(String[] args) {
		
	
ApplicationContext context =new AnnotationConfigApplicationContext("carConfig1.xml");
Car myCar = context.getBean("car", Car.class);
//Car myCar=context.getBean("car", Car.class);
//Car myCar= context.getBean("car",Car.class);
System.out.println(myCar.getCompany());
System.out.println(myCar.getEngine().getCc());
System.out.println(myCar.getEngine().getType());
}
}