package com.example.xpprojectgroupone.repositories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationRepoTest {

    @Test
    void getAllReservations() {
        EquipmentRepo rep = new EquipmentRepo();
        System.out.println(rep.readAll().toString());
    }
}