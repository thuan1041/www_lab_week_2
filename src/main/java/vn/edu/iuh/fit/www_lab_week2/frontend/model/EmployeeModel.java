package vn.edu.iuh.fit.www_lab_week2.frontend.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.www_lab_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week2.models.Employee;
import vn.edu.iuh.fit.www_lab_week2.resources.EmployeeResource;
import vn.edu.iuh.fit.www_lab_week2.services.EmployeeServices;

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

//        String fullName, Date dob, String email, String phone, String address, EmployeeStatus status, List<Order> orderList) {

        Employee e = new Employee(name, dob, email, phone,address, EmployeeStatus.valueOf(status));
        employeeServices.insertEmployee(e);

    }
    public List<Employee> findAllEmployee(){
        EmployeeServices employeeServices = new EmployeeServices();
        return employeeServices.findAllEmployee();
    }

    public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        EmployeeServices employeeServices = new EmployeeServices();
        Long idFind = Long.parseLong(request.getParameter("idFind"));
        Employee e =  employeeServices.findById(idFind);
//        String fullName, Date dob, String email, String phone, String address, EmployeeStatus status, List<Order> orderList) {

        if(!request.getParameter("fullname").isEmpty()){
            e.setFullName(request.getParameter("fullname"));
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dobReq = request.getParameter("dob");
        Date dob = dateFormat.parse(dobReq);
        if(!(dobReq.isEmpty())){
            e.setDob((java.sql.Date) dob);
        }
        if(!request.getParameter("email").isEmpty()){
            e.setFullName(request.getParameter("email"));
        }
        if(!request.getParameter("phone").isEmpty()){
            e.setFullName(request.getParameter("phone"));
        }
        if(!request.getParameter("address").isEmpty()){
            e.setFullName(request.getParameter("address"));
        }
        if(!request.getParameter("status").isEmpty()){
            String status = request.getParameter("status");
            e.setStatus(EmployeeStatus.valueOf(status));
        }
        employeeServices.updateEmployee(e);
    }
}
