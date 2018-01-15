package Api.service;

import Api.model.Employee;
import Api.model.Hour;
import Api.model.Statistic;
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




    public void fillStatisticModel(Statistic statistic)
    {
        System.out.println(statistic.getProject());
        System.out.println(statistic.getWerknemer());
        System.out.println(statistic.getSubproject());
        System.out.println(statistic.geteDate());
        System.out.println(statistic.getbDate());

        if(statistic.getProject() != null && statistic.getSubproject() == null && statistic.getWerknemer() == null)
        {
//            make statement in dao that gets all the ours from the statistic.getprojectn

        }

        if (statistic.getProject() != null && statistic.getSubproject() != null && statistic.getWerknemer() == null)
        {
//            make statement in doa that gets all the ours from the statistic.getsubproject
        }

        if (statistic.getProject() != null && statistic.getSubproject() != null && statistic.getWerknemer() != null)
        {
//            make statement in doa that gets all the ours from the statistic.getsubproject from a specific employee
        }

        if (statistic.getProject() != null && statistic.getSubproject() == null && statistic.getWerknemer() != null)
        {
//            make statement in doa that gets all the ours from the statistic.getproject from a specific employee
        }

        if (statistic.getProject() == null && statistic.getSubproject() == null && statistic.getWerknemer() != null)
        {
//            make statement in doa that gets all the ours from the statistic.employee
            String[] voorachternaam = statistic.getWerknemer().split("\\s+");
            Employee employee = new Employee(voorachternaam[0], voorachternaam[1]);
            int employeeNumber = emDao.selectEmployee(employee).getEmployee_Employee_number();
            ArrayList<Hour> hourstotall = hourDao.getEmployeeHourstotall(employeeNumber);
//             verzin iets waardoor time zich bij elkaar opteld en zet dit in een model
            int totaalHour = 0;
            int totaalMinute = 0;
            for(Hour h: hourstotall)
            {
                Time t = h.getHour_amount_of_hours();
                totaalHour += t.getHours();
                totaalMinute += t.getMinutes();

            }
            System.out.println(totaalHour+" "+totaalMinute);





        }
        if (statistic.getProject() == null && statistic.getSubproject() != null && statistic.getWerknemer() != null)
        {
//            make statement in doa that gets all the ours from the statistic.subproject from a specific employee
        }






    }
    boolean BdateCheck()
    {
//        check if there is a begin and end date
        return false;
    }
    boolean EdateCheck()
    {
//        check if there is a begin and end date
        return false;
    }

}


