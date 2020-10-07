package com.example.xpprojectgroupone.controllers;

import com.example.xpprojectgroupone.models.Reservation;
import com.example.xpprojectgroupone.repositories.ActivityRepo;
import com.example.xpprojectgroupone.repositories.EmployeeRepo;
import com.example.xpprojectgroupone.repositories.EquipmentRepo;
import com.example.xpprojectgroupone.repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reservations")
@Controller
public class ReservationController {
    @Autowired
    ReservationRepo rr;
    @Autowired
    ActivityRepo ar;
    @Autowired
    EquipmentRepo er;
    @Autowired
    EmployeeRepo emr;


    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("reservations", rr.fetchAll());
        return "reservation/display-reservations";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("activities", ar.readAll());
        model.addAttribute("equipment", er.readAll());
        model.addAttribute("instructors", emr.readAll());
        return "reservation/create-reservation";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute Reservation reservation){
        rr.add(reservation);
        return "redirect:/reservations/list";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam int id, Model model){
        Reservation reservation = rr.findById(id);

        String startDate = reservation.getStartDate();
        reservation.setStartDate(startDate.replace(" ", "T").substring(0, startDate.length() - 3));

        String endDate = reservation.getEndDate();
        reservation.setEndDate(endDate.replace(" ", "T").substring(0, endDate.length() - 3));
        model.addAttribute("reservation", reservation);
        model.addAttribute("activities", ar.readAll());
        model.addAttribute("equipment", er.readAll());
        model.addAttribute("instructors", emr.readAll());
        return "reservation/edit-reservation";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Reservation reservation){
        rr.edit(reservation);
        return "redirect:/reservations/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        //rp.delete(id);
        return "redirect:/reservations/list";
    }

}
