package Api.service;

import Api.model.Employee;
import Api.model.Hour;
import Api.model.IncompleteHour;
import Api.model.LoginData;
import Api.persistence.EmployeeDao;

import javax.inject.Inject;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Singleton
public class EmployeeService extends BaseService<Employee>{

    private final EmployeeDao dao;

    @Inject
    public EmployeeService(EmployeeDao dao){
        this.dao = dao;
    }

    public Employee selectSpecificEmployee(int employeeId){
        return dao.selectSpecificEmployee(employeeId);
    }
}