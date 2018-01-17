package Api.resource;

import Api.View;
import Api.model.CompleteUser;
import Api.model.Employee;
import Api.model.LoginData;
import Api.service.EmployeeService;
import Api.service.HourService;
import Api.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Singleton
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserService userService;
    private final EmployeeService employeeService;

    @Inject
    public UserResource(UserService userService,EmployeeService employeeService){
        this.employeeService = employeeService;
        this.userService = userService;
    }


    @POST
    @Path("/insertlogindata")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertLoginData(CompleteUser completeUser){

        System.out.println(completeUser.getEmployee_Firstname());
        System.out.println(completeUser.getPassword());
        Employee employee = new Employee(completeUser.getEmployee_Firstname(),completeUser.getEmployee_Lastname(),completeUser.getEmployee_Type_Name(),completeUser.getEmployee_Role_Name());
        employeeService.insertEmployee(employee);
        Employee employeeWithId = employeeService.selectEmployee(employee);
        System.out.println("ID = " + employeeWithId.getEmployee_Employee_number());
        userService.insertLogindata(new LoginData(completeUser.getEmail(),completeUser.getPassword(),employeeWithId.getEmployee_Employee_number(),completeUser.getEmployee_Role_Name()));
    }

    @GET
    @Path("/me")
    @JsonView(View.Private.class)
    @RolesAllowed({"Employee", "administrator"})
    public LoginData authenticate(@Auth LoginData authenticator) {
        return authenticator;
    }

}
