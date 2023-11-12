package vn.edu.iuh.fit.www_lab_week2.frontend.model;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.www_lab_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week2.models.Employee;
import vn.edu.iuh.fit.www_lab_week2.services.EmployeeServices;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class EmployeeModel {
    public void insertEmployee(HttpServletRequest request, HttpServletResponse response){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        EmployeeServices employeeServices = new EmployeeServices();
        String name = request.getParameter("fullName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        Date dob = null;
        if(!request.getParameter("dob").isEmpty()){
            try{
                dob = dateFormat.parse(request.getParameter("dob"));
            } catch (Exception exception){
                throw new RuntimeException();
            }
        }
        String phone = request.getParameter("phone");
        String status = request.getParameter("status");

        Employee e = new Employee(address,dob,email,phone,address,EmployeeStatus.valueOf(status));
        System.out.println("---------------------------------------------");
        System.out.println(e);
        System.out.println("---------------------------------------------");
        employeeServices.insertEmployee(e);

    }
    public List<Employee> findAllEmployee(){
        EmployeeServices employeeServices = new EmployeeServices();
        return employeeServices.findAllEmployee();
    }

    public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        EmployeeServices employeeServices = new EmployeeServices();
        System.out.println("-------------------------");
        System.out.println(request.getParameter("EmployeeId"));
        System.out.println("-------------------------");
        Long idFind = Long.parseLong(request.getParameter("EmployeeId"));
        Employee e =  employeeServices.findById(idFind);


        String fullName = request.getParameter("fullName");
        String dobParam = request.getParameter("dob");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = dateFormat.parse(dobParam);
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String status = request.getParameter("status");

        e.setFullName(fullName);
        e.setDob(dob);
        e.setEmail(email);
        e.setPhone(phone);
        e.setAddress(address);
        e.setStatus(EmployeeStatus.valueOf(status));
        employeeServices.updateEmployee(e);
        System.out.println("============================");
        System.out.println(e);
        System.out.println("============================");
        response.sendRedirect("employee.jsp");
    }
    public void employeeDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeServices employeeServices = new EmployeeServices();
        String url = "";
        try{
            Long id = Long.parseLong(request.getParameter("id"));
            Employee employee = employeeServices.findById(id);
            request.setAttribute("employee", employee);
//            response.sendRedirect("employee_Detail.jsp");
            url = "/employee_Detail.jsp";
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public void getEmployeeUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeServices employeeServices = new EmployeeServices();
        String url ="";
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            Employee employee = employeeServices.findById(id);
            request.setAttribute("employee", employee);
            url = "/employee_Update.jsp";
        } catch ( Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request,response);
    }
}
