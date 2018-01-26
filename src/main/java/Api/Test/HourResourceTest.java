package Api.Test;

import Api.model.IncompleteHour;
import Api.model.LoginData;
import Api.persistence.*;
import Api.resource.HourResource;
import Api.service.*;
import org.junit.Test;

import java.sql.Date;

import static junit.framework.TestCase.assertEquals;

public class HourResourceTest {

    @Test
    public void retrieveEmployeeSpecificHours(){
        DatabaseConnector db = new DatabaseConnector();
        HourResource hourResource = new HourResource(new EmployeeService(new EmployeeDao()),new HourService(new HourDao()),new ClientService(new ClientDao()),new ProjectService(new ProjectDao()),new SubProjectService(new SubProjectDao()));

        assertEquals(2,hourResource.retrieveEmployeeSpecificHours(2).get(0).getHour_employee_number());
    }

    @Test
    public void getHoursByDate(){
        LoginData loginData = new LoginData("TESTPW","TEST@TEST",2,"administrator");
        DatabaseConnector db = new DatabaseConnector();
        HourResource hourResource = new HourResource(new EmployeeService(new EmployeeDao()),new HourService(new HourDao()),new ClientService(new ClientDao()),new ProjectService(new ProjectDao()),new SubProjectService(new SubProjectDao()));
        assertEquals("2018-01-01",hourResource.getHoursByDate("2018-01-01",loginData).get(0).getHour_date().toString());
    }

    @Test
    public void retrievePersonalHours(){
        LoginData loginData = new LoginData("TESTPW","TEST@TEST",2,"administrator");
        DatabaseConnector db = new DatabaseConnector();
        HourResource hourResource = new HourResource(new EmployeeService(new EmployeeDao()),new HourService(new HourDao()),new ClientService(new ClientDao()),new ProjectService(new ProjectDao()),new SubProjectService(new SubProjectDao()));
        assertEquals(2,hourResource.retrievePersonalHours(loginData).get(0).getHour_employee_number());
    }

    @Test
    public void insertHour(){
        DatabaseConnector db = new DatabaseConnector();
        HourResource hourResource = new HourResource(new EmployeeService(new EmployeeDao()),new HourService(new HourDao()),new ClientService(new ClientDao()),new ProjectService(new ProjectDao()),new SubProjectService(new SubProjectDao()));
        IncompleteHour incompleteHour = new IncompleteHour("PROJECTKLANT","TESTPROJECT","TESTSUBPROJECT",2,"10:10","20:20","TESTCOMMENT","2018-01-24","yyyy-MM-dd");
        hourResource.insertHour(incompleteHour);
    }

    @Test
    public void getPendingHours(){
        DatabaseConnector db = new DatabaseConnector();
        HourResource hourResource = new HourResource(new EmployeeService(new EmployeeDao()),new HourService(new HourDao()),new ClientService(new ClientDao()),new ProjectService(new ProjectDao()),new SubProjectService(new SubProjectDao()));
        assertEquals("pending",hourResource.getPendingHours().get(0).getHour_approved());
    }

    @Test
    public void approveHour(){
        DatabaseConnector db = new DatabaseConnector();
        HourResource hourResource = new HourResource(new EmployeeService(new EmployeeDao()),new HourService(new HourDao()),new ClientService(new ClientDao()),new ProjectService(new ProjectDao()),new SubProjectService(new SubProjectDao()));
        hourResource.approveHour(1);
    }

    @Test
    public void disapproveHour(){
        DatabaseConnector db = new DatabaseConnector();
        HourResource hourResource = new HourResource(new EmployeeService(new EmployeeDao()),new HourService(new HourDao()),new ClientService(new ClientDao()),new ProjectService(new ProjectDao()),new SubProjectService(new SubProjectDao()));
        hourResource.disapproveHour(2);

    }
}
