package Api.service;

import Api.model.Employee;
import Api.model.LoginData;
import Api.persistence.EmployeeDao;
import Api.persistence.LoginDao;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.Authorizer;
import io.dropwizard.auth.basic.BasicCredentials;

import javax.inject.Inject;
import java.util.Optional;

public class AuthenticationService implements Authenticator<BasicCredentials, LoginData>, Authorizer<LoginData> {
    private LoginDao loginDao;
    private EmployeeDao employeeDao;


    @Inject
    public AuthenticationService(LoginDao loginDao, EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
        this.loginDao = loginDao;

    }

    @Override
    public Optional<LoginData> authenticate(BasicCredentials credentials) throws AuthenticationException
    {

        int userId = loginDao.getEmployeeNumberByEmail(credentials.getUsername());
        System.out.println(userId);
        LoginData login;
        login = loginDao.getLoginData(credentials.getUsername());
        if (login != null && login.getPassword().equals(credentials.getPassword()))
        {
            Employee emp = employeeDao.selectSpecificEmployee(userId);
            LoginData loginData = new LoginData();
            loginData.setEmail(login.getEmail());
            loginData.setPassword(login.getPassword());
            loginData.setEmployeeNumber(loginDao.getEmployeeNumberByEmail(login.getEmail()));
            loginData.setRole("employee");
            return Optional.of(loginData);
        }

        return Optional.empty();

    }

    @Override
    public boolean authorize(LoginData loginData, String roleName)
    {
        return loginData.hasRole(roleName);
    }

}
