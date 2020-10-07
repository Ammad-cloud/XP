package com.example.xpprojectgroupone.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarServiceTest {

    @Test
    void inputReservation() {
        CalendarService calService = new CalendarService();
        calService.calendarReservation.resTest();
    }
}