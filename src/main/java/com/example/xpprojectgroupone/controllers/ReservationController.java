package com.example.xpprojectgroupone.controllers;

import com.example.xpprojectgroupone.models.Reservation;
import com.example.xpprojectgroupone.services.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ReservationController {
    ReservationService rs = new ReservationService();

    @GetMapping("/display-reservations")
    public String showReservations(Model model){
        ArrayList<Reservation> resArray = rs.getReservations();
        model.addAttribute("reservations", resArray);
        return "reservation/display-reservations";
    }

    @GetMapping("/create-reservation")
    public String createReservation(){
        return "reservation/create-reservation";
    }

    @PostMapping("/submit-reservation")
    public String submitReservation(@ModelAttribute Reservation reservation){
        rs.submitReservation(reservation);
        return "reservation/add-reservation";
    }

    @GetMapping("/edit-reservation")
    public String editReservation(){
        return "reservation/edit-reservation";
    }

    @PostMapping("/submit-reservation-edit")
    public String submitEditedReservation(@ModelAttribute Reservation reservation){
        rs.editReservation(reservation);
        return "redirect:display-reservations";
    }

    @PostMapping("/delete-reservation")
    public String deleteReservation(@ModelAttribute Reservation reservation){
        rs.deleteReservation(reservation);
        return "redirect:display-reservations";
    }

}
