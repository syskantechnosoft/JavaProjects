<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<a href='index.jsp'>Home</a> &nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;
	<a href='employeeData.html'>Add Employee</a> &nbsp;&nbsp;&nbsp;
	|&nbsp;&nbsp;&nbsp;
	<a href='viewEmployees.jsp'>View Employees</a>
	<%
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
				response.sendRedirect("viewEmployees.jsp");

		} catch (Exception e) {
			out.print("Exception :" + e.getMessage());
		}
	%>
</body>
</html>