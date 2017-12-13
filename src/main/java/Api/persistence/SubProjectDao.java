package Api.persistence;



import Api.model.DatabaseInfo;
import Api.model.SubProject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Wytze, Boy, Miguel.
 * This DAO connects to the SubProjectTable.
 */
public class SubProjectDao implements Dao {
    private PreparedStatement insertSubProject;
    private PreparedStatement deleteSubProject;
    private PreparedStatement updateSubProjectName;
    private PreparedStatement getSubProjectTable;
    private PreparedStatement getSpecificSubProject;



    public SubProjectDao(){
        preparedStatements();
    }

    public void preparedStatements() {
        try {
            insertSubProject = ConnectionHolder.getConnection().prepareStatement("insert into "+ DatabaseInfo.subprojectTableName+" ("+DatabaseInfo.SubprojectColumnNames.name+", "+DatabaseInfo.SubprojectColumnNames.projectNumber+" ) values (?,?);");
            deleteSubProject = ConnectionHolder.getConnection().prepareStatement("DELETE FROM "+DatabaseInfo.subprojectTableName+" WHERE "+DatabaseInfo.SubprojectColumnNames.number+" = ?;");
            updateSubProjectName = ConnectionHolder.getConnection().prepareStatement("UPDATE "+DatabaseInfo.subprojectTableName+" SET "+DatabaseInfo.SubprojectColumnNames.name+" = ? WHERE "+DatabaseInfo.SubprojectColumnNames.number+" = ?;");
            getSubProjectTable = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM "+DatabaseInfo.subprojectTableName+" s  JOIN "+DatabaseInfo.projectTableName+" p ON s."+DatabaseInfo.SubprojectColumnNames.projectNumber+" = p."+DatabaseInfo.ProjectColumnNames.number+" WHERE p."+DatabaseInfo.ProjectColumnNames.name+" = ?");
            getSpecificSubProject = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM "+DatabaseInfo.subprojectTableName+" WHERE "+DatabaseInfo.SubprojectColumnNames.name+" = ?;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSubProject(SubProject subProject){
        try {
            insertSubProject.setString(1, subProject.getSubProject_Name());
            insertSubProject.setInt(2, subProject.getSubProject_Project_Number());
            insertSubProject.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSubProject(SubProject subProject)
    {
        try
        {
            deleteSubProject.setInt(1, subProject.getSubProject_Number());
            deleteSubProject.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUpdateSubProjectName(SubProject subProject)
    {
        try
        {
            updateSubProjectName.setString(1, subProject.getSubProject_Name());
            updateSubProjectName.setInt(2, subProject.getSubProject_Number());
            updateSubProjectName.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public SubProject getSpecificSubProject(String Subproject_naam){
        ResultSet rs = null;
        try {
            getSpecificSubProject.setString(1, Subproject_naam);
            rs = getSpecificSubProject.executeQuery();
            rs.next();
            return new SubProject(rs.getString(DatabaseInfo.SubprojectColumnNames.name), rs.getInt(DatabaseInfo.SubprojectColumnNames.projectNumber), rs.getInt(DatabaseInfo.SubprojectColumnNames.number));
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return null;

    }
    public Boolean checkIfSubprojectExists(String Subproject_naam){
        ResultSet rs = null;
        try {
            getSpecificSubProject.setString(1,Subproject_naam);
            rs = getSpecificSubProject.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public ArrayList<SubProject> getsubProjectArrayList()
    {
        ArrayList<SubProject> subProjectArrayList = new ArrayList<>();
        try
        {
            ResultSet resultSet = getSubProjectTable.executeQuery();

            while (resultSet.next())
            {
                SubProject sub = new SubProject (resultSet.getString(DatabaseInfo.SubprojectColumnNames.name),
                        resultSet.getInt(DatabaseInfo.SubprojectColumnNames.number),resultSet.getInt(DatabaseInfo.SubprojectColumnNames.projectNumber));
                subProjectArrayList.add (sub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subProjectArrayList;
    }
}
