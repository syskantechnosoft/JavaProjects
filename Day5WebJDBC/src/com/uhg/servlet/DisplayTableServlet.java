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
 * Servlet implementation class DisplayTableServlet
 */
@WebServlet("/DisplayTableServlet")
public class DisplayTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayTableServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
			conn = DriverManager.getConnection(url, "root", "P@ssw0rd");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("show tables");
			String tableName = "";
			if (request.getParameter("tableName") != null) {
				tableName = request.getParameter("tableName");
				rs = stmt.executeQuery("select * from " + tableName);
				rsmd = rs.getMetaData();
				out.print("<table border='1' align='center'> <tr>");

				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					out.print("<th>" + rsmd.getColumnName(i) + "</th>");
				}
				out.println("</tr>");
				while (rs.next()) {
					out.print("<tr>");
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						out.print("<td>" + rs.getString(i) + "</td>");
					}
					out.println("</tr>");
				}
				out.print("</table>");
			} else {
				out.print("<h3>Table name is invalid or empty!!!</h3>");
			}
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
