package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Reservation;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationRepoTest {

    @Autowired
    ReservationRepo reservationRepo;

    @Test
    @Description("Testing that a reservation is correctly added to the database. Also tests read")
    void create(){
        // Adding a reservation
        // Activity, instructor and equipment is part of test data
        Reservation reservation = new Reservation(-1, "2020-10-12 08:19:00", "2020-10-12 10:19:00",
                123456789, 1, 1, 1, 20, 20);
        int id = reservationRepo.add(reservation);
        reservation.setId(id);

        Reservation readReservation = reservationRepo.findById(id);
        assertEquals(reservation.toString(), readReservation.toString());
    }

    @Test
    @Description("Testing that read all fetches all reservations from the database")
    void readAll() {
        // Reading all from database with fetchAll method
        List<Reservation> readAllList = reservationRepo.fetchAll();
        List<Reservation> readForLoop = new ArrayList<>();

        // Reading all from database by getting each by id
        for(int i = 1; i < readAllList.get(readAllList.size() - 1).getId() + 1; i++){
            Reservation res = reservationRepo.findById(i);
            if(res != null){
                readForLoop.add(res);
            }
        }
        assertEquals(readForLoop.toString(), readAllList.toString());
    }

    @Test
    @Description("Testing that a reservation is correctly deleted from the database")
    void delete(){
        // Adding a reservation
        Reservation reservation = new Reservation(-1, "2020-10-12 08:19:00", "2020-10-12 10:19:00",
                123456789, 1, 1, 1, 20, 20);
        int id = reservationRepo.add(reservation);
        reservation.setId(id);

        // Asserting reservation was added before deleting
        assertNotNull(reservationRepo.findById(id));

        // Deleting reservation
        reservationRepo.deleteReservation(reservationRepo.findById(id));
        assertNull(reservationRepo.findById(id));
    }

    @Test
    void edit(){
        // Adding a reservation
        Reservation reservation = new Reservation(-1, "2020-10-12 08:19:00", "2020-10-12 10:19:00",
                123456789, 1, 1, 1, 20, 20);
        int id = reservationRepo.add(reservation);
        reservation.setId(id);

        // Editing some aspects of the reservation
        reservation.setInstructorId(2);
        reservation.setParticipants(10);
        reservation.setEndDate("2020-10-12 11:00:00");
        reservationRepo.edit(reservation);

        assertEquals(reservation.toString(), reservationRepo.findById(id).toString());

    }
}