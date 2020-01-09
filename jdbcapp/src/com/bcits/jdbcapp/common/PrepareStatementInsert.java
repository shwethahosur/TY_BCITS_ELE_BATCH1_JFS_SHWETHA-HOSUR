package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatementInsert {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		

//1.load the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// 2.get db connection via driver

			String dburl = "jdbc:mysql://localhost:3306/employee_management";
			con = DriverManager.getConnection(dburl, "root", "ROOT");
			//3.issue the sql queries
			String query = " insert into employee_primary_info values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			//System.out.println("enter empid");
			pstmt.setInt(1, Integer.parseInt(args[0]));
			//System.out.println("enter empname");
			pstmt.setString(2, args[1]);
			//System.out.println("enter phno");
			pstmt.setLong(3, Long.parseLong(args[2]));
			//System.out.println("enter official_mail_id");
			pstmt.setString(4, args[3]);
			
			//System.out.println("date_of_birth");
			pstmt.setDate(5, Date.valueOf(args[4]));
			
			//System.out.println("date_of_joining");
			pstmt.setDate(6, Date.valueOf(args[5]));
			//System.out.println("designation");
			pstmt.setString(7, args[6]);
			//System.out.println("blood_group");
			pstmt.setString(8, args[7]);
			//System.out.println("salary");
			pstmt.setDouble(9, Double.parseDouble(args[8]));
			//System.out.println("deptid");
			pstmt.setInt(10, Integer.parseInt(args[9]));
			//System.out.println("manager_id");
			pstmt.setInt(11, Integer.parseInt(args[10]));
	
			
			int rs = pstmt.executeUpdate();

			if (rs != 0) {
				System.out.println("inserted successfully");
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			//5.close all the jdbc objects
			try {
				if (con != null) {
					con.close();

				}
				
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}//end of inner try catch block

		}//end of finally

	}//end of main

}//end of class

