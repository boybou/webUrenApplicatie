package Api.model;

import Api.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.security.Principal;

public class User implements Principal
{
    @NotEmpty
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String fullName;

    @NotEmpty
    @Email
    @JsonView(View.Public.class)
    private String emailAddress;

    @NotEmpty
    @Length(min = 8)
    @JsonView(View.Protected.class)
    private String password;

    @JsonView(View.Private.class)
    private String[] roles;

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    @JsonIgnore
    public String getName()
    {
        return fullName;
    }

    public String[] getRoles()
    {
        return roles;
    }

    public void setRoles(String[] roles)
    {
        this.roles = roles;
    }

    public boolean hasRole(String roleName)
    {
        if (roles != null)
        {
            for(String role : roles)
            {
                if(roleName.equals(role))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean equals(User user)
    {
        return emailAddress.equals(user.getEmailAddress());
    }
}
