package Api.service;

import Api.model.LoginData;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

public class BaseService<T>
{
    public T requireResult(T model)
    {
        if (model == null)
        {
            throw new NotFoundException();
        }

        return model;
    }

    public void assertSelf(LoginData loginData1, LoginData loginData2)
    {
        if (!loginData1.equals(loginData2))
        {
            throw new ForbiddenException();
        }
    }
}