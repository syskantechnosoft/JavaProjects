<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
	<sql:setDataSource var="conn" driver="com.mysql.jdbc.Driver"
		user="root" password="P@ssw0rd"
		url="jdbc:mysql://localhost:3306/uhg?useSSL=false" />
	<p align="center">
		<a href="index.jsp">Home</a> <a href="AddEmployee.html">Add
			Employee</a>
	</p>
	<sql:query dataSource="${conn}" var="result">
            SELECT * from employee where emp_id=?;
            <sql:param value="${param.empid}" />
	</sql:query>
	<form action="update.jsp" method="post">
		<table border="1" width="40%">
			<caption>Edit Employee</caption>
			<tr>
				<th>Emp Name</th>
				<th>Mobile</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach var="row" items="${result.rows}">
				<tr>
					<td><input type="hidden" value="${param.empid}" name="empid" />
						<input type="text" value="${row.emp_name}" name="empname" /></td>
					<td><input type="text" value="${row.mobile}" name="mobile" /></td>
					<td><input type="text" value="${row.email}" name="email" /></td>
					<td><input type="submit" value="Update" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>