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
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<a href='index.html'>Home</a> &nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;");
		out.print("<a href='employeeData.html'>Add Employee</a> ");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
			Connection conn = DriverManager.getConnection(url, "root", "P@ssw0rd");
			Statement stmt = conn.createStatement();
			ResultSet rs = null;

			rs = stmt.executeQuery("select * from employee");
			ResultSetMetaData rsmd = rs.getMetaData();
			out.print("<table border='1' align='center'> <tr>");

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				out.print("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			out.println("<th>Action</th></tr>");
			while (rs.next()) {
				out.print("<tr>");
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					out.print("<td>" + rs.getString(i) + "</td>");
				}
				out.print("<td> <a href='EditServlet?empid=" + rs.getString(1) + "'>edit</a>");
				out.print("||<a href='DeleteServlet?empid=" + rs.getString(1) + "'>delete</a> </td>");
				out.println("</tr>");
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
