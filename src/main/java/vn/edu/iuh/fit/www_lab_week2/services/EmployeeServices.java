package vn.edu.iuh.fit.www_lab_week2.services;

import vn.edu.iuh.fit.www_lab_week2.models.Employee;
import vn.edu.iuh.fit.www_lab_week2.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeServices {
    private EmployeeRepository employeeRepository;
    public EmployeeServices(){
        employeeRepository = new EmployeeRepository();
    }

    public void insertEmployee (Employee e){
        employeeRepository.insertEmployee(e);
    }
    public void updateEmployee(Employee e){
        employeeRepository.updateEmployee(e);
    }
    public boolean deteleEmployee(long id){
        Employee e = employeeRepository.findById(id);
        return employeeRepository.deteleEmployee(e);

    }
    public Employee findById(long id){
        return employeeRepository.findById(id);
    }
    public List<Employee> findAllEmployee(){
        return employeeRepository.findAllEmployee();
    }
}
