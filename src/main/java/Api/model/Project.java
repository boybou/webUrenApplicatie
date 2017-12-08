package Api.model;

/**
 * Created by Wytze, Casper, Boy.
 * This model represents the projects
 */
public class Project {
    String project_Name;
    int project_Number;
    String project_client_name;



    public Project(String project_Name, int project_Number, String project_client_name) {
        this.project_Name = project_Name;
        this.project_Number = project_Number;
        this.project_client_name = project_client_name;
    }


    public Project(String project_Name, String project_client_name) {
        this.project_Name = project_Name;
        this.project_client_name = project_client_name;
    }

    public String getProject_Name() {
        return project_Name;
    }

    public int getProject_Number() {
        return project_Number;
    }
    public String getProject_client_name() {
        return project_client_name;
    }
    public void setProject_client_name(String project_client_name) {
        this.project_client_name = project_client_name;
    }
}