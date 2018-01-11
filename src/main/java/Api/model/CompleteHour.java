package Api.model;

import java.sql.Date;
import java.sql.Time;

public class CompleteHour {
    private String hour_approved;
    private int hour_subproject_number;
    private int hour_employee_number;
    private Time startTime;
    private Time endTime;
    private Time hour_amount_of_hours;
    private String hour_comments;
    private Date hour_date;
    private int id;
    private String hour_project_name;
    private String hour_subproject_name;
    private String hour_employee_first_name;
    private String hour_employee_last_name;
    private String hour_client_name;

    public CompleteHour(String hour_approved, int hour_subproject_number, int hour_employee_number, Time startTime, Time endTime, Time hour_amount_of_hours, String hour_comments, Date hour_date, int id, String hour_project_name, String hour_subproject_name, String hour_employee_first_name, String hour_employee_last_name, String hour_client_name) {
        this.hour_approved = hour_approved;
        this.hour_subproject_number = hour_subproject_number;
        this.hour_employee_number = hour_employee_number;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hour_amount_of_hours = hour_amount_of_hours;
        this.hour_comments = hour_comments;
        this.hour_date = hour_date;
        this.id = id;
        this.hour_project_name = hour_project_name;
        this.hour_subproject_name = hour_subproject_name;
        this.hour_employee_first_name = hour_employee_first_name;
        this.hour_employee_last_name = hour_employee_last_name;
        this.hour_client_name = hour_client_name;
    }

    public String getHour_employee_last_name() {
        return hour_employee_last_name;
    }

    public void setHour_employee_last_name(String hour_employee_last_name) {
        this.hour_employee_last_name = hour_employee_last_name;
    }
    public String getHour_approved() {
        return hour_approved;
    }

    public void setHour_approved(String hour_approved) {
        this.hour_approved = hour_approved;
    }

    public int getHour_subproject_number() {
        return hour_subproject_number;
    }

    public void setHour_subproject_number(int hour_subproject_number) {
        this.hour_subproject_number = hour_subproject_number;
    }

    public int getHour_employee_number() {
        return hour_employee_number;
    }

    public void setHour_employee_number(int hour_employee_number) {
        this.hour_employee_number = hour_employee_number;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Time getHour_amount_of_hours() {
        return hour_amount_of_hours;
    }

    public void setHour_amount_of_hours(Time hour_amount_of_hours) {
        this.hour_amount_of_hours = hour_amount_of_hours;
    }

    public String getHour_comments() {
        return hour_comments;
    }

    public void setHour_comments(String hour_comments) {
        this.hour_comments = hour_comments;
    }

    public Date getHour_date() {
        return hour_date;
    }

    public void setHour_date(Date hour_date) {
        this.hour_date = hour_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHour_project_name() {
        return hour_project_name;
    }

    public void setHour_project_name(String hour_project_name) {
        this.hour_project_name = hour_project_name;
    }

    public String getHour_subproject_name() {
        return hour_subproject_name;
    }

    public void setHour_subproject_name(String hour_subproject_name) {
        this.hour_subproject_name = hour_subproject_name;
    }

    public String getHour_employee_first_name() {
        return hour_employee_first_name;
    }

    public void setHour_employee_first_name(String hour_employee_first_name) {
        this.hour_employee_first_name = hour_employee_first_name;
    }

    public String getHour_client_name() {
        return hour_client_name;
    }

    public void setHour_client_name(String hour_client_name) {
        this.hour_client_name = hour_client_name;
    }
}
