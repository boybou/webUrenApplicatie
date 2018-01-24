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
@Path("/user")
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
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"administrator"})
    public void insertLoginData(CompleteUser completeUser){

        System.out.println(completeUser.getEmployee_Firstname());
        System.out.println(completeUser.getPassword());
        Employee employee = new Employee(completeUser.getEmployee_Firstname(),completeUser.getEmployee_Lastname(),completeUser.getEmployee_Type_Name(),completeUser.getEmployee_Role_Name());
        employeeService.insertEmployee(employee);
        Employee employeeWithId = employeeService.selectEmployee(employee);
        System.out.println("ID = " + employeeWithId.getEmployee_Employee_number());
        userService.insertLogindata(new LoginData(completeUser.getPassword(),completeUser.getEmail(),employeeWithId.getEmployee_Employee_number(),completeUser.getEmployee_Role_Name()));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"administrator","Employee"})
    public void updateLoginData(LoginData loginData){
        System.out.println("IN login data resrouce" + loginData.getEmail() + loginData.getPassword());
        this.userService.updateLoginData(loginData);
    }
    @GET
    @Path("/{email}")
    @RolesAllowed({"administrator"})
    public LoginData getLoginData(@PathParam("email") String email){
        return userService.getLoginData(email);
    }

    @GET
    @Path("/me")
    @JsonView(View.Private.class)
    @RolesAllowed({"Employee", "administrator"})
    public LoginData authenticate(@Auth LoginData authenticator) {
        return authenticator;
    }

}
