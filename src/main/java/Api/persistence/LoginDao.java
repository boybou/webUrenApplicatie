package Api.persistence;

import Api.model.DatabaseInfo;
import Api.model.Login;
import Api.model.LoginData;

import javax.inject.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Boy, Vincent, Wytze.
 * This DAO connects to the Login_Data table.
 */
@Singleton
public class LoginDao implements Dao {

    private PreparedStatement getLoginData;
    private PreparedStatement insertLoginData;
    private PreparedStatement getPasswordByNumber;
    private PreparedStatement getUserIdByEmail;
    private PreparedStatement getUserEmail;

    public  LoginDao() {
        preparedStatements();
    }

    public void preparedStatements(){

        try {
            getLoginData = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM "+ DatabaseInfo.loginDataTableName+" WHERE "+DatabaseInfo.LoginDataColumnNames.email+" = ?;");
            insertLoginData = ConnectionHolder.getConnection().prepareStatement("INSERT INTO "+DatabaseInfo.loginDataTableName+" VALUES (?,?,?);");
            getPasswordByNumber = ConnectionHolder.getConnection().prepareStatement("SELECT "+DatabaseInfo.LoginDataColumnNames.password+" FROM "+DatabaseInfo.loginDataTableName+" WHERE "+DatabaseInfo.LoginDataColumnNames.employeeNumber+" = ?;");
            getUserIdByEmail = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM "+DatabaseInfo.loginDataTableName+" WHERE "+DatabaseInfo.LoginDataColumnNames.email+" = ?;");
            getUserEmail = ConnectionHolder.getConnection().prepareStatement("SELECT "+DatabaseInfo.LoginDataColumnNames.email+" FROM "+DatabaseInfo.loginDataTableName+" WHERE "+DatabaseInfo.LoginDataColumnNames.employeeNumber+" = ?;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getEmployeeEmailByID(int id){
        ResultSet rs;
        try {
            getUserEmail.setInt(1,id);
            rs = getUserEmail.executeQuery();
            //rs.next();
            System.out.println(rs.next());
            return rs.getString(DatabaseInfo.LoginDataColumnNames.email);
        } catch (SQLException e) {

            e.printStackTrace();
        }return null;
    }
    public Login getLoginData(String email){
        ResultSet rs;
        try {
            getLoginData.setString(1,email);
            rs = getLoginData.executeQuery();
            rs.next();
            Login login = new Login(rs.getString(DatabaseInfo.LoginDataColumnNames.password),rs.getString(DatabaseInfo.LoginDataColumnNames.email));
            return login;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getEmployeeNumberByEmail(String email){
        ResultSet rs;
        try {
            getUserIdByEmail.setString(1,email);
            rs = getUserIdByEmail.executeQuery();
            rs.next();
            return rs.getInt(DatabaseInfo.LoginDataColumnNames.employeeNumber);
        } catch (SQLException e) {

            e.printStackTrace();
        }return -1;
    }
    public int getEmployeeNumber(Login login){
        ResultSet rs;
        try {
            getLoginData.setString(1,login.getEmail());
            rs = getLoginData.executeQuery();
            rs.next();
            return rs.getInt(DatabaseInfo.LoginDataColumnNames.employeeNumber);
        } catch (SQLException e) {

            e.printStackTrace();
        }return -1;
    }
    public String getPassword(Login login){
        ResultSet rs;
        try {
            getLoginData.setString(1,login.getEmail());
            rs = getLoginData.executeQuery();
            rs.next();
            return rs.getString(DatabaseInfo.LoginDataColumnNames.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;

    }
    public boolean checkEmail(Login login){
        ResultSet rs;
        try {
            getLoginData.setString(1,login.getEmail());
            rs = getLoginData.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;


    }
    public void insertInlogData(LoginData loginData){

        try {
            insertLoginData.setString(1,loginData.getPassword());
            insertLoginData.setString(2,loginData.getEmail());
            insertLoginData.setInt(3,loginData.getEmployee_number());
            insertLoginData.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public String getPasswordByNumber(){
//        try {
//            getPasswordByNumber.setInt(1, User.getUserNumber());
//
//            ResultSet rs = getPasswordByNumber.executeQuery();
//            rs.next();
//            return rs.getString(DatabaseInfo.LoginDataColumnNames.password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}

