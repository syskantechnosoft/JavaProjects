package com.uhg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowTableServlet
 */
@WebServlet("/ShowTableServlet")
public class ShowTablesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowTablesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
			conn = DriverManager.getConnection(url, "root", "P@ssw0rd");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("show tables");
			out.println("<h1 align='center'>List of Available Tables <h1>");
			out.print("<table border='1' align='center'>");
			out.print("<tr><th>Sl No</th><th>Table Name</th><th>Action</th></tr>");
			int i = 1;
			while (rs.next()) {
				out.println("<tr><td>" + i + "</td><td>" + rs.getString(1)
						+ "</td><td><a href='DisplayTableServlet?tableName=" + rs.getString(1)
						+ "'>View </a></td></tr>");
				i++;
			}
			out.print("</table>");
		} catch (Exception e) {
			out.println("Exception :" + e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
