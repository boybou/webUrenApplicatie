package Api.service;

import Api.model.Employee;
import Api.model.LoginData;
import Api.persistence.HourDao;
import Api.persistence.LoginDao;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserService extends BaseService<LoginData>
{
    private final LoginDao dao;

    @Inject
    public UserService(LoginDao dao){
        this.dao = dao;
    }
    public void setPassword(LoginData loginData){
        this.dao.setPassword(loginData);
    }
    public void insertLogindata(LoginData loginData) {
        dao.insertInlogData(loginData);
    }

    public int getEmployeeNumberByEmail(String employeeEmail){
        return dao.getEmployeeNumberByEmail(employeeEmail);
    }

    public LoginData getLoginData(String email) {
        return this.dao.getLoginData(email);
    }

    public void updateLoginData(LoginData loginData) {
        this.dao.setPassword(loginData);
    }
}
