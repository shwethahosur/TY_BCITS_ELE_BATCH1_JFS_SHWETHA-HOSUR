package com.bcits.jdbcapp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDeleteStatement {
	public static void main(String[] args) {
		Connection con = null;
		int rs;
		Statement stmt = null;
		try {
			FileInputStream input = new FileInputStream("dbinfo.properties");
			Properties prop = new Properties();
			prop.load(input);
			Class.forName(prop.getProperty("driverNM")).newInstance();
			con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop);
			String qry = "delete from employee_primary_info where empid=15";
			stmt = con.createStatement();
			rs = stmt.executeUpdate(qry);
			if (rs != 0) {
				System.out.println("deleted the record successfully");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();

				}

				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
	}
}