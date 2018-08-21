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
<title>Edit Employee</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
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
				<li class="nav-item"><a class="nav-link "
					href="viewEmployees.jsp">View Employees</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<a href='index.jsp'>Home</a> &nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;
	<a href='employeeData.html'>Add Employee</a> &nbsp;&nbsp;&nbsp;
	|&nbsp;&nbsp;&nbsp;
	<a href='viewEmployees.jsp'>View Employees</a>
	<%
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
	%>

	<form action="update.jsp?empid=" <%=rs.getInt("emp_id")%>>
		<table align='center' border='1'
			class="table table-striped table-hover">

			<tr>
				<th>Sl No</th>
				<th>Column Name</th>
				<th>Column Value</th>
			</tr>

			<tr>
				<td>1.</td>
				<td>Employee ID</td>
				<td><input type='text' name='empid'
					value='<%=rs.getInt("emp_id")%>' readonly='readonly'></td>
			</tr>

			<tr>
				<td>2.</td>
				<td>Employee Name :</td>
				<td><input type='text' name='empname'
					value='<%=rs.getString("emp_name")%>'></td>
			</tr>

			<tr>
				<td>3.</td>
				<td>Employee Mobile :</td>
				<td><input type='tel' name='mobile'
					value='<%=rs.getLong("mobile")%>'></td>
			</tr>

			<tr>
				<td>4.</td>
				<td>Employee Email:</td>
				<td><input type='text' name='email'
					value='<%=rs.getString("email")%>'></td>
			</tr>

			<tr>
				<td colspan='2' align='center'><input type='reset'
					value='Clear'></td>
				<td align='center'><input type='submit' value='Update'></td>
			</tr>
		</table>
	</form>

	<%
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
	%>
</body>
</html>