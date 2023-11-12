package vn.edu.iuh.fit.www_lab_week2.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.www_lab_week2.frontend.model.EmployeeModel;
import vn.edu.iuh.fit.www_lab_week2.services.EmployeeServices;

import java.io.IOException;
import java.text.ParseException;

@WebServlet("/employeeController")
public class EmployeeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeModel employeeModel = new EmployeeModel();
        String action = req.getParameter("action");
        if(action.equals("getAllEmployee")){
            resp.sendRedirect("employee.jsp");
        }
        if (action.equals("viewEmployee")){
            employeeModel.employeeDetail(req,resp);
//            resp.sendRedirect("employee_Detail.jsp");
        }
        if(action.equals("updateEmployee")){
            employeeModel.getEmployeeUpdate(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeModel employeeModel = new EmployeeModel();
        String action = req.getParameter("action");
        if(action.equals("insertEmployee")){
            employeeModel.insertEmployee(req,resp);
            resp.sendRedirect("employee.jsp");
        }
        if(action.equals("updateEmployeePost")){
//            String idParam = req.getParameter("id");
//            try {
//                Long empId = Long.parseLong(idParam);
//                employeeModel.updateEmployee(req,resp);
////                resp.sendRedirect("employee_Update.jsp");
//            } catch (ParseException e) {
//                System.out.println("ParseException:" + e.getMessage());
//                throw new RuntimeException();
//            }
            try {
                employeeModel.updateEmployee(req,resp);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
