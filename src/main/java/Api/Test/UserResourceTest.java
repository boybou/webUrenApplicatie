package Api.Test;

import Api.model.CompleteUser;
import Api.model.LoginData;
import Api.persistence.DatabaseConnector;
import Api.persistence.EmployeeDao;
import Api.persistence.LoginDao;
import Api.resource.UserResource;
import Api.service.EmployeeService;
import Api.service.UserService;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class UserResourceTest {

    @Test
    public void insertLoginData(){
        DatabaseConnector db = new DatabaseConnector();
        UserResource userResource = new UserResource(new UserService(new LoginDao()),new EmployeeService(new EmployeeDao()));
        CompleteUser completeUser = new CompleteUser("henk","jan","intern",4,"Employee","Vincent1","Employee@Test2.nl");
        userResource.insertLoginData(completeUser);

    }

    @Test
    public void updateLoginData(){
        DatabaseConnector db = new DatabaseConnector();
        UserResource userResource = new UserResource(new UserService(new LoginDao()),new EmployeeService(new EmployeeDao()));
        LoginData loginData = new LoginData("TESTPW2","TEST@TEST",2,"administrator");
        userResource.updateLoginData(loginData);
    }

    @Test
    public void getLoginData(){
        DatabaseConnector db = new DatabaseConnector();
        UserResource userResource = new UserResource(new UserService(new LoginDao()),new EmployeeService(new EmployeeDao()));
        assertEquals("TEST@TEST",userResource.getLoginData("TEST@TEST").getEmail());

    }

    @Test
    public void authenticate(){
        DatabaseConnector db = new DatabaseConnector();
        UserResource userResource = new UserResource(new UserService(new LoginDao()),new EmployeeService(new EmployeeDao()));
        LoginData loginData = new LoginData("HxJeis89!.","admin",1,"administrator");
        assertEquals("admin",userResource.authenticate(loginData).getEmail());
    }
}
