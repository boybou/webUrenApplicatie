package Api.service;

import Api.model.Hour;
import Api.persistence.HourDao;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class HourService extends BaseService<Hour>{

    private final HourDao dao;

    @Inject
    public HourService(HourDao dao){
        this.dao = dao;
    }

    public ArrayList<Hour> get(int id){
        return dao.getEmployeeHours(id);
    }
}
