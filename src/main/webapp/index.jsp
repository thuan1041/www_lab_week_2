<%@ page import="vn.edu.iuh.fit.www_lab_week2.services.EmployeeServices" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%--<a href="employee.jsp">Employee</a>--%>
<a href="employeeController?action=getAllEmployee">Employee</a>
<%
  EmployeeServices employeeServices = new EmployeeServices();
%>
</body>
</html>