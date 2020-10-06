package com.example.xpprojectgroupone.controllers;

import com.example.xpprojectgroupone.models.EquipmentType;
import com.example.xpprojectgroupone.repositories.EquipmentTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/equipment_type")
@Controller
public class EquipmentTypeController {

    @Autowired
    EquipmentTypeRepo equipmentTypeRepo;

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("equipmentType", new EquipmentType());
        return "equipmentTypes/create";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute EquipmentType equipmentType){
        equipmentTypeRepo.add(equipmentType);
        return "redirect:/";
    }

}
