package com.bcits.abstraction;

public class DriverManager {
private DriverManager() {
	
}
public static Connection getconnection(String dbUrl) {
	Connection con=null;
	if(dbUrl.equals("one")) {
		con=new ClassX();
	}else {
		con=new ClassY();
	}
	return con;
	
}//end of getconnection
}//end of class
