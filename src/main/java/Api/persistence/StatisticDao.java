package Api.persistence;

import Api.model.DatabaseInfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatisticDao implements Dao
{

    private PreparedStatement getEmployeeHoursAll;
    private PreparedStatement getEmployeeHoursProject;
    private PreparedStatement getEmployeeHoursSubproject;
    private PreparedStatement getProjectHours;
    private PreparedStatement getSubprojectHours;


    @Override
    public void preparedStatements() {
        try {
            getEmployeeHoursAll = ConnectionHolder.getConnection().prepareStatement(
                    "SELECT * FROM "+DatabaseInfo.employeeTableName+" WHERE "+DatabaseInfo.SubprojectColumnNames.number+" = ?;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
