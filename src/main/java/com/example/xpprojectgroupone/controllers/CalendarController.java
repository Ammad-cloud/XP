package com.example.xpprojectgroupone.controllers;


import com.example.xpprojectgroupone.calendarPackage.CalendarReservation;
import com.example.xpprojectgroupone.repositories.ActivityRepo;
import com.example.xpprojectgroupone.services.ActivityService;
import com.example.xpprojectgroupone.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

    private CalendarService calendarService;

    @Autowired
    public CalendarController(){
        calendarService = new CalendarService();
    }

    @GetMapping("/calendar/calendarReservation")
    public String calendarIndex(Model model) {
        model.addAttribute("january", calendarService.getCalendarReservation().returnMonth(1));
        model.addAttribute("february", calendarService.getCalendarReservation().returnMonth(2));
        model.addAttribute("march", calendarService.getCalendarReservation().returnMonth(3));
        model.addAttribute("april", calendarService.getCalendarReservation().returnMonth(4));
        model.addAttribute("may", calendarService.getCalendarReservation().returnMonth(5));
        model.addAttribute("june", calendarService.getCalendarReservation().returnMonth(6));
        model.addAttribute("july", calendarService.getCalendarReservation().returnMonth(7));
        model.addAttribute("august", calendarService.getCalendarReservation().returnMonth(8));
        model.addAttribute("september", calendarService.getCalendarReservation().returnMonth(9));
        model.addAttribute("october", calendarService.getCalendarReservation().returnMonth(10));
        model.addAttribute("november", calendarService.getCalendarReservation().returnMonth(11));
        model.addAttribute("december", calendarService.getCalendarReservation().returnMonth(12));
        return "calendar/calendarReservation";
    }




}
