<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Page</title>
</head>
<body>
	<sql:setDataSource var="conn" driver="com.mysql.jdbc.Driver"
		user="root" password="P@ssw0rd"
		url="jdbc:mysql://localhost:3306/uhg?useSSL=false" />

	<sql:update dataSource="${conn}" var="count">
            DELETE FROM employee
            WHERE emp_id='${param.empid}'
        </sql:update>
	<core:if test="${count>=1}">
		<!-- <font size="5" color='green'> Congratulations ! Data deleted
            successfully.</font>
              <a href="index.jsp">Go Home</a>    -->
		<core:redirect url="index.jsp"></core:redirect>
	</core:if>
</body>
</html>