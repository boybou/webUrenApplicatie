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
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertEmployee(CompleteUser completeUser){

        Employee employee = new Employee(completeUser.getEmployee_Firstname(),completeUser.getEmployee_Lastname(),completeUser.getEmployee_Type_Name(),completeUser.getEmployee_Role_Name());
        employeeService.insertEmployee(employee);
        Employee employeeWithId = employeeService.selectEmployee(employee);
        System.out.println("ID = " + employeeWithId);
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Private.class)
    public Employee retreiveEmployee(@PathParam("id") int id){
        return this.employeeService.selectSpecificEmployee(id);
    }



}

