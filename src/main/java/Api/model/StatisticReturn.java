package Api.model;

public class StatisticReturn {

    private String employee;
    private String project;
    private String subproject;
    private int hours;
    private int minutes;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSubproject() {
        return subproject;
    }

    public void setSubproject(String subproject) {
        this.subproject = subproject;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
