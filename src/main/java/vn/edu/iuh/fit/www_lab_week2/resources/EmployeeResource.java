package vn.edu.iuh.fit.www_lab_week2.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jdk.javadoc.doclet.Reporter;
import vn.edu.iuh.fit.www_lab_week2.models.Employee;
import vn.edu.iuh.fit.www_lab_week2.services.EmployeeServices;

import java.util.List;

@Path("/employees")
public class EmployeeResource {
    @Inject
    private EmployeeServices employeeServices;

    @GET
    @Produces("application/json")
    public Response findAll(){
        List<Employee> employeeList =employeeServices.findAllEmployee();
        return Response.ok(employeeList).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response findById(@PathParam("id") long empId){
        Employee empOtp = employeeServices.findById(empId);
        if (empOtp.getEmpId()!=null){
            return Response.ok(empOtp).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
