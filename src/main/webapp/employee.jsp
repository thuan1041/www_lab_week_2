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
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
    </style>
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
            <td><%=employee.getEmpId() %></td>
            <td><%=employee.getFullName() %></td>
            <td><%=employee.getAddress() %></td>
            <td><%=employee.getEmail() %></td>
            <td><%=employee.getDob() %></td>
            <td><%=employee.getPhone() %></td>
            <td><%=employee.getStatus() %></td>
            <td>
                <a href="employeeController?action=updateEmployee&id=<%=employee.getEmpId()%>">Update</a>
            </td>
            <td>
                <a href="employeeController?action=viewEmployee&id=<%=employee.getEmpId()%>">View Detail</a>
            </td>
        </tr>
    <%
        }
    %>
</table>

<form action="employeeController" method="post">
    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName" >

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" >

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" >

    <label for="dob">Date of Birth:</label>
    <input type="date" id="dob" name="dob" >

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" >

    <label for="status">Status:</label>
    <select id="status" name="status" >
        <option value="ACTIVE" selected>Active</option>
        <option value="IN_ACTIVE">Inactive</option>
        <option value="TERMINATED">TERMINATED</option>
    </select>
    <button type="submit"  name="action" value="insertEmployee">Insert Employee</button>


</form>

</head>
<body>

</body>
</html>
