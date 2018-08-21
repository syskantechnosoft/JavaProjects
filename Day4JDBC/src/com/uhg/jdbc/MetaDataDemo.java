package com.uhg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaDataDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "root", "P@ssw0rd");

		String query = "select * from employee";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i) + "\t");
		}
		System.out.println(" ");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getLong(3) + "\t" + rs.getString(4));
		}

		rs.close();
		stmt.close();
		conn.close();
	}

}
