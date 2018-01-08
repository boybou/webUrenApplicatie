package Api.resource;

import Api.View;
import Api.model.Hour;
import Api.model.IncompleteHour;
import Api.model.LoginData;
import Api.service.ClientService;
import Api.service.HourService;
import Api.service.ProjectService;
import Api.service.SubProjectService;
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
@Path("/hour")
@Produces(MediaType.APPLICATION_JSON)
public class HourResource {

    private final HourService hourService;
    private final ClientService clientService;
    private final ProjectService projectService;
    private final SubProjectService subProjectService;

    @Inject
    public HourResource(HourService hourService, ClientService clientService, ProjectService projectService, SubProjectService subProjectService){
        this.hourService = hourService;
        this.clientService = clientService;
        this.projectService = projectService;
        this.subProjectService = subProjectService;
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    @RolesAllowed({"administrator"})
    public ArrayList<Hour> retrieveEmployeeSpecificHours(@PathParam("id") int id){
        return hourService.getHours(id);
    }

    @GET
    @Path("/me")
    @JsonView(View.Public.class)
    @RolesAllowed({"Employee","administrator"})
    public ArrayList<Hour> retrievePersonalHours(@Auth LoginData loginData){
        return hourService.getHours(loginData.getEmployeeNumber());
    }

    @POST
    @Path("/inserthour")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertHour(@Valid IncompleteHour incompleteHour){
        if(clientService.checkIfClientExitis(incompleteHour.getHour_client()) == false){
            System.out.println("Creating client because it doesn't exits");
            clientService.insertClient(incompleteHour.getHour_client());
        }
        if(projectService.checkProjectExist(incompleteHour.getHour_project_name()) == false){
            System.out.println("Creating project because it doesn't exits");
            projectService.createProject(incompleteHour.getHour_project_name(),incompleteHour.getHour_client());
        }
        if (subProjectService.checkIfSubprojectExists(incompleteHour.getHour_subproject_name()) == false) {
            System.out.println("Creating subproject because it doesn't exits");
            subProjectService.createSubProject(incompleteHour.getHour_subproject_name(), projectService.getProjectNumber(incompleteHour.getHour_project_name()));
        }

        hourService.insertHour(incompleteHour,subProjectService.getSubProjectNumber(incompleteHour.getHour_subproject_name()));
    }
    @GET
    @Path("/pendinghours")
    @RolesAllowed({"administrator"})
    public ArrayList<Hour> getPendingHours(){
        return hourService.getPendingHours();
    }
    @GET
    @Path("/approveHour{id}")
    @RolesAllowed({"administrator"})
    public void approveHour(@PathParam("id") int id){
        hourService.approveHour(id);
    }
    @GET
    @Path("/disapproveHour{id}")
    @RolesAllowed({"administrator"})
    public void disapproveHour(@PathParam("id") int id){
        hourService.disapproveHour(id);
    }

}

