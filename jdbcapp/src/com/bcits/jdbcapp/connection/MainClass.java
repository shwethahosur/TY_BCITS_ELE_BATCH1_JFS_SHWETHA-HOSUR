package com.bcits.jdbcapp.connection;

public class MainClass {
public static void main(String[] args) {
	String str="one";
	Connection con=DriverManager.getConnection(str);
	con.method();
	
}
}
