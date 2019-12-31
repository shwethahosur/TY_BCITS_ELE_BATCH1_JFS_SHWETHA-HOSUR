package com.bcits.fileproperties.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileWrite {
public static void main(String[] args) {
	try {
		FileOutputStream fileoutputstream=new FileOutputStream("dbinfo.properties");
		Properties properties =new Properties();
		properties.setProperty("driverNM", "com.mysql.jdbc.Driver");
		properties.setProperty("dbUrl", "jdbc:mysql://localhost:3306/employee_management");
		properties.setProperty("user", "root");
		properties.setProperty("password", "ROOT");
		
		try {
			properties.store(fileoutputstream, "Db details");
			System.out.println("File created");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}//end of the method
}//end of the class
