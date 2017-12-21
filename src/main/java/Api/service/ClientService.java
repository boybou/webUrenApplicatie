package Api.service;


import Api.model.Client;
import Api.persistence.ClientDao;
import Api.persistence.HourDao;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class ClientService extends BaseService<ClientService> {
    private final ClientDao clientDao;

    @Inject
    public ClientService(ClientDao dao){
        this.clientDao = dao;
    }

    public void insertClient(String clientName){
        clientDao.insertClient(new Client(clientName));
    }
    public boolean checkIfClientExitis(String clientName){
        return clientDao.checkClientExist(clientName);
    }
    public ArrayList<Client> selectAllClients(){
        return clientDao.selectAllClients();
    }
}
