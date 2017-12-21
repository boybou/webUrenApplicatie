package Api.service;

import Api.model.Employee;
import Api.model.Hour;
import Api.model.IncompleteHour;
import Api.model.LoginData;
import Api.persistence.EmployeeDao;
import Api.persistence.HourDao;
import io.dropwizard.auth.Auth;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Singleton
public class EmployeeService extends BaseService<Employee>{

    private final EmployeeDao dao;

    @Inject
    public EmployeeService(EmployeeDao dao){
        this.dao = dao;
    }

    public Employee getEmployee(int id){
        return dao.selectSpecificEmployee(id);
    }
}
