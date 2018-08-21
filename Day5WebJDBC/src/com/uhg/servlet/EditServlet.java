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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditServlet() {
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

			Statement stmt = conn.createStatement();
			String selectQuery = "select * from employee where emp_id=";
			int empid = 0;
			if (request.getParameter("empid") != null)
				empid = Integer.parseInt(request.getParameter("empid"));
			ResultSet rs = null;
			if (empid > 0) {
				rs = stmt.executeQuery(selectQuery + empid);
				if (rs.next()) {
					out.print("<form action='UpdateServlet?empid=" + rs.getInt("emp_id")
							+ "'><table align='center' border='1'>");
					out.print("<tr>	<th>Sl No</th> <th>Column Name</th> <th>Column Value</th></tr>");
					out.print("<tr><td>1.</td><td>Employee ID</td><td><input type='text' name='empid' value='"
							+ rs.getInt("emp_id") + "' readonly='readonly'></td></tr>");
					out.print("<tr><td>2.</td><td>Employee Name :</td><td><input type='text' name='empname' value='"
							+ rs.getString("emp_name") + "'></td></tr>");

					out.print("<tr><td>3.</td><td>Employee Mobile :</td><td><input type='tel' name='mobile' value='"
							+ rs.getLong("mobile") + "'></td></tr>");
					out.print("<tr><td>4.</td><td>Employee Email:</td><td><input type='text' name='email' value='"
							+ rs.getString("email") + "'></td></tr>");
					out.print("<tr><td colspan='2' align='center'><input type='reset' value='Clear'></td>");
					out.print("<td align='center'><input type='submit' value='Update'></td></tr>");
					out.print("</table></form>");
				} else
					out.print("<h2>No Record Found in Database!!! </h2>");
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
