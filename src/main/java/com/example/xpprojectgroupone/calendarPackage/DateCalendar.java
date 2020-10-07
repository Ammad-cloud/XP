package com.example.xpprojectgroupone.calendarPackage;

import com.example.xpprojectgroupone.models.Reservation;

public class DateCalendar {



    Reservation reservation;



    private int year;
    private int month;
    private int day;


    public DateCalendar(int year, int month, int day){

        this.year = year;
        this.month = month;
        this.day = day;

    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

}
