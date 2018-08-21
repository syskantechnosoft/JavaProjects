package com.uhg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) throws Exception {
		// Step 1: Loading & Registering the Driver
		Class.forName("com.mysql.jdbc.Driver");
		//for OracleXE Driver => oracle.jdbc.driver.OracleDriver
		// Step 2: Establishing Connection
		String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
		//for OracleXE url = "jdbc:oracle:thin:@localhost:1521/xe";
		Connection conn = DriverManager.getConnection(url, "root", "P@ssw0rd");
		// Step 3: Create & Execute Query
		String query = "select * from employee";
		Statement stmt = conn.createStatement();
		// Step 4: Storing & Processing the result
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getLong(3) + " " + rs.getString(4));
		}
		// Step 5: close resources
		rs.close();
		stmt.close();
		conn.close();
	}

}
