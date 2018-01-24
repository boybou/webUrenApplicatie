package Api.Test;

import Api.persistence.DatabaseConnector;
import Api.persistence.EmployeeDao;
import Api.persistence.LoginDao;
import Api.resource.UserResource;
import Api.service.EmployeeService;
import Api.service.UserService;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestDatabase {

    @Test
    public void testLogin() {
        DatabaseConnector db = new DatabaseConnector();
        UserResource test = new UserResource(new UserService(new LoginDao()),new EmployeeService(new EmployeeDao()));
        assertEquals("HxJeis89!.",test.getLoginData("admin").getPassword());


    }
}
