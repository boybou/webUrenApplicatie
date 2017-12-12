package Api.model;

public class IncompleteHour {
    public String hour_client;
    public String hour_project_name;
    public String hour_subproject_name;
    public int hour_employee_number;
    public String startTime;
    public String endTime;
    public String hour_comments;
    public String hour_date;

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
