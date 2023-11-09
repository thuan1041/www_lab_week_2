<%@ page import="vn.edu.iuh.fit.www_lab_week2.services.EmployeeServices" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Thuan Tran
  Date: 11/10/2023
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
<table>
    <tr>
        <td>ID</td>
        <td>Full name</td>
        <td>Address</td>
        <td>Email</td>
        <td>Date of birth</td>
        <td>Phone</td>
        <td>Status</td>
    </tr>
    <%
        EmployeeServices employeeServices = new EmployeeServices();
        List<Employee> employeeList = employeeServices.findAllEmployee();
        for(Employee employee : employeeList) {
    %>
        <tr>
            <td><%=employee.getEmployeeId() %></td>
            <td><%=employee.getFullName() %></td>
            <td><%=employee.getAddress() %></td>
            <td><%=employee.getEmail() %></td>
            <td><%=employee.getDob() %></td>
            <td><%=employee.getPhone() %></td>
            <td><%=employee.getStatus() %></td>
        </tr>
    <%
        }
    %>
</table>
</head>
<body>

</body>
</html>
