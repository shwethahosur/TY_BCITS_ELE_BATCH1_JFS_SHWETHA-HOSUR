package com.bcits.fileproperties.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
public static void main(String[] args) {
	try {
		FileInputStream inputstream=new FileInputStream("dbinfo.properties");
		Properties properties =new Properties();
		try {
			properties.load(inputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Dbnm=====>"+properties.getProperty("driverNM"));
		System.out.println("dbUrl=====>"+properties.getProperty("dbUrl"));
		System.out.println("user======>"+properties.getProperty("user"));
		System.out.println("password======>"+properties.getProperty("password"));
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
