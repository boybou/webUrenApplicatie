package Api.resource;

import Api.View;
import Api.model.*;
import Api.service.*;
import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Singleton
@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private final EmployeeService employeeService;

    @Inject
    public EmployeeResource(EmployeeService employeeService){

        this.employeeService = employeeService;
    }

    @POST
    @Path("/insertemployee")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertEmployee(Employee employee){
        System.out.println("in employee login " + employee.getEmployee_Firstname());
        employeeService.insertEmployee(employee);
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Private.class)
    public Employee retreiveEmployee(@PathParam("id") int id){
        return this.employeeService.selectSpecificEmployee(id);
    }



}

