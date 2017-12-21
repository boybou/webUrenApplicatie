package Api.persistence;



import Api.model.Client;
import Api.model.DatabaseInfo;

import javax.inject.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Wytze, Boy.
 * This DAO makes connnection to the Client table.
 */
@Singleton
public class ClientDao implements Dao {
    private PreparedStatement insertClient;
    private PreparedStatement checkClientExitst;
    private PreparedStatement getAllClients;
    private PreparedStatement getProjectAndClient;

    public ClientDao() {
        preparedStatements();
    }

    public void preparedStatements(){

        try {
            insertClient = ConnectionHolder.getConnection().prepareStatement("INSERT INTO "+ DatabaseInfo.clientTableName+" VALUES (?);");
            checkClientExitst = ConnectionHolder.getConnection().prepareStatement("select * from "+DatabaseInfo.clientTableName+" where "+DatabaseInfo.ClientColumnNames.name+" = (?);");
            getAllClients = ConnectionHolder.getConnection().prepareStatement("select * from "+DatabaseInfo.clientTableName+";");
            getProjectAndClient = ConnectionHolder.getConnection().prepareStatement("select p."+DatabaseInfo.ProjectColumnNames.name+", p."+DatabaseInfo.ProjectColumnNames.clientName+" from "+DatabaseInfo.hourTableName+" h JOIN "+DatabaseInfo.subprojectTableName+" s  ON h."+DatabaseInfo.HourColumnNames.subprojectNumber+" = s."+DatabaseInfo.SubprojectColumnNames.number+"  JOIN "+DatabaseInfo.projectTableName+" p  ON s."+DatabaseInfo.SubprojectColumnNames.projectNumber+" = p."+DatabaseInfo.ProjectColumnNames.number+" where h."+DatabaseInfo.HourColumnNames.id+" = ?;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] getProjectAndClient(int id){
        String[] stringArray = new String[2];
        try {
            getProjectAndClient.setInt(1, id);
            ResultSet rs = getProjectAndClient.executeQuery();
            rs.next();
            stringArray[0] = rs.getString(DatabaseInfo.ProjectColumnNames.name);
            stringArray[1] = rs.getString(DatabaseInfo.ProjectColumnNames.clientName);
            System.out.println(stringArray[0]);
            return stringArray;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringArray;
    }


    public void insertClient(Client client){
        try {
            insertClient.setString(1, client.getClient_name());
            insertClient.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Boolean checkClientExist(String clientName){
        try {
            checkClientExitst.setString(1, clientName);
            ResultSet rs = checkClientExitst.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;

    }
    public ArrayList selectAllClients(){

        ArrayList<Client> clientArray = new ArrayList<Client>();
        try {
            ResultSet rs =  getAllClients.executeQuery();
            while(rs.next()){
                Client client = new Client(rs.getString(DatabaseInfo.ClientColumnNames.name));
                clientArray.add(client);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }return clientArray;
    }
}
