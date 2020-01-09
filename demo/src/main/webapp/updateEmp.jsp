<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update Employee Page</h1>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<table>
	<form:form method="post" action="/updateEmp" modelAttribute="emp">
		<tr>
			<td><form:label path="eid">Enter Employee's ID</form:label></td>
			<td><form:input  path="eid"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="name">Enter Employee's Name</form:label></td>
			<td><form:input path="name"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="desig">Enter Employee's Designation</form:label></td>
			<td><form:input path="desig"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="deptNo">Enter Employee's Department No</form:label></td>
			<td><form:input  path="deptNo"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="email">Enter Employee's Email</form:label></td>
			<td><form:input  path="email"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="salary">Enter Employee's Salary</form:label></td>
			<td><form:input path="salary"></form:input></td>
		</tr>
		<tr>
			<td><input type=submit value="Add Employee"></td>
			<td><input type=reset value="Reset"></td>
		</tr>
		</table> 
	</form:form>
	Click <a href="home">Home</a>To Go Back 
</body>
</html>