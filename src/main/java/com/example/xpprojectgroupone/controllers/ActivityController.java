package com.example.xpprojectgroupone.controllers;


import com.example.xpprojectgroupone.models.Activity;
import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.repositories.ActivityRepo;
import com.example.xpprojectgroupone.repositories.EquipmentRepo;
import com.example.xpprojectgroupone.services.ActivityService;
import com.example.xpprojectgroupone.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/activities")
@Controller
public class ActivityController {
    @Autowired
    ActivityRepo activityRepo;
    @Autowired
    EquipmentRepo equipmentRepo;


    @GetMapping("/list") //ændre til det rigtige getmapping navn når view er lavet
    public String activityList(Model model){
        model.addAttribute("activity", activityRepo.readAll());
        return "/activities/list";
    }

    @GetMapping("/create")
    public String createActivity(Model model){
        model.addAttribute("activity", new Activity());
        Equipment equipment1 = new Equipment("1", "Handsker", false);
        Equipment equipment2 = new Equipment("2", "Hjelm", false);
        Equipment equipment3 = new Equipment("3", "Dragt", false);
        Equipment equipment4 = new Equipment("4", "Paintball-pistol", false);
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);
        equipmentList.add(equipment4);


        model.addAttribute("equipment", equipmentList);
        return "activities/create";
    }



    @PostMapping("/create")
    public String createActivityToDB(@ModelAttribute Activity activity){
        activityRepo.create(activity);
        return "redirect:/create";
    }

    @GetMapping("update")
    public String updateActivityView(Model model, @RequestParam int id){
        model.addAttribute("activity", activityRepo.read(id));
        return "home/activity/update";
    }

    @PostMapping("update")
    public String updatedActivity(@ModelAttribute("activity") Activity activity) {
        activityRepo.update(activity);
        return "redirect:/update"; // ÆNDRES
    }


    @GetMapping("delete{/id}")
    public String deleteActivity(@RequestParam int id){
        activityRepo.delete(id);
        return "redirect:/list"; // SKAL OGSÅ ÆNDRES NÅR VIEW ER KLAR
    }


    @GetMapping("home")
    public String returnHome(){
        return "home/index";
    }




}
