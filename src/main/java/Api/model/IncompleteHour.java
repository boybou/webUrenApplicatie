package Api.model;

public class IncompleteHour {
    private String hour_client;
    private String hour_project_name;
    private String hour_subproject_name;
    private int hour_employee_number;
    private String startTime;
    private String endTime;
    private String hour_comments;
    private String hour_date;
    private String date_format;

    public IncompleteHour(String hour_client, String hour_project_name, String hour_subproject_name, int hour_employee_number, String startTime, String endTime, String hour_comments, String hour_date, String date_format) {
        this.hour_client = hour_client;
        this.hour_project_name = hour_project_name;
        this.hour_subproject_name = hour_subproject_name;
        this.hour_employee_number = hour_employee_number;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hour_comments = hour_comments;
        this.hour_date = hour_date;
        this.date_format = date_format;
    }
    public IncompleteHour(){

    }

    public String getHour_client() {
        return hour_client;
    }

    public String getHour_project_name() {
        return hour_project_name;
    }

    public String getHour_subproject_name() {
        return hour_subproject_name;
    }

    public int getHour_employee_number() {
        return hour_employee_number;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getHour_comments() {
        return hour_comments;
    }

    public String getHour_date() {
        return hour_date;
    }

    public void setHour_client(String hour_client) {
        this.hour_client = hour_client;
    }

    public void setHour_project_name(String hour_project_name) {
        this.hour_project_name = hour_project_name;
    }

    public void setHour_subproject_name(String hour_subproject_name) {
        this.hour_subproject_name = hour_subproject_name;
    }

    public void setHour_employee_number(int hour_employee_number) {
        this.hour_employee_number = hour_employee_number;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setHour_comments(String hour_comments) {
        this.hour_comments = hour_comments;
    }

    public void setHour_date(String hour_date) {
        this.hour_date = hour_date;
    }

    public String getDate_format() {
        return date_format;
    }

    public void setDate_format(String date_format) {
        this.date_format = date_format;
    }
}
