<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Employees List</h2>

 
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
	<table border=3>
	<tr>
		<th>Employee Id</th><th>Employee Name</th><th>Designation</th>
		<th>Employee's Email</th><th>Employee's Salary</th><th>Department No</th>
	</tr>
		<c:forEach var="e" items="${emps}"> <!-- for(Mobile m:mlist) -->
			<tr>
				<td>${e.eid}</td>
				<td>${e.name}</td>
				<td>${e.desig}</td>
				<td>${e.email}</td>
				<td>${e.salary}</td>
				<td>${e.deptNo}</td>
			</tr>
		</c:forEach>
	</table>
</center>
</body>
</html>