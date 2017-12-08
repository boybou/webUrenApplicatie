package Api.model;

/**
 * Created by Boy, Wytze.
 * This model represents the logindata that is needed to login to the application
 */
public class LoginData {
    private String password;
    private String email;
    private int employee_number;

    public LoginData(String password, String email, int employee_number)
    {
        this.password = password;
        this.email = email;
        this.employee_number = employee_number;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployee_number() {
        return employee_number;
    }

    public void setEmployee_number(int employee_number) {
        this.employee_number = employee_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
