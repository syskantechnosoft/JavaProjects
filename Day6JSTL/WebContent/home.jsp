<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<jsp:useBean id="emp" class="com.uhg.bean.EmployeeBean">
	</jsp:useBean>
	<jsp:setProperty property="empId" name="emp" value="150" />
	<jsp:setProperty property="empName" name="emp" value="UsingBean" />
	<jsp:setProperty property="mobile" name="emp" value="9089098876" />
	<jsp:setProperty property="email" name="emp" value="bean@gmail.com" />
	<jsp:getProperty property="empName" name="emp" />
</body>
</html>