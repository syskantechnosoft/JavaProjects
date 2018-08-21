package com.uhg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
			Connection conn = DriverManager.getConnection(url, "root", "P@ssw0rd");

			Statement stmt = conn.createStatement();
			String deleteQuery = "delete from employee where emp_id=";
			int empid = 0;
			if (request.getParameter("empid") != null)
				empid = Integer.parseInt(request.getParameter("empid"));
			int deleteStatus = 0;
			if (empid > 0) {
				deleteStatus = stmt.executeUpdate(deleteQuery + empid);
				if (deleteStatus != 0)
					response.sendRedirect("ViewEmployee");
				else
					out.print("<h2>Error while deleting the record!!! </h2>");
			} else {
				out.print("<h2>Invalid Employee ID!! Pls Check </h2>");
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			out.print("Exception :" + e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
