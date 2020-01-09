package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStatementDelete {
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
			String query = "delete from employee_primary_info where empid=?";
			pstmt = con.prepareStatement(query);
			//System.out.println("enter empid");
			
			
			pstmt.setInt(1, Integer.parseInt(args[0]));
			
	
			
			int rs = pstmt.executeUpdate();

			if (rs != 0) {
				System.out.println("deleted successfully");
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
