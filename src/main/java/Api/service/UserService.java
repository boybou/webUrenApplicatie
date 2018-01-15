package Api.service;

import Api.model.Employee;
import Api.model.LoginData;
import Api.persistence.EmployeeDao;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserService extends BaseService<LoginData>
{
    private EmployeeDao dao;

    @Inject
    public UserService(EmployeeDao dao){
        this.dao = dao;
    }


    public Employee getEmployeeById(int id) {
        return dao.selectSpecificEmployee(id);
    }

}


