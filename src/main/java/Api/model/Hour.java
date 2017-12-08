package Api.model;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Boy, Wytze, Miguel.
 * This model represents the hour
 */
public class Hour {


    private String hour_approved;
    private int hour_subproject_number;
    private int hour_employee_number;
    private Time startTime;
    private Time endTime;
    private Time hour_amount_of_hours;
    private String hour_comments;
    private Date hour_date;
    private int id;

    public Hour(String hour_approved, int hour_subproject_number, int hour_employee_number, Time startTime, Time endTime, Time hour_amount_of_hours, String hour_comments, Date hour_date, int id) {
        this.hour_approved = hour_approved;
        this.hour_subproject_number = hour_subproject_number;
        this.hour_employee_number = hour_employee_number;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hour_amount_of_hours = hour_amount_of_hours;
        this.hour_comments = hour_comments;
        this.hour_date = hour_date;
        this.id = id;
    }

    public Hour(int hour_subproject_number, int hour_employee_number, Time startTime, Time endTime, String hour_comments, Date hour_date) {
        this.hour_subproject_number = hour_subproject_number;
        this.hour_employee_number = hour_employee_number;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hour_comments = hour_comments;
        this.hour_approved = "pending";
        hour_amount_of_hours = new Time(0);
        this.hour_amount_of_hours.setTime(endTime.getTime() - startTime.getTime() - 3600000);
        this.hour_date = hour_date;

    }

    public String hour_approved(){ return hour_approved;}

    public int getHour_subproject_number() {
        return hour_subproject_number;
    }

    public int getHour_employee_number() {
        return hour_employee_number;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Time getHour_amount_of_hours() {
        return hour_amount_of_hours;
    }

    public String getHour_comments() {
        return hour_comments;
    }

    public Date getHour_date() {
        return hour_date;
    }
    public String getHour_approved() {
        return hour_approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHour_approved(String hour_approved) {
        this.hour_approved = hour_approved;
    }

}
