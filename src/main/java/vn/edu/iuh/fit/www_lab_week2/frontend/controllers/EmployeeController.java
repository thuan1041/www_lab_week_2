package vn.edu.iuh.fit.www_lab_week2.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.www_lab_week2.frontend.model.EmployeeModel;
import vn.edu.iuh.fit.www_lab_week2.services.EmployeeServices;

import java.io.IOException;

@WebServlet("/employeeController")
public class EmployeeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeModel employeeModel = new EmployeeModel();
        String action = req.getParameter("action");
        if(action.equals("getAllEmployee")){
            resp.sendRedirect("employee.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
