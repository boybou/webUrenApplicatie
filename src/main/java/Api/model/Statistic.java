package Api.model;

public class Statistic {

    private String werknemer;
    private String project;
    private String subproject;
    private String bDate;
    private String eDate;


    public String getWerknemer() {
        return werknemer;
    }

    public void setWerknemer(String werknemer) {
        this.werknemer = werknemer;
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

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }
}
