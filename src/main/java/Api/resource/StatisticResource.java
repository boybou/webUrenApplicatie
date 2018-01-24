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

//    @GET
//    @JsonView(View.Public.class)
//    @RolesAllowed({"administrator"})
//    public StatisticReturn retrieveStatistics(){
//        return statisticReturn;
//    }


    @GET
    @Path("/{employee},{project},{subproject}")
    @RolesAllowed({"administrator"})
    public StatisticReturn makeStatistic(@PathParam("employee")String employee,@PathParam("project")String project,@PathParam("subproject")String subproject)
    {
        System.out.println("_____________________________\n"+employee+project+subproject+"_________________________________\n");
        statisticreset();
        statistic = new Statistic();
        if(!employee.equals("undefined")){
            statistic.setWerknemer(employee);
            System.out.println("in de if");
            System.out.println(statistic.getWerknemer());
        }
        if(!project.equals("undefined")){
            statistic.setProject(project);
        }
        if(!subproject.equals("undefined")){
            statistic.setSubproject(subproject);
        }

        statisticService.fillStatisticModel(statistic, statisticReturn);
        System.out.println(statisticReturn.getProject());
        return statisticReturn;
    }
//    @GET
//    @Path("/{employee}{project}{subproject}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @RolesAllowed({"administrator"})
//    public StatisticReturn makeStatistic(Statistic inputStatistic)
//    {
//        statisticreset();
//        statistic = new
//                statisticService.fillStatisticModel(statistic, statisticReturn);
//        System.out.println(statisticReturn.getProject());
//        statistic = new Statistic();
//    }

    void statisticreset()
    {

        statisticReturn = new StatisticReturn();

    }

}

