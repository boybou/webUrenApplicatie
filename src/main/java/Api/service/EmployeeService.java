package Api.service;

import Api.model.Employee;
import Api.persistence.EmployeeDao;

import javax.inject.Inject;

public class EmployeeService extends BaseService<Employee> {

    private final EmployeeDao dao;

    @Inject
    public EmployeeService(EmployeeDao dao){
        this.dao = dao;
    }

    public Employee selectSpecificEmployee(int employeeId){
        return dao.selectSpecificEmployee(employeeId);
    }
}
