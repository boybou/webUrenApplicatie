package Api.service;

import Api.model.*;
import Api.persistence.EmployeeDao;
import Api.persistence.HourDao;
import Api.persistence.ProjectDao;
import Api.persistence.StatisticDao;
import org.joda.time.Hours;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;

public class StatisticService {

    StatisticDao stDao = new StatisticDao();
    EmployeeDao emDao = new EmployeeDao();
    HourDao hourDao = new HourDao();
    ArrayList<Hour> hourstotall;
    ProjectDao pjDao = new ProjectDao();
    StatisticReturn statisticReturn;



    public void fillStatisticModel(Statistic statistic, StatisticReturn statisticReturn)
    {
        this.statisticReturn = statisticReturn;


        if(statistic.getProject() != null && statistic.getSubproject() == null && statistic.getWerknemer() == null)
        {
            int pjNumber = pjDao.getSpecificProject(statistic.getProject()).getProject_Number();

            Project project = new Project(pjNumber);

            hourstotall = hourDao.getProjectHours(project);
            statisticReturn.setProject(statistic.getProject());
            fillHours();
        }

        if (statistic.getProject() != null && statistic.getSubproject() != null && statistic.getWerknemer() == null)
        {
//            make statement in doa that gets all the ours from the statistic.getsubproject
        }


        if (statistic.getProject() != null && statistic.getSubproject() == null && statistic.getWerknemer() != null)
        {
//            make statement in doa that gets all the ours from the statistic.getproject from a specific employee
        }

        if (statistic.getProject() == null && statistic.getSubproject() == null && statistic.getWerknemer() != null)
        {
//            make statement in doa that gets all the ours from the statistic.employee
            int employeeNumber = getEmployeeNumber(statistic);
            hourstotall = hourDao.getEmployeeHourstotall(employeeNumber);

            statisticReturn.setEmployee(statistic.getWerknemer());

            fillHours();


        }
        if (statistic.getProject() == null && statistic.getSubproject() != null && statistic.getWerknemer() != null)
        {
            int employeeNumber = getEmployeeNumber(statistic);


        }

    }

    public int getEmployeeNumber(Statistic statistic)
    {
        String[] voorachternaam = statistic.getWerknemer().split("\\s+");
        Employee employee = new Employee(voorachternaam[0], voorachternaam[1]);
        return emDao.selectEmployee(employee).getEmployee_Employee_number();
    }

    public void fillHours()
    {

        int totaalHour = 0;
        int totaalMinute = 0;
        for(Hour h: hourstotall)
        {
            Time t = h.getHour_amount_of_hours();
            totaalHour += t.getHours();
            totaalMinute += t.getMinutes();

        }
        statisticReturn.setHours(totaalHour);
        statisticReturn.setMinutes(totaalMinute);
    }


}


