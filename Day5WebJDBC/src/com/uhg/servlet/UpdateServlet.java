package com.uhg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<a href='index.html'>Home</a> &nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;");
		out.print("<a href='employeeData.html'>Add Employee</a> &nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;");
		out.print("<a href='ViewEmployee'>View Employees</a>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
			Connection conn = DriverManager.getConnection(url, "root", "P@ssw0rd");
			String updateQuery = "update employee set emp_name=?, mobile=?, email=? where emp_id=?";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
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

			pstmt.setString(1, empName);
			pstmt.setLong(2, mobile);
			pstmt.setString(3, email);
			pstmt.setInt(4, empId);

			int updateStaus = 0;
			if (empId > 0 && mobile > 0 && empName != "" && email != "") {
				updateStaus = pstmt.executeUpdate();
			} else {
				out.print("<h3>Some Parameters missing!!!! </h3>");
			}

			if (updateStaus != 0)
				response.sendRedirect("ViewEmployee");

		} catch (Exception e) {
			out.print("Exception :" + e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
