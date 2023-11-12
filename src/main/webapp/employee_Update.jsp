<%@ page import="vn.edu.iuh.fit.www_lab_week2.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Thuan Tran
  Date: 11/11/2023
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
<% Employee employee = (Employee) request.getAttribute("employee");%>
<form action="employeeController?action=updateEmployeePost" method="post">
    <label for="id">Id</label>
    <input type="text" id="id" name="EmployeeId" readonly value="<%=employee.getEmpId()%>"> <br>

    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName" value="<%=employee.getFullName()%>"> <br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="<%=employee.getAddress()%>"> <br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="<%=employee.getEmail()%>"> <br>

    <label for="dob">Date of Birth:</label>
    <input type="date" id="dob" name="dob" value="<%=employee.getDob()%>"> <br>

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" value=" <%=employee.getPhone()%>"> <br>

    <label for="status">Status:</label>
    <select id="status" name="status" >
        <option value="ACTIVE" selected>Active</option>
        <option value="IN_ACTIVE">Inactive</option>
        <option value="TERMINATED">TERMINATED</option>
    </select> <br>
    <button type="submit">Update Employee</button>

</form>


</body>
</html>
