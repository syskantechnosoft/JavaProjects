<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
	<c:if test="${ empty param.empid or empty param.empname}">
		<c:redirect url="insert.jsp">
			<c:param name="errMsg" value="Please Enter Product and Quantity" />
		</c:redirect>

	</c:if>
	<sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/uhg?useSSL=false" user="root" password="P@ssw0rd" />


	<sql:update dataSource="${dbsource}" var="result">
            INSERT INTO employee VALUES (?,?,?,?);
            <sql:param value="${param.empid}" />
		<sql:param value="${param.empname}" />
		<sql:param value="${param.mobile}" />
		<sql:param value="${param.email}" />
	</sql:update>
	<c:if test="${result>=1}">
		<c:redirect url="index.jsp">
			<c:param name="susMsg"
				value="Congratulations ! Data inserted
            successfully." />
		</c:redirect>
	</c:if>

</body>
</html>