package com.example.xpprojectgroupone.services;

import com.example.xpprojectgroupone.models.Reservation;
import com.example.xpprojectgroupone.repositories.ReservationRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReservationService {
    ReservationRepo rp = new ReservationRepo();

    public void submitReservation(Reservation reservation) {
        rp.createReservation(reservation);
    }

    public ArrayList<Reservation> getReservations() {
        return rp.getAllReservations();
    }

    public void editReservation(Reservation reservation) {
        rp.editReservation(reservation);
    }

    public void deleteReservation(Reservation reservation) {
        rp.deleteReservation(reservation);
    }
}
