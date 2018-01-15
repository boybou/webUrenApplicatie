package Api.service;

import Api.model.LoginData;
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
    public void insertLogindata(LoginData loginData) {
        dao.insertInlogData(loginData);
    }
}
