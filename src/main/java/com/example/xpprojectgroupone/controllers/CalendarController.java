package com.example.xpprojectgroupone.controllers;


import com.example.xpprojectgroupone.calendarPackage.CalendarReservation;
import com.example.xpprojectgroupone.repositories.ActivityRepo;
import com.example.xpprojectgroupone.services.ActivityService;
import com.example.xpprojectgroupone.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CalendarController {

    private CalendarService calendarService;

    @Autowired
    public CalendarController(){
        calendarService = new CalendarService();
    }




}
