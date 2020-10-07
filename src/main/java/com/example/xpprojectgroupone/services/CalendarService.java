package com.example.xpprojectgroupone.services;

import com.example.xpprojectgroupone.calendarPackage.CalendarReservation;
import com.example.xpprojectgroupone.models.Reservation;
import com.example.xpprojectgroupone.repositories.ReservationRepo;

import java.util.ArrayList;
import java.util.Date;

public class CalendarService {

    ReservationRepo reservationRepo;
    public CalendarReservation calendarReservation;


    public CalendarService(){

        reservationRepo = new ReservationRepo();
        calendarReservation = new CalendarReservation();
        inputReservation();
    }



    public void inputReservation(){
        ArrayList<Reservation> reserv = reservationRepo.getAllReservations();
        for (Reservation res:
             reserv) {
            calendarReservation.inputReservation(res);

        }
    }

}
