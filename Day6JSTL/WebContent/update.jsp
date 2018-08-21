<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Page</title>
</head>
<body>
	<sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/uhg?useSSL=false" user="root" password="P@ssw0rd" />
	<sql:update dataSource="${dbsource}" var="count">
            UPDATE employee SET emp_name = ?, mobile=?, email=?
            WHERE emp_id='${param.empid}'
            <sql:param value="${param.empname}" />
		<sql:param value="${param.mobile}" />
		<sql:param value="${param.email}" />
	</sql:update>
	<c:if test="${count>=1}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
</body>
</html>