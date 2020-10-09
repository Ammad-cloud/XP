package com.example.xpprojectgroupone.calendarPackage;

import com.example.xpprojectgroupone.models.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;

public class CalendarReservation {

    Timestamp date = new Timestamp(230); // til test

    int year = 2020;
    int startDayOfMonth = 5;
    int spaces = startDayOfMonth;



    private ArrayList<DateCalendar> calendarList = new ArrayList<>();

    public ArrayList<DateCalendar> getCalendarList() {
        return calendarList;
    }

    String[] months = {
            "",
            "Januar", "Februar", "Marts",
            "April", "Maj", "Juni",
            "Juli", "August", "September",
            "Oktober", "November", "December"
    };

    int[] days = {
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };



    public CalendarReservation(){

        for (int month = 1; month <= 12; month++) {
            if  ((((year % 4 == 0) && (year % 100 != 0)) ||  (year % 400 == 0)) && month == 2)
                days[month] = 29;

            for (int day = 1; day <= days[month]; day++) {
                System.out.printf(" %3d ", day);
                if (((day + spaces) % 7 == 0) || (day == days[month])) System.out.println();
                calendarList.add(new DateCalendar(year, month, day));

            }
        }
    System.out.println(calendarList.size());

    }

  public void addReservation(Reservation res){
        for (DateCalendar date : calendarList) {
            if(date.getMonth() == res.getMonth()){
                if(date.getDay() == res.getDay()){
                    date.setReservation(res);
                }
            }
        }

    }

    public ArrayList<DateCalendar> returnMonth(int index){
        ArrayList<DateCalendar> returnList = new ArrayList<>();
        for (DateCalendar returnDate:
             calendarList) {
            if(returnDate.getMonth() == index){
                returnList.add(returnDate);
            }
        }

        return returnList;
    }

    public void timeStampTest(){

        int i = date.getYear();
        System.out.println(date.toString());
        System.out.println(i);
    }

    public void resTest(){

        for (DateCalendar dat:
             calendarList) {
            if(null != dat.getReservation())  {
                System.out.println(dat.getDay() + " " + dat.getMonth() + " " + dat.getYear());
            }

        }


    }





}
