<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<%
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
					response.sendRedirect("viewEmployees.jsp");
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
	%>
</body>
</html>