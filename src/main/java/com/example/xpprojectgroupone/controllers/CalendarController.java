/*
USER STORIE: 13, 14

Sender kalendar informationer ud til view


 */




package com.example.xpprojectgroupone.controllers;


import com.example.xpprojectgroupone.calendarPackage.CalendarReservation;
import com.example.xpprojectgroupone.models.Reservation;
import com.example.xpprojectgroupone.repositories.ActivityRepo;
import com.example.xpprojectgroupone.repositories.EmployeeRepo;
import com.example.xpprojectgroupone.repositories.ReservationRepo;
import com.example.xpprojectgroupone.services.ActivityService;
import com.example.xpprojectgroupone.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CalendarController {

    private CalendarService calendarService;
    @Autowired
    private ReservationRepo rr;
    @Autowired
    ActivityRepo ar;
    @Autowired
    EmployeeRepo er;

    @Autowired
    public CalendarController(){
        calendarService = new CalendarService();
    }

    @GetMapping("/calendar/calendarReservation/{monthId}")
    public String calendarIndex(Model model, @PathVariable("monthId") int monthId) {
        List<Reservation> reservationList = rr.fetchAll();
        for(Reservation res : reservationList){
            calendarService.getCalendarReservation().addReservation(res);

            res.setActivityName(ar.read(res.getActivityId()).getName());

            String firstName = er.read(res.getInstructorId()).getFirstName();
            String lastName = er.read(res.getInstructorId()).getLastName();
            res.setInstructorName(String.format("%s %s", firstName, lastName));
        }
        model.addAttribute("month", calendarService.getCalendarReservation().returnMonth(monthId));

        model.addAttribute("reservations", rr.fetchAll());
        return "calendar/calendarReservation";
    }

    @PostMapping("/calendar/calendarReservation")
    public String calendarMonth(@RequestParam int id, Model model){
        List<Reservation> reservationList = rr.fetchAll();
        for(Reservation res : reservationList){
            calendarService.getCalendarReservation().addReservation(res);

            res.setActivityName(ar.read(res.getActivityId()).getName());

            String firstName = er.read(res.getInstructorId()).getFirstName();
            String lastName = er.read(res.getInstructorId()).getLastName();
            res.setInstructorName(String.format("%s %s", firstName, lastName));
        }
        model.addAttribute("month", calendarService.getCalendarReservation().returnMonth(id));

        model.addAttribute("reservations", rr.fetchAll());
        return "calendar/calendarReservation";
    }





}
