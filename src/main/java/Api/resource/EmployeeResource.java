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

    @GET
    @Path("/me")
    @JsonView(View.Public.class)
    @RolesAllowed({"administrator","Employee"})
    public Employee getCurrentEmployee(@Auth LoginData loginData){
        return employeeService.getEmployee(loginData.getEmployeeNumber());
    }


}

