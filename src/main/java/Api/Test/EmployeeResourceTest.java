package Api.Test;

import Api.model.CompleteUser;
import Api.persistence.DatabaseConnector;
import Api.persistence.EmployeeDao;
import Api.resource.EmployeeResource;
import Api.service.EmployeeService;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EmployeeResourceTest {

    @Test
    public void insertEmployee(){
        DatabaseConnector db = new DatabaseConnector();
        EmployeeResource employeeResource = new EmployeeResource(new EmployeeService(new EmployeeDao()));
        CompleteUser completeUser = new CompleteUser("willem","jan","intern",3,"Employee","Vincent1","Employee@Test.nl");
        employeeResource.insertEmployee(completeUser);
    }

    @Test
    public void retrieveEmployee(){
        DatabaseConnector db = new DatabaseConnector();
        EmployeeResource employeeResource = new EmployeeResource(new EmployeeService(new EmployeeDao()));
        assertEquals(2,employeeResource.retrieveEmployee(2).getEmployee_Employee_number());

    }

}
