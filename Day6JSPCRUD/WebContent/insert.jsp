<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Employee Page</title>
</head>
<body>
	<a href='index.jsp'>Home</a> &nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;
	<a href="employeeData.html">Add Employee</a> &nbsp;&nbsp;&nbsp;
	|&nbsp;&nbsp;&nbsp;
	<a href="viewEmployees.jsp">View Employees</a>
	<%
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
				response.sendRedirect("viewEmployees.jsp");

		} catch (Exception e) {
			out.print("Exception :" + e.getMessage());
		}
	%>
</body>
</html>