package Api.persistence;

import Api.model.DatabaseInfo;
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
    private PreparedStatement setPassword;

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
            setPassword = ConnectionHolder.getConnection().prepareStatement("UPDATE " +DatabaseInfo.loginDataTableName+" SET "+DatabaseInfo.LoginDataColumnNames.password+"= ? WHERE "+DatabaseInfo.LoginDataColumnNames.employeeNumber+" =?;");
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
    public LoginData getLoginData(String email){
        ResultSet rs;
        try {
            getLoginData.setString(1,email);
            rs = getLoginData.executeQuery();
            rs.next();
            LoginData loginData = new LoginData();
            loginData.setEmail(rs.getString(DatabaseInfo.LoginDataColumnNames.email));
            loginData.setPassword(rs.getString(DatabaseInfo.LoginDataColumnNames.password));
            return loginData;
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
    public int getEmployeeNumber(LoginData loginData){
        ResultSet rs;
        try {
            getLoginData.setString(1,loginData.getEmail());
            rs = getLoginData.executeQuery();
            rs.next();
            return rs.getInt(DatabaseInfo.LoginDataColumnNames.employeeNumber);
        } catch (SQLException e) {

            e.printStackTrace();
        }return -1;
    }
    public String getPassword(LoginData loginData){
        ResultSet rs;
        try {
            getLoginData.setString(1,loginData.getEmail());
            rs = getLoginData.executeQuery();
            rs.next();
            return rs.getString(DatabaseInfo.LoginDataColumnNames.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;

    }
    public boolean checkEmail(LoginData loginData){
        ResultSet rs;
        try {
            getLoginData.setString(1,loginData.getEmail());
            rs = getLoginData.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;


    }
    public void insertInlogData(LoginData loginData){
        System.out.println("In login data");
        try {
            insertLoginData.setString(1,loginData.getPassword());
            insertLoginData.setString(2,loginData.getEmail());
            insertLoginData.setInt(3,loginData.getEmployeeNumber());
            insertLoginData.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPassword(LoginData loginData){

        try{
            setPassword.setString(1, loginData.getPassword());
            setPassword.setInt(2, loginData.getEmployeeNumber());
            insertLoginData.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public String getPasswordByNumber(){
//        try {
//            getPasswordByNumber.setInt(1, LoginData.getUserNumber());
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

