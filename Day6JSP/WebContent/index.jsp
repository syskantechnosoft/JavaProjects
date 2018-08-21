<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<h1>
		Today Date is :
		<%=new Date()%>
	</h1>
	<header>This is Header</header>
	<aside></aside>

	<%
		session.setMaxInactiveInterval(10);
	%>
	<h3 align="center">Session Details</h3>
	<table border="1" align="center">
		<tr>
			<th>Sl No</th>
			<th>Session Parameter</th>
			<th>Session Value</th>
		</tr>
		<tr>
			<td>1.</td>
			<td>Session Creation Time</td>
			<td><%=new Date(session.getCreationTime())%></td>
		</tr>
		<tr>
			<td>2.</td>
			<td>Last Accessed Time</td>
			<td><%=new Date(session.getLastAccessedTime())%></td>
		</tr>
		<tr>
			<td>3.</td>
			<td>Max Inactive Interval</td>
			<td><%=session.getMaxInactiveInterval()%></td>
		</tr>
		<tr>
			<td>4.</td>
			<td>Session ID</td>
			<td><%=session.getId()%></td>
		</tr>
	</table>
	<footer>All Rights Reserved &reg;. Copy Rights&copy; Registered</footer>
	
</body>
</html>