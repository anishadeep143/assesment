<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Print Employee Details</h1>
<h2>Employee Information Added</h2>
    <table border=3>
    <tr>
    	<td>Employee Id</td>
    	<td>${emp.eid}</td>
    </tr>
        <tr>
            <td>Employee's Name :</td>
            <td>${emp.name}</td>
        </tr>
        <tr>
            <td>Employee's Designation</td>
            <td>${emp.desig}</td>
        </tr>
        <tr>
            <td>Employee's Email ID</td>
            <td>${emp.email}</td>
        </tr>
        <tr>
            <td>Employee's DepartmentNo</td>
            <td>${emp.deptNo}</td>
        </tr>
        <tr>
            <td>Employee's Salary</td>
            <td>${emp.salary}</td>
        </tr>
        
     </table>
     <br>
     Go Back To<a href="home">Home</a>Page
</body>
</html>