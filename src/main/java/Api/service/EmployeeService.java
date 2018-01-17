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

    public int insertEmployee(Employee employee) {
        int id = dao.insertEmployee(employee);
        System.out.println("id in service is " + id);
        return id;
    }

    public Employee selectEmployee(Employee employee) {
        return dao.selectEmployee(employee);
    }
}
