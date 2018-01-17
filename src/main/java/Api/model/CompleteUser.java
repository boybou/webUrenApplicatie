package Api.model;

/**
 * Created by Wytze.
 * This model represents the employee
 */
;
public class CompleteUser {
    String employee_Firstname;
    String employee_Lastname;
    String employee_Type_Name;
    int employee_Employee_Number;
    String employee_Role_Name;
    Boolean employee_Active;
    String password;
    String email;


    public CompleteUser(){

    }

    public CompleteUser(String employee_Firstname, String employee_Lastname, String employee_Type_Name, int employee_Employee_Number, String employee_Role_Name, String password, String email) {
        this.employee_Firstname = employee_Firstname;
        this.employee_Lastname = employee_Lastname;
        this.employee_Type_Name = employee_Type_Name;
        this.employee_Employee_Number = employee_Employee_Number;
        this.employee_Role_Name = employee_Role_Name;
        this.employee_Active = true;
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployee_Firstname() {
        return employee_Firstname;
    }

    public String getEmployee_Lastname() {
        return employee_Lastname;
    }

    public String getEmployee_Type_Name() {
        return employee_Type_Name;
    }

    public int getEmployee_Employee_number() {
        return employee_Employee_Number;
    }

    public String getEmployee_Role_Name() {
        return employee_Role_Name;
    }

    public Boolean getEmployee_Active() {
        return employee_Active;
    }
}
