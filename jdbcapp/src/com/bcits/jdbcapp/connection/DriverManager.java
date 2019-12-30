package com.bcits.jdbcapp.connection;

public class DriverManager {
private DriverManager() {
	
}
public static Connection getConnection(String str) {
	Connection con=null;
	if(str.equals("one")) {
		con=new ClassA();
	}else {
		con= new ClassB();
	}
	return con;
}
}
