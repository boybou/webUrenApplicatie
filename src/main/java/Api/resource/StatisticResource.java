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
            StatisticService statisticService){
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
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"administrator"})
    public void makeStatistic( Statistic inputStatistic)
    {
        statisticreset();
        statistic = inputStatistic;
        statisticService.fillStatisticModel(statistic, statisticReturn);
        System.out.println(statisticReturn.getProject());
    }

    void statisticreset()
    {
        statisticReturn.setProject(null);
        statisticReturn.setSubproject(null);
        statisticReturn.setEmployee(null);
//        statistic.setSubproject(null);
//        statistic.setProject(null);
//        statistic.setWerknemer(null);

    }

}

