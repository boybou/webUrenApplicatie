package Api.service;

import Api.model.CompleteHour;
import Api.model.Hour;
import Api.model.IncompleteHour;
import Api.persistence.HourDao;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public class HourService extends BaseService<Hour>{

    private final HourDao dao;

    @Inject
    public HourService(HourDao dao){
        this.dao = dao;
    }

    public ArrayList<Hour> getHours(int id){
        return dao.getEmployeeHours(id);
    }

    public void insertHour(IncompleteHour incompleteHour,int subProjectNumber){
        Time startTime = new Time(Integer.parseInt(incompleteHour.getStartTime().substring(0,2)), Integer.parseInt(incompleteHour.getStartTime().substring(3,5)), 0);
        Time endTime = new Time(Integer.parseInt(incompleteHour.getEndTime().substring(0,2)), Integer.parseInt(incompleteHour.getEndTime().substring(3,5)), 0);

        dao.insertHour(new Hour(subProjectNumber,incompleteHour.getHour_employee_number(), startTime, endTime, incompleteHour.getHour_comments(), dateParser(incompleteHour.getHour_date(),incompleteHour.getDate_format())));
    }

//    private Date dateParser(String inputDate){
//        Date date;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(""
//                + "[dd-MM-yyyy]"
//                + "[d-MM-yyyy]"
//                + "[MM-dd-yyyy]"
//                + "[MM-d-yyyy]"
//                + "[MM/dd/yyyy]"
//                + "[MM/d/yyyy]"
//                + "[dd-M-yyyy]"
//                + "[dd-MM-yyyy]"
//                + "[d-M-yyyy]"
//                + "[M-dd-yyyy]"
//                + "[M-d-yyyy]"
//                + "[M/dd/yyyy]"
//                + "[M/d/yyyy]"
//                + "[yyyy-MM-dd]"
//                + "[yyyy-M-dd]"
//                + "[yyyy-M-d]"
//                + "[yyyy-MM-d]"
//        );
//        LocalDate ld = LocalDate.parse(inputDate);
//        date = Date.valueOf(ld);
//        return date;
//    }
    private Date dateParser(String inputDate,String dateFormat){
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        java.util.Date parsed;
        try {
            parsed = format.parse(inputDate);
            System.out.println(inputDate+dateFormat);
            return new java.sql.Date(parsed.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Hour> getPendingHours(){
        return dao.getAllPendingHours();
    }
    public void approveHour(int hourId){
        dao.changeHourState(hourId,"approved");
    }
    public void disapproveHour(int hourId){
        dao.changeHourState(hourId,"disapproved");
    }

    public ArrayList<Hour> getCompleteHoursByDate(String date) {

        String dateFormat = "yyyy-MM-dd";
        System.out.println("SUPERBELANGRIJIK1!!!!!!!!!!!!!!!!!!!!!!" +dateParser(date,dateFormat));
        for(Hour hour: dao.getHourByDate(dateParser(date,dateFormat))){
            System.out.println(hour.getHour_subproject_number());
        }
        return dao.getHourByDate(dateParser(date,dateFormat));

    }

}
