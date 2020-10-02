package com.example.xpprojectgroupone.controllers;


import com.example.xpprojectgroupone.repositories.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipmentController {
    private EquipmentRepo equipmentRepo;

    @Autowired
    public EquipmentController() {
        equipmentRepo = new EquipmentRepo();
    }

    @GetMapping("/gokart/list")
    public String manageEquipment(Model model) {
        model.addAttribute("viewEquipment", equipmentRepo.readAll());
        return "home/Equipment/manageGokarts";
    }
}







/*
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "home/index";
    }*/

