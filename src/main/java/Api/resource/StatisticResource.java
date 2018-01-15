package Api.resource;

import Api.View;
import Api.model.*;
import Api.service.*;
import com.fasterxml.jackson.annotation.JsonView;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
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
//            HourService hourService, ClientService clientService, ProjectService projectService, SubProjectService subProjectService,
            StatisticService statisticService){
//        this.hourService = hourService;
//        this.clientService = clientService;
//        this.projectService = projectService;
//        this.subProjectService = subProjectService;
        this.statisticService = statisticService;
    }

    @GET
    @Path("/{getStatistics}")
    @JsonView(View.Public.class)
    @RolesAllowed({"administrator"})
    public StatisticReturn retrieveStatistics(){
        return statisticReturn;
    }


    @POST
    @Path("/sendStatistics")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"administrator"})
    public void makeStatistic( Statistic inputStatistic)
    {
        statistic = inputStatistic;
        statisticService.fillStatisticModel(statistic, statisticReturn);
        System.out.println(statisticReturn.getProject());
    }

}

