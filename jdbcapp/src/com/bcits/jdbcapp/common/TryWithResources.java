package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TryWithResources {
	public static void main(String[] args) {
//		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dburl="";
//1.load the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// 2.get db connection via driver

			 dburl = "jdbc:mysql://localhost:3306/employee_management";
//			con = DriverManager.getConnection(dburl, "root", "ROOT");
			//3.issue the sql queries
			String query = " select * from employee_primary_info " 
			+ " where empid=? ";
			//pstmt = con.prepareStatement(query);
			
			//rs = pstmt.executeQuery();

			if (rs.next()) {
				int empid = rs.getInt("empid");
				String name = rs.getString("name");
				long phno = rs.getLong("phno");
				String official_mail_id = rs.getString("official_mail_id");
				Date date_of_birth = rs.getDate("date_of_birth");
				Date date_of_joining = rs.getDate("date_of_joining");
				String designation = rs.getString("designation");
				String blood_group = rs.getString("blood_group");
				int deptid = rs.getInt("deptid");
				int manager_id = rs.getInt("manager_id");

				System.out.println("employee id===>" + empid);
				System.out.println("employee name===>" + name);
				System.out.println("employee phno===>" + phno);
				System.out.println("employee official_mail_id===>" + official_mail_id);
				System.out.println("employee date_of_birth ===>" + date_of_birth);
				System.out.println("employee date_of_joining ===>" + date_of_joining);
				System.out.println("employee designation===>" + designation);
				System.out.println("employee blood_group ===>" + blood_group);
				System.out.println("employee deptid===>" + deptid);
				System.out.println("employee manager_id===>" + manager_id);

			} else {
				System.err.println("employee data not found in db!!!");
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			String query = " select * from employee_primary_info " 
			+ " where empid=? ";
			pstmt.setInt(1, Integer.parseInt(args[0]));
			//5.close all the jdbc objects
			try( Connection con = DriverManager.getConnection(dburl, "root", "ROOT");
					PreparedStatement pstmt = con.prepareStatement(query);
					ResultSet rs1 = pstmt.executeQuery();
					) {
				if (con != null) {
					con.close();

				}
				if (rs1 != null) {
					rs1.close();

				}
				if (pstmt1 != null) {
					pstmt1.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}//end of inner try catch block

		}//end of finally

	}//end of main
}
