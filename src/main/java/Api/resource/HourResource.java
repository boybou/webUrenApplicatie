package Api.resource;

import Api.View;
import Api.model.CompleteHour;
import Api.model.Hour;
import Api.model.IncompleteHour;
import Api.model.LoginData;
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
@Path("/hour")
@Produces(MediaType.APPLICATION_JSON)
public class HourResource {

    private final HourService hourService;
    private final ClientService clientService;
    private final ProjectService projectService;
    private final SubProjectService subProjectService;
    private final EmployeeService employeeService;

    @Inject
    public HourResource(EmployeeService employeeService,HourService hourService, ClientService clientService, ProjectService projectService, SubProjectService subProjectService){
        this.hourService = hourService;
        this.clientService = clientService;
        this.projectService = projectService;
        this.subProjectService = subProjectService;
        this.employeeService = employeeService;
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    @RolesAllowed({"administrator"})
    public ArrayList<Hour> retrieveEmployeeSpecificHours(@PathParam("id") int id){
        return hourService.getHours(id);
    }

    @GET
    @Path("/me/{date}")
    @JsonView(View.Public.class)
    @RolesAllowed({"Employee","administrator"})
    public ArrayList<CompleteHour> getHoursByDate(@PathParam("date") String date,@Auth LoginData loginData){
        return hoursToCompleteHour(hourService.getCompleteHoursByDate(date,loginData.getEmployeeNumber()));
    }

    @GET
    @Path("/me")
    @JsonView(View.Public.class)
    @RolesAllowed({"Employee","administrator"})
    public ArrayList<Hour> retrievePersonalHours(@Auth LoginData loginData){
        return hourService.getHours(loginData.getEmployeeNumber());
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"administrator","Employee"})
    public void insertHour(@Valid IncompleteHour incompleteHour){
        if(clientService.checkIfClientExitis(incompleteHour.getHour_client()) == false){

            clientService.insertClient(incompleteHour.getHour_client());
        }
        if(projectService.checkProjectExist(incompleteHour.getHour_project_name()) == false){

            projectService.createProject(incompleteHour.getHour_project_name(),incompleteHour.getHour_client());
        }
        if (!subProjectService.checkIfSubprojectExists(incompleteHour.getHour_subproject_name())) {

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

    @PUT
    @Path("/approveHour/{id}")
    @RolesAllowed({"administrator"})
    public void approveHour(@PathParam("id") int id){
        hourService.approveHour(id);
    }

    @PUT
    @Path("/disapproveHour/{id}")
    @RolesAllowed({"administrator"})
    public void disapproveHour(@PathParam("id") int id){
        hourService.disapproveHour(id);
    }

    public ArrayList<CompleteHour> hoursToCompleteHour(ArrayList<Hour> hourList){
        ArrayList<CompleteHour> completeHoursList = new ArrayList<CompleteHour>();
        for(Hour hour : hourList) {
            String subprojectName;
            String projectName;
            try {
               subprojectName = subProjectService.getSubProjectById(hour.getHour_subproject_number()).getSubProject_Name();
               projectName = projectService.getProjectById(subProjectService.getSubProjectById(hour.getHour_subproject_number()).getSubProject_Project_Number()).getProject_Name();
               completeHoursList.add(new CompleteHour(hour.getHour_approved(), hour.getHour_subproject_number(), hour.getHour_employee_number(), hour.getStartTime(), hour.getEndTime(), hour.getHour_amount_of_hours(), hour.getHour_comments(), hour.getHour_date(), hour.getId(), projectName, subprojectName, employeeService.selectSpecificEmployee(hour.getHour_employee_number()).getEmployee_Firstname(), employeeService.selectSpecificEmployee(hour.getHour_employee_number()).getEmployee_Lastname(), projectService.getProjectById(subProjectService.getSubProjectById(hour.getHour_subproject_number()).getSubProject_Project_Number()).getProject_client_name()));

            }catch (Exception e){
            }

        }
        return completeHoursList;
    }

}

