package com.uhg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class GenericReadTable {

	public static void main(String[] args) throws Exception {
		int option = 1;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		Scanner input = new Scanner(System.in);
		String showQuery = "show tables";
		String selectQuery = "select * from ";
		String tableName = null;
		while (option != 2) {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
			conn = DriverManager.getConnection(url, "root", "P@ssw0rd");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(showQuery);

			System.out.println("List of Available Tables");
			rs.last();			
			while (!rs.isBeforeFirst()) {
				System.out.println(rs.getString(1));
				rs.previous();
			}

			System.out.println("\n\t\t\t1. Show Table \n\t\t\t2. Exit");
			System.out.println("Enter Your choice (1/2):");
			option = input.nextInt();
			if (option == 1) {
				System.out.println("Please Enter Table Name :");
				tableName = input.next();
				rs = stmt.executeQuery(selectQuery + tableName);
				rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					System.out.print(rsmd.getColumnName(i) + "\t");
				}
				System.out.println(" ");
				while (rs.next()) {
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						System.out.print(rs.getString(i) + "\t");
					}
					System.out.println(" ");
				}
			}

		}
		if (option == 2)
			System.out.println("Terminating the Application");
		input.close();
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}

}
