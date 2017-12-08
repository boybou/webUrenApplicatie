package Api.model;

/**
 * Created by Wytze, Miguel.
 * This model represents the subproject
 */
public class SubProject {
    private String subProject_Name;
    private int subProject_Project_Number;
    private int subProject_Number;


    public SubProject(String sub_Project_Name, int subProject_Project_Number) {
        this.subProject_Name = sub_Project_Name;
        this.subProject_Project_Number = subProject_Project_Number;
    }

    public SubProject(String sub_Project_Name, int sub_Project_Project_Number, int subProject_Number) {
        this.subProject_Name = sub_Project_Name;
        this.subProject_Project_Number = sub_Project_Project_Number;
        this.subProject_Number = subProject_Number;
    }

    public String getSubProject_Name() {
        return subProject_Name;
    }

    public void setSubProject_Name(String name)
    {
        subProject_Name = name;
    }

    public int getSubProject_Number() {
        return subProject_Number;
    }

    public int getSubProject_Project_Number() { return subProject_Project_Number; }


}