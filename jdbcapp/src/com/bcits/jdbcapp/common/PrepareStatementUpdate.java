package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStatementUpdate {
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
			String query = "update employee_primary_info set name=? where empid=?";
			pstmt = con.prepareStatement(query);
			//System.out.println("enter empid");
			
			pstmt.setString(1, args[0]);
			pstmt.setInt(2, Integer.parseInt(args[1]));
			
	
			
			int rs = pstmt.executeUpdate();

			if (rs != 0) {
				System.out.println("updated successfully");
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
}
