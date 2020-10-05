package com.example.xpprojectgroupone.controllers;

import com.example.xpprojectgroupone.models.Activity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/activities"})
public class ActivityController {

    @GetMapping("/list")
    public String index(Model model){
        List<Activity> activities = new ArrayList<>();
        Activity activity = new Activity(1, "Fodbold", "spark til en bold", 1, 180, 18, 300);
        activities.add(activity);
        model.addAttribute("activity", activities);
        return "activities/list";
    }
}
