package com.uhg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JDBCServlet
 */
@WebServlet("/JDBCServlet")
public class JDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JDBCServlet() {
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
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
			Connection conn = DriverManager.getConnection(url, "root", "P@ssw0rd");

			String query = "select * from employee";
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			out.print("<table align='center' border='1'>");
			out.print("<tr><th>Emp ID</th><th>Emp Name</th><th>Mobile</th><th>EMail</th></tr>");

			while (rs.next()) {
				out.println("<tr> <td>" + rs.getInt(1) + "</td><td> " + rs.getString(2) + "</td><td> " + rs.getLong(3)
						+ "</td><td> " + rs.getString(4) + "</td></tr>");
			}
			out.print("</table>");
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			out.print("Exception :" + e.getMessage());
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
