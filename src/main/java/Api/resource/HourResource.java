package Api.resource;

import Api.View;
import Api.model.Hour;
import Api.service.HourService;
import com.fasterxml.jackson.annotation.JsonView;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
}

