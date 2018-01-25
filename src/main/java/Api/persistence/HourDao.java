package Api.persistence;

import Api.model.*;

import javax.inject.Singleton;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Wytze, Boy, Miguel.
 * This DAO connects to the Hour table.
 */
@Singleton
public class HourDao implements Dao{
    private PreparedStatement insertHour;
    private PreparedStatement getAllPendingHours;
    private PreparedStatement changeHourState;
    private PreparedStatement getProjectHours;
    private PreparedStatement getSubProjectHours;
    private PreparedStatement getSubProjectHoursEMP;
    private PreparedStatement getEmployeeHours;
    private PreparedStatement getEmployeeHourstotall;
    private PreparedStatement getHourByDate;


    public HourDao(){
        preparedStatements();
    }

    @Override
    public void preparedStatements() {
        try {

            insertHour = ConnectionHolder.getConnection().prepareStatement("insert into Hour ("+ DatabaseInfo.HourColumnNames.approved+", "+DatabaseInfo.HourColumnNames.subprojectNumber+", "+DatabaseInfo.HourColumnNames.employeeNumber+", "+DatabaseInfo.HourColumnNames.date+", "+DatabaseInfo.HourColumnNames.amountOfHours+", "+DatabaseInfo.HourColumnNames.starttime+","+DatabaseInfo.HourColumnNames.endtime+","+DatabaseInfo.HourColumnNames.comments+") VALUES (?,?,?,?,?,?,?,?)");
            getAllPendingHours = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM "+DatabaseInfo.hourTableName+" WHERE "+DatabaseInfo.HourColumnNames.approved+" = 'pending';");
            changeHourState = ConnectionHolder.getConnection().prepareStatement("UPDATE hour SET "+DatabaseInfo.HourColumnNames.approved+" = ? WHERE "+DatabaseInfo.HourColumnNames.id+" = ?;");

            getProjectHours = ConnectionHolder.getConnection().prepareStatement(
                    "SELECT * FROM "+DatabaseInfo.hourTableName+" h JOIN "+DatabaseInfo.subprojectTableName+" s " +
                            "ON h."+DatabaseInfo.HourColumnNames.subprojectNumber+" = s."+DatabaseInfo.SubprojectColumnNames.number+" " +
                            "WHERE s."+DatabaseInfo.SubprojectColumnNames.projectNumber+" = ?;");
            getSubProjectHours = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM "+DatabaseInfo.hourTableName+" WHERE "+DatabaseInfo.HourColumnNames.subprojectNumber+" = ?;");
            getSubProjectHoursEMP = ConnectionHolder.getConnection().prepareStatement(
                    "SELECT * FROM "+DatabaseInfo.hourTableName+" WHERE "+DatabaseInfo.HourColumnNames.subprojectNumber+" = ? AND "+DatabaseInfo.HourColumnNames.employeeNumber+" = ?;");
            getEmployeeHours = ConnectionHolder.getConnection().prepareStatement(
                    "SELECT * FROM "+DatabaseInfo.hourTableName+" WHERE "+DatabaseInfo.HourColumnNames.employeeNumber+"=?;");
            getEmployeeHourstotall = ConnectionHolder.getConnection().prepareStatement(
                    "SELECT * FROM "+DatabaseInfo.hourTableName+" WHERE "+DatabaseInfo.HourColumnNames.employeeNumber+"=? AND hour_approved = 'approved';");
            getHourByDate = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM " + DatabaseInfo.hourTableName + " WHERE " + DatabaseInfo.HourColumnNames.date + " = ? AND "+DatabaseInfo.HourColumnNames.employeeNumber+" = ?;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void changeHourState(int id, String state) {
        try {
            changeHourState.setString(1,state);
            changeHourState.setInt(2,id);
            changeHourState.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public synchronized ArrayList<Hour> getHourByDate(Date date,int employeeId){
        ArrayList<Hour> dateHours = new ArrayList<Hour>();
        try {
            getHourByDate.setDate(1,date);
            getHourByDate.setInt(2,employeeId);
            ResultSet rs = getHourByDate.executeQuery();
            while(rs.next()){
                dateHours.add(new Hour(rs.getString(DatabaseInfo.HourColumnNames.approved),rs.getInt(DatabaseInfo.HourColumnNames.subprojectNumber),rs.getInt(DatabaseInfo.HourColumnNames.employeeNumber),rs.getTime(DatabaseInfo.HourColumnNames.starttime),rs.getTime(DatabaseInfo.HourColumnNames.endtime),rs.getTime(DatabaseInfo.HourColumnNames.amountOfHours),rs.getString(DatabaseInfo.HourColumnNames.comments),rs.getDate(DatabaseInfo.HourColumnNames.date),rs.getInt(DatabaseInfo.HourColumnNames.id)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dateHours;
    }
    public void insertHour(Hour hour){
        try {
            insertHour.setString(1, hour.getHour_approved());
            insertHour.setInt(2, hour.getHour_subproject_number());
            insertHour.setInt(3,hour.getHour_employee_number());
            insertHour.setDate(4, hour.getHour_date());
            insertHour.setTime(5,hour.getHour_amount_of_hours());
            insertHour.setTime(6,hour.getStartTime());
            insertHour.setTime(7,hour.getEndTime());
            insertHour.setString(8,hour.getHour_comments());
            insertHour.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


    public ArrayList<Hour> getAllPendingHours(){
        ArrayList<Hour> pendingHours = new ArrayList<Hour>();
        try {
            ResultSet rs = getAllPendingHours.executeQuery();
            while(rs.next()){
                pendingHours.add(new Hour(rs.getString(DatabaseInfo.HourColumnNames.approved),
                        rs.getInt(DatabaseInfo.HourColumnNames.subprojectNumber),
                        rs.getInt(DatabaseInfo.HourColumnNames.employeeNumber),
                        rs.getTime(DatabaseInfo.HourColumnNames.starttime),
                        rs.getTime(DatabaseInfo.HourColumnNames.endtime),
                        rs.getTime(DatabaseInfo.HourColumnNames.amountOfHours),
                        rs.getString(DatabaseInfo.HourColumnNames.comments),
                        rs.getDate(DatabaseInfo.HourColumnNames.date),
                        rs.getInt(DatabaseInfo.HourColumnNames.id)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingHours;
    }

    public ArrayList<Hour> getEmployeeHours(int employee)
    {
        ResultSet rs = null;
        try {
            getEmployeeHours.setInt(1, employee);
            rs = getEmployeeHours.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return makeHourList(rs);
    }

    public ArrayList<Hour> getEmployeeHourstotall(int employee)
    {
        ResultSet rs = null;
        try {
            getEmployeeHourstotall.setInt(1, employee);
            rs = getEmployeeHourstotall.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return makeHourList(rs);
    }

    public ArrayList<Hour> getSubProjectHours(SubProject subProject)
    {
        ResultSet rs = null;
        try {
            getSubProjectHours.setInt(1, subProject.getSubProject_Project_Number());
            rs = getSubProjectHours.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return makeHourList(rs);
    }
    public ArrayList<Hour> getSubProjectHoursEMP(SubProject subProject, int employee)
    {
        ResultSet rs = null;
        try {
            getSubProjectHoursEMP.setInt(1, subProject.getSubProject_Project_Number());
            getSubProjectHoursEMP.setInt(2, employee);
            rs = getSubProjectHoursEMP.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return makeHourList(rs);
    }

    public ArrayList<Hour> getProjectHours(Project project)
    {
        ResultSet rs = null;
        try {
            getProjectHours.setInt(1, project.getProject_Number());
            rs = getProjectHours.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return makeHourList(rs);
    }

    public ArrayList<Hour> makeHourList(ResultSet rs)
    {

        ArrayList<Hour> hourList = new ArrayList<Hour>();

        try {
            while (rs.next())
            {
                Hour hour = new Hour (rs.getString(DatabaseInfo.HourColumnNames.approved), rs.getInt(DatabaseInfo.HourColumnNames.subprojectNumber)
                        ,rs.getInt(DatabaseInfo.HourColumnNames.employeeNumber) ,rs.getTime(DatabaseInfo.HourColumnNames.starttime)
                        ,rs.getTime(DatabaseInfo.HourColumnNames.endtime) ,rs.getTime(DatabaseInfo.HourColumnNames.amountOfHours)
                        ,rs.getString(DatabaseInfo.HourColumnNames.comments), rs.getDate(DatabaseInfo.HourColumnNames.date), rs.getInt(DatabaseInfo.HourColumnNames.id));
                hourList.add(hour);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hourList;
    }


}
