package com.uhg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "root", "P@ssw0rd");

		PreparedStatement pstmt = conn.prepareStatement("select * from employee where emp_id=?");
		int empId = 102;
		pstmt.setInt(1, empId);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getLong(3) + " " + rs.getString(4));
		}

		rs.close();
		pstmt.close();
		conn.close();
	}

}
