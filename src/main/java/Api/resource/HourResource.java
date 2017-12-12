package Api.resource;

import Api.View;
import Api.model.Hour;
import Api.model.IncompleteHour;
import Api.service.HourService;
import com.fasterxml.jackson.annotation.JsonView;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Singleton
@Path("/hour")
@Produces(MediaType.APPLICATION_JSON)
public class HourResource {

    private final HourService service;

    @Inject
    public HourResource(HourService service){
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    @RolesAllowed("GUEST")
    public ArrayList<Hour> retrieve(@PathParam("id") int id){
        return service.get(id);
    }

    @POST
    @Path("/inserthour")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertHour(@Valid IncompleteHour incompleteHour){
        System.out.println("TESTETE");
        System.out.println(incompleteHour.hour_project_name);
    }
}

