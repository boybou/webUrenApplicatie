package Api.model;

public class statisticReturn {

    private String employee;
    private String project;
    private String subproject;
    private double hours;

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

    public void setHours(double hours) {
        this.hours = hours;
    }


}
