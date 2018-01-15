package Api.persistence;



import Api.model.DatabaseInfo;
import Api.model.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by Wytze, Boy, Casper.
 * This DAO connects to the Project Table.
 */
public class ProjectDao implements Dao {
    private PreparedStatement insertProject;
    private PreparedStatement checkProjectExist;
    private PreparedStatement selectAllProjects;
    private PreparedStatement getSpecificProject;
    private PreparedStatement getProjectById;

    public ProjectDao(){
        preparedStatements();
    }


    public void preparedStatements() {
        try {
            //test preparedstatment for inserting a person into our test database
            insertProject = ConnectionHolder.getConnection().prepareStatement("insert into "+ DatabaseInfo.projectTableName+" ("+DatabaseInfo.ProjectColumnNames.name+","+DatabaseInfo.ProjectColumnNames.clientName+" ) values (?,?)");
            checkProjectExist = ConnectionHolder.getConnection().prepareStatement("select * from "+DatabaseInfo.projectTableName+" where "+DatabaseInfo.ProjectColumnNames.name+"=(?)");
            selectAllProjects = ConnectionHolder.getConnection().prepareStatement("select * from "+DatabaseInfo.projectTableName+"");
            getSpecificProject = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM "+DatabaseInfo.projectTableName+" WHERE "+DatabaseInfo.ProjectColumnNames.name+" =?;");
            getProjectById = ConnectionHolder.getConnection().prepareStatement("SELECT * FROM " + DatabaseInfo.projectTableName + " WHERE " +DatabaseInfo.ProjectColumnNames.number+" = ?;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Project getProjectById(int projectId){
        try {
            getProjectById.setInt(1, projectId);
            ResultSet rs = getProjectById.executeQuery();
            rs.next();
            return new Project(rs.getString(DatabaseInfo.ProjectColumnNames.name), rs.getInt(DatabaseInfo.ProjectColumnNames.number),rs.getString("project_client_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertProject(Project project){
        try {
            insertProject.setString(1, project.getProject_Name());
            insertProject.setString(2,project.getProject_client_name());
            insertProject.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public Boolean checkProjectExist(String projectName){
        try {
            checkProjectExist.setString(1, projectName);
            ResultSet resultSet = checkProjectExist.executeQuery();
            if(resultSet.next()){
                return TRUE;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return FALSE;

    }
    public Project getSpecificProject(String project_naam){
        ResultSet rs = null;
        try {
            getSpecificProject.setString(1, project_naam);
            rs = getSpecificProject.executeQuery();
            rs.next();
            return new Project(rs.getString(DatabaseInfo.ProjectColumnNames.name), rs.getInt(DatabaseInfo.ProjectColumnNames.number),rs.getString("project_client_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public ArrayList selectAllProjects(){

        ArrayList<Project> projectArray = new ArrayList<Project>();
        try {
            ResultSet rs =  selectAllProjects.executeQuery();
            while(rs.next()){
                Project project = new Project(rs.getString(DatabaseInfo.ProjectColumnNames.name),rs.getInt(DatabaseInfo.ProjectColumnNames.number),rs.getString(DatabaseInfo.ProjectColumnNames.clientName));
                projectArray.add(project);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }return projectArray;
    }
}

