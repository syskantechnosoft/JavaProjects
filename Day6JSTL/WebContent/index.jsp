<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
<script>
	function confirmGo(m, u) {
		if (confirm(m)) {
			window.location = u;
		}
	}
</script>
</head>
<body>
	<sql:setDataSource var="conn" driver="com.mysql.jdbc.Driver"
		user="root" password="P@ssw0rd"
		url="jdbc:mysql://localhost:3306/uhg?useSSL=false" />
	<sql:query var="rs" dataSource="${conn}">select * from employee</sql:query>
	<p align="center">
		<a href="AddEmployee.html">Add Employee</a>
	</p>
	<table border='1' align='center'>
		<tr>
			<th>Emp ID</th>
			<th>Emp Name</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<core:forEach var="emp" items="${rs.rows}">
			<tr>
				<td><core:out value="${emp.emp_id}"></core:out></td>
				<td><core:out value="${emp.emp_name}"></core:out></td>
				<td><core:out value="${emp.mobile}"></core:out></td>
				<td><core:out value="${emp.email}"></core:out></td>
				<td><a href="edit.jsp?empid=<core:out value='${emp.emp_id}'/>">Edit</a>
					|| <a
					href="javascript:confirmGo('Sure to delete this record?','delete.jsp?empid=<core:out value="${emp.emp_id}"/>')">Delete</a></td>

			</tr>
		</core:forEach>
		<!--  
		<font color="red"><core:if test="${not empty param.errMsg}">
				<c:out value="${param.errMsg}" />
				  <a href="index.jsp">Go Back</a> 
			</core:if></font>
		<font color="green"><core:if test="${not empty param.susMsg}">
				<c:out value="${param.susMsg}" /> 
			</core:if></font> 
		-->
	</table>

</body>
</html>