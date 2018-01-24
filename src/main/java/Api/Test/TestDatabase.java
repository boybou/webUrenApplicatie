package Api.Test;

import Api.model.Hour;
import Api.persistence.DatabaseConnector;
import Api.persistence.EmployeeDao;
import Api.persistence.HourDao;
import Api.persistence.LoginDao;
import Api.resource.HourResource;
import Api.resource.UserResource;
import Api.service.*;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class TestDatabase {

    @Test
    public void testLogin() {
        DatabaseConnector db = new DatabaseConnector();
        UserResource test = new UserResource(new UserService(new LoginDao()),new EmployeeService(new EmployeeDao()));
        assertEquals("HxJeis89!.",test.getLoginData("admin").getPassword());


    }

    @Test
    public void testAddHour(){
        Time beginTime = Time.valueOf("12;00:00");
        Time endTime = Time.valueOf("12;18:00");
        Time totalTime = Time.valueOf("00:18:00");
        Date date = Date.valueOf("2018-01-18");
        Hour testHour = new Hour("pending", 1, 1000, beginTime, endTime, totalTime,"comment",date, 1);
        HourDao testDao = new HourDao();
        testDao.insertHour(testHour);
        ArrayList<Hour> testList = testDao.getEmployeeHourstotall(1000);

        assertEquals("comment", testList.get(0).getHour_comments());
    }

}
