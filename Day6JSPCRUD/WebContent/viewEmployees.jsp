<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees Detail</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
			<a class="navbar-brand" href="#">UHG</a>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="employeeData.html">Add Employee</a></li>
				<!--  li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
				</li> -->
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<%
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/uhg?useSSL=false";
			Connection conn = DriverManager.getConnection(url, "root", "P@ssw0rd");
			Statement stmt = conn.createStatement();
			ResultSet rs = null;

			rs = stmt.executeQuery("select * from employee");
			ResultSetMetaData rsmd = rs.getMetaData();
			out.print("<table border='1' align='center' class='table table-striped table-hover'> <tr>");

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				out.print("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			out.println("<th>Action</th></tr>");
			while (rs.next()) {
				out.print("<tr>");
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					out.print("<td>" + rs.getString(i) + "</td>");
				}
				out.print("<td> <a href='edit.jsp?empid=" + rs.getString(1)
						+ "' class='btn btn-primary btn-sm active glyphicon glyphicon-pencil' role='button'>Edit</a>");
				out.print("||<a href='delete.jsp?empid=" + rs.getString(1)
						+ "' class='btn btn-danger btn-sm active glyphicon glyphicon-trash' role='button'>Delete</a> </td>");
				out.println("</tr>");
			}
			out.print("</table>");
		} catch (Exception e) {
			out.println("Exception :" + e.getMessage());
		}
	%>
</body>
</html>