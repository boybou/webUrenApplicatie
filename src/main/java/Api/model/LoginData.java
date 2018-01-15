package Api.model;

import Api.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.security.Principal;

/**
 * Created by Boy, Wytze.
 * This model represents the logindata that is needed to login to the application
 */
public class LoginData implements Principal {
    @NotEmpty
    @Length(min = 6)
    @JsonView(View.Protected.class)
    private String password;

    @NotEmpty
    @JsonView(View.Public.class)
    private String email;

    @Length(min = 1)
    @JsonView(View.Public.class)
    private int employeeNumber;

    @JsonView(View.Private.class)
    private String role;

    public LoginData(){

    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getName() {
        return null;
    }

    public boolean hasRole(String roleName){
        return this.role.equals(roleName);
    }


}

//package Api.model;
//
//        import Api.View;
//        import com.fasterxml.jackson.annotation.JsonIgnore;
//        import com.fasterxml.jackson.annotation.JsonView;
//        import org.hibernate.validator.constraints.Email;
//        import org.hibernate.validator.constraints.Length;
//        import org.hibernate.validator.constraints.NotEmpty;
//
//        import java.security.Principal;

//public class LoginData implements Principal
//{
//    @NotEmpty
//    @Length(min = 3, max = 100)
//    @JsonView(View.Public.class)
//    private String fullName;
//
//    @NotEmpty
//    @Email
//    @JsonView(View.Public.class)
//    private String emailAddress;
//
//    @NotEmpty
//    @Length(min = 8)
//    @JsonView(View.Protected.class)
//    private String password;
//
//    @NotEmpty
//    @Length(min = 1)
//    @JsonView(View.Public.class)
//    private int employeeNumber;
//
//    @JsonView(View.Private.class)
//    private String[] roles;
//
//    public String getFullName()
//    {
//        return fullName;
//    }
//
//    public void setFullName(String fullName)
//    {
//        this.fullName = fullName;
//    }
//
//    public String getEmailAddress()
//    {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress)
//    {
//        this.emailAddress = emailAddress;
//    }
//
//    public String getPassword()
//    {
//        return password;
//    }
//
//    public void setPassword(String password)
//    {
//        this.password = password;
//    }
//
//    public int getEmployeeNumber() {
//        return employeeNumber;
//    }
//
//    public void setEmployeeNumber(int employeeNumber) {
//        this.employeeNumber = employeeNumber;
//    }
//
//    @Override
//    @JsonIgnore
//    public String getName()
//    {
//        return fullName;
//    }
//
//    public String[] getRoles()
//    {
//        return roles;
//    }
//
//    public void setRoles(String[] roles)
//    {
//        this.roles = roles;
//    }
//
//    public boolean hasRole(String roleName)
//    {
//        if (roles != null)
//        {
//            for(String role : roles)
//            {
//                if(roleName.equals(role))
//                {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    public boolean equals(LoginData loginData)
//    {
//        return emailAddress.equals(loginData.getEmailAddress());
//    }
//}

