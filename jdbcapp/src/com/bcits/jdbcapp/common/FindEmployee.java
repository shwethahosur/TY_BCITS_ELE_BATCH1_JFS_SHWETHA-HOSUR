package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FindEmployee {
public static void main(String[] args) {
	Connection con =null;
	Statement stmt=null;
	ResultSet rs=null;
	try {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		String dbUrl = "jdbc:mysql://localhost:3306/employee_management?user=root&password=ROOT";
		 con = DriverManager.getConnection(dbUrl);

		String query = "select * from employee_primary_info"
				+" where empid=3 ";
		 stmt = con.createStatement();
		 rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			int empid=rs.getInt("empid");
			String name =rs.getString("name");
			long phno =rs.getLong("phno");
			String official_mail_id=rs.getString("official_mail_id");
			Date date_of_birth =rs.getDate("date_of_birth");
			Date date_of_joining =rs.getDate("date_of_joining");
			String designation =rs.getString("designation");
			String blood_group = rs.getString("blood_group");
			int deptid = rs.getInt("deptid");
			int manager_id = rs.getInt("manager_id");

			System.out.println("employee id===>" + empid);
			System.out.println("employee name===>" + name);
			System.out.println("employee phno===>" +phno);
			System.out.println("employee official_mail_id===>" + official_mail_id);
			System.out.println("employee date_of_birth ===>" + date_of_birth);
			System.out.println("employee date_of_joining ===>" + date_of_joining);
			System.out.println("employee designation===>" + designation);
			System.out.println("employee blood_group ===>" + blood_group);
			System.out.println("employee deptid===>" + deptid);
			System.out.println("employee manager_id===>" + manager_id);

		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
		if(con!=null) {
			con.close();
			
		}
		if(rs!=null) {
			rs.close();
	
		}
		if(stmt!=null) {
			stmt.close();
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}}
