package com.uhg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCCRUD1 {
	private static Connection conn = null;
	private static Statement stmt = null;

	public static void getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
		conn = DriverManager.getConnection(url, "root", "P@ssw0rd");
		stmt = conn.createStatement();
	}

	public void insert() throws Exception {
		String insertQuery = "insert into employee values (103,'Java',8798568745,'java@gmail.com')";
		int insertStatus = 0;
		insertStatus = stmt.executeUpdate(insertQuery);
		if (insertStatus != 0)
			System.out.println("1 Record inserted Successfully!!!");
	}

	public void update() throws Exception {
		String updateQuery = "update employee set emp_name='Java1' where emp_id=103";
		int updateStatus = 0;
		updateStatus = stmt.executeUpdate(updateQuery);
		if (updateStatus != 0)
			System.out.println("1 Record updated Successfully!!!");

	}

	public void delete() throws Exception {
		String deleteQuery = "delete from employee where emp_id=103";
		int deleteStatus = 0;
		deleteStatus = stmt.executeUpdate(deleteQuery);
		if (deleteStatus != 0)
			System.out.println("1 Record deleted Successfully!!!");

	}

	public void read() throws Exception {
		String selectQuery = "select * from employee";
		ResultSet rs = stmt.executeQuery(selectQuery);
		while (rs.next()) {
			System.out.println("______________________________________");
			System.out.println(
					"|" + rs.getInt(1) + "|" + rs.getString(2) + "|" + rs.getLong(3) + "|" + rs.getString(4) + "|");
			System.out.println("|-------------------------------------|");
		}
	}

	public void close() throws Exception {
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public static void main(String[] args) {
		JDBCCRUD1 jdbc = new JDBCCRUD1();
		try {
			JDBCCRUD1.getConnection();
			jdbc.insert();
			jdbc.update();
			jdbc.read();
			jdbc.delete();
			jdbc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
