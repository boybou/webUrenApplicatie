package Api.persistence;

import Api.model.DatabaseInfo;
import Api.model.Employee;

import javax.inject.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Vincent, Wytze, Boy.
 * This DAO connects to the Employee table.
 */
@Singleton
public class EmployeeDao implements Dao {

    private PreparedStatement insertEmployee;
    private PreparedStatement selectEmployee;
    private PreparedStatement selectSpecificEmployee;
    private PreparedStatement selectAllEmployees;

    public EmployeeDao() {
        preparedStatements();
    }

    public void preparedStatements() {
        try {
            //test preparedstatment for inserting a person into our test database
            insertEmployee = ConnectionHolder.getConnection().prepareStatement("insert into " + DatabaseInfo.employeeTableName + " (" + DatabaseInfo.EmployeeColumnNames.firstName + ", " + DatabaseInfo.EmployeeColumnNames.lastName + ", " + DatabaseInfo.EmployeeColumnNames.typeName + ", " + DatabaseInfo.EmployeeColumnNames.roleName + ", " + DatabaseInfo.EmployeeColumnNames.active + ") values (?, ?, ?, ?, ?)");
            selectEmployee = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM " + DatabaseInfo.employeeTableName + " WHERE " + DatabaseInfo.EmployeeColumnNames.firstName + " = ? AND " + DatabaseInfo.EmployeeColumnNames.lastName + " = ?");
            selectSpecificEmployee = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM " + DatabaseInfo.employeeTableName + " WHERE " + DatabaseInfo.EmployeeColumnNames.employeeNumber + " = ?");
            selectAllEmployees = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM " + DatabaseInfo.employeeTableName + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee selectEmployee(Employee employee) {
        try {
            ResultSet rs;
            selectEmployee.setString(1, employee.getEmployee_Firstname());
            selectEmployee.setString(2, employee.getEmployee_Lastname());
            rs = selectEmployee.executeQuery();
            rs.next();
            return new Employee(rs.getString(DatabaseInfo.EmployeeColumnNames.firstName), rs.getString(DatabaseInfo.EmployeeColumnNames.lastName), rs.getString(DatabaseInfo.EmployeeColumnNames.typeName), rs.getInt(DatabaseInfo.EmployeeColumnNames.employeeNumber), rs.getString(DatabaseInfo.EmployeeColumnNames.roleName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public String insertEmployee(Employee employee) {

        try {

            insertEmployee.setString(1, employee.getEmployee_Firstname());
            insertEmployee.setString(2, employee.getEmployee_Lastname());
            insertEmployee.setString(3, employee.getEmployee_Type_Name());
            insertEmployee.setString(4, employee.getEmployee_Role_Name());
            insertEmployee.setBoolean(5, employee.getEmployee_Active());

            insertEmployee.executeUpdate();

            return "Inserted succesfully";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Inserted failed";

    }

    public Employee selectSpecificEmployee(int id) {
        try {
            ResultSet rs;
            selectSpecificEmployee.setInt(1, id);
            rs = selectSpecificEmployee.executeQuery();
            //rs.next();

            System.out.println(rs.next());
            Employee employee = new Employee(rs.getString(DatabaseInfo.EmployeeColumnNames.firstName), rs.getString(DatabaseInfo.EmployeeColumnNames.lastName), rs.getString(DatabaseInfo.EmployeeColumnNames.typeName), rs.getInt(DatabaseInfo.EmployeeColumnNames.employeeNumber), rs.getString(DatabaseInfo.EmployeeColumnNames.roleName));
            System.out.println(employee.getEmployee_Firstname());
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public ArrayList selectAllEmployees() {

        ArrayList<Employee> employeeArray = new ArrayList<Employee>();
        try {
            ResultSet rs = selectAllEmployees.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(rs.getString(DatabaseInfo.EmployeeColumnNames.firstName), rs.getString(DatabaseInfo.EmployeeColumnNames.lastName), rs.getString(DatabaseInfo.EmployeeColumnNames.typeName), rs.getInt(DatabaseInfo.EmployeeColumnNames.employeeNumber), rs.getString(DatabaseInfo.EmployeeColumnNames.roleName));
                employeeArray.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return employeeArray;
    }
}