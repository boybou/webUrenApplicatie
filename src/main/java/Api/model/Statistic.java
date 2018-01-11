package Api.model;

public class Statistic {
    private String hour_client;
    private String hour_project_name;
    private String hour_subproject_name;
    private int hour_employee_number;
    private String startTime;
    private String endTime;
    private String hour_comments;
    private String hour_date;

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
}
