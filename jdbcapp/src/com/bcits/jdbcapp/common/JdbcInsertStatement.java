package com.bcits.jdbcapp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcInsertStatement {
	public static void main(String[] args) {
		Connection con = null;
		int rs;
		Statement stmt = null;

		try {

			FileInputStream inputstream = new FileInputStream("dbinfo.properties");
			Properties properties = new Properties();
			properties.load(inputstream);
			Class.forName(properties.getProperty("driverNM")).newInstance();

			con = DriverManager.getConnection(properties.getProperty("dbUrl"), properties);

			String query = "insert into employee_primary_info values(27,'suma',9652142512,'divya@gmail.com','1997-05-29','2019-02-02','developer','b+',25000,30,25)";

			stmt = con.createStatement();
			rs = stmt.executeUpdate(query);

			if (rs != 0) {
				System.out.println("inserted successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
