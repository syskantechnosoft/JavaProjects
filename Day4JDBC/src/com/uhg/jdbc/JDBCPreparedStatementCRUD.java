package com.uhg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCPreparedStatementCRUD {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "root", "P@ssw0rd");

		String selectQuery = "select * from employee";
		PreparedStatement stmt = conn.prepareStatement(selectQuery);

		// Insert or Create Operation
		String insertQuery = "insert into employee values (103,'Java',8798568745,'java@gmail.com')";
		int insertStatus = 0;
		insertStatus = stmt.executeUpdate(insertQuery);
		if (insertStatus != 0)
			System.out.println("1 Record inserted Successfully!!!");

		// Update Operation
		String updateQuery = "update employee set emp_name='Java_updated' where emp_id=103";
		int updateStatus = 0;
		updateStatus = stmt.executeUpdate(updateQuery);
		if (updateStatus != 0)
			System.out.println("1 Record updated Successfully!!!");

		// Read Operation

		ResultSet rs = stmt.executeQuery(selectQuery);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getLong(3) + " " + rs.getString(4));
		}

		// Delete Operation
		String deleteQuery = "delete from employee where emp_id=103";
		int deleteStatus = 0;
		deleteStatus = stmt.executeUpdate(deleteQuery);
		if (deleteStatus != 0)
			System.out.println("1 Record deleted Successfully!!!");

		rs.close();
		stmt.close();
		conn.close();
	}
}
