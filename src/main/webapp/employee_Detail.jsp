<%@ page import="vn.edu.iuh.fit.www_lab_week2.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Thuan Tran
  Date: 11/12/2023
  Time: 1:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Detail</title>
</head>
<body>
<% Employee employee= (Employee) request.getAttribute("employee"); %>
<p>id: <%= employee.getEmpId() %></p>
<p>name: <%= employee.getFullName() %></p>
<p>Day of birth: <%= employee.getDob() %></p>
<p>email: <%= employee.getEmail() %></p>
<p>phone: <%= employee.getPhone() %></p>
<p>Address: <%= employee.getAddress() %></p>
<p>Status: <%= employee.getStatus() %></p>
</body>
</html>
