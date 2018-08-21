package com.uhg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
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
		response.setContentType("text/html");
		out.print("<a href='index.html'>Home</a> &nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;");
		out.print("<a href='employeeData.html'>Add Employee</a> &nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;");
		out.print("<a href='ViewEmployee'>View Employees</a>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
			Connection conn = DriverManager.getConnection(url, "root", "P@ssw0rd");
			String insertQuery = "insert into employee values (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			int empId = 0;
			String empName = "";
			String email = "";
			long mobile = 0;

			if (request.getParameter("empid") != null)
				empId = Integer.parseInt(request.getParameter("empid"));
			if (request.getParameter("empname") != null)
				empName = request.getParameter("empname");
			if (request.getParameter("mobile") != null)
				mobile = Long.parseLong(request.getParameter("mobile"));
			if (request.getParameter("email") != null)
				email = request.getParameter("email");

			pstmt.setInt(1, empId);
			pstmt.setString(2, empName);
			pstmt.setLong(3, mobile);
			pstmt.setString(4, email);

			int insertStaus = 0;
			if (empId > 0 && mobile > 0 && empName != "" && email != "") {
				insertStaus = pstmt.executeUpdate();
			} else {
				out.print("<h3>Some Parameters missing!!!! </h3>");
			}

			if (insertStaus != 0)
				out.println("<h2>1 Record Inserted Successfully!!! </h2>");

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
