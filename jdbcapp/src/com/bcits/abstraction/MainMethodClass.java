package com.bcits.abstraction;

public class MainMethodClass {
public static void main(String[] args) {
	String dbUrl="one";
Connection con=DriverManager.getconnection(dbUrl);
Statement stmt=con.createStatement();
stmt.method1();
}
}
