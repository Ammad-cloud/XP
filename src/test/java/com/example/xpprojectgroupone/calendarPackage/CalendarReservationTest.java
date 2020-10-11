/*
USER STORIES: 13, 14

Opretter CalendarReservation objekt som tester timestamp funktionen som blev brugt tidligt men nu
ikke er aktuel

 */



package com.example.xpprojectgroupone.calendarPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarReservationTest {

    @Test
    void timeStampTest() {
        CalendarReservation test = new CalendarReservation();
        test.timeStampTest();
    }
}