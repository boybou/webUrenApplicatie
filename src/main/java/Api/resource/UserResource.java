package Api.resource;

import Api.View;
import Api.model.LoginData;
import Api.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource
{
    private final UserService userService;

    @Inject
    public UserResource(UserService userService){

        this.userService = userService;
    }


    @POST
    @Path("/insertLoginData")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertLoginData(LoginData loginData){
        System.out.println("In logindata");
        System.out.println("in recoursce login " + loginData.getEmail());
        userService.insertLogindata(loginData);
    }
//    @GET
//    @Path("/me")
//    @JsonView(View.Private.class)
//    @RolesAllowed({"Employee","administrator"})
//    public LoginData authenticate(@Auth LoginData authenticator)
//    {
//        return authenticator;
//    }
}
