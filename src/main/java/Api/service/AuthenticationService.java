package Api.service;

import Api.model.Employee;
import Api.model.Login;
import Api.model.User;
import Api.persistence.EmployeeDao;
import Api.persistence.LoginDao;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.Authorizer;
import io.dropwizard.auth.basic.BasicCredentials;

import javax.inject.Inject;
import java.util.Optional;

public class AuthenticationService implements Authenticator<BasicCredentials, User>, Authorizer<User> {
    private LoginDao loginDao;
    private EmployeeDao employeeDao;


    @Inject
    public AuthenticationService(LoginDao loginDao, EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
        this.loginDao = loginDao;

    }

    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException
    {

        int userId = loginDao.getEmployeeNumberByEmail(credentials.getUsername());
        System.out.println(userId);
        Login login;
        login = loginDao.getLoginData(credentials.getUsername());
        System.out.println(login.getEmail());
        System.out.println(login.getPassword());
        if (login != null && login.getPassword().equals(credentials.getPassword()))
        {
            Employee emp = employeeDao.selectSpecificEmployee(userId);
            User user = new User();
            user.setFullName(emp.getEmployee_Firstname());
            user.setEmailAddress(login.getEmail());
            user.setPassword(login.getPassword());
            user.setRoles(new String[] { "GUEST", "ADMIN" });
            return Optional.of(user);
        }

        return Optional.empty();

    }

    @Override
    public boolean authorize(User user, String roleName)
    {
        return user.hasRole(roleName);
    }

}
