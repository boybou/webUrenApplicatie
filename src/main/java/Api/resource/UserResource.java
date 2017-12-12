package Api.resource;

import Api.View;
import Api.model.User;
import Api.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Singleton
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource
{
//    private final UserService service;
//
//    @Inject
//    public UserResource(UserService service)
//    {
//        this.service = service;
//    }
//
//    @GET
//    @JsonView(View.Public.class)
//    @RolesAllowed("GUEST")
//    public Collection<User> retrieveAll()
//    {
//        return service.getAll();
//    }
//
//    @GET
//    @Path("/{id}")
//    @JsonView(View.Public.class)
//    @RolesAllowed("GUEST")
//    public User retrieve(@PathParam("id") int id)
//    {
//        return service.get(id);
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @JsonView(View.Protected.class)
//    public void create(@Valid User user)
//    {
//        service.add(user);
//    }
//
//    @PUT
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @JsonView(View.Protected.class)
//    @RolesAllowed("GUEST")
//    public void update(@PathParam("id") int id, @Auth User authenticator, User user)
//    {
//        service.update(authenticator, id, user);
//    }
//
//    @DELETE
//    @Path("/{id}")
//    @RolesAllowed("ADMIN")
//    public void delete(@PathParam("id") int id)
//    {
//        service.delete(id);
//    }

    @GET
    @Path("/me")
    @JsonView(View.Private.class)
    public User authenticate(@Auth User authenticator)
    {
        System.out.println("TESTETE");
        return authenticator;
    }
}
