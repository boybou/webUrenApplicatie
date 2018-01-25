package Api.resource;

import Api.View;
import Api.model.*;
import Api.service.*;
import com.fasterxml.jackson.annotation.JsonView;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/statistics")
@Produces(MediaType.APPLICATION_JSON)
public class StatisticResource {


    private final StatisticService statisticService;
    private Statistic statistic;
    private StatisticReturn statisticReturn = new StatisticReturn();


    @Inject
    public StatisticResource(
            StatisticService statisticService){
        this.statisticService = statisticService;
    }



    @GET
    @Path("/{employee},{project},{subproject}")
    @RolesAllowed({"administrator"})
    public StatisticReturn makeStatistic(@PathParam("employee")String employee,@PathParam("project")String project,@PathParam("subproject")String subproject)
    {
        statisticreset();
        statistic = new Statistic();
        if(!employee.equals("undefined")){
            statistic.setWerknemer(employee);
        }
        if(!project.equals("undefined")){
            statistic.setProject(project);
        }
        if(!subproject.equals("undefined")){
            statistic.setSubproject(subproject);
        }

        statisticService.fillStatisticModel(statistic, statisticReturn);

        return statisticReturn;
    }


    void statisticreset()
    {

        statisticReturn = new StatisticReturn();

    }

}

