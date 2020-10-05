package com.example.xpprojectgroupone.controllers;


import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.models.EquipmentType;
import com.example.xpprojectgroupone.repositories.EquipmentRepo;
import com.example.xpprojectgroupone.repositories.EquipmentTypeRepo;
import com.example.xpprojectgroupone.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = {"/equipment"})
public class EquipmentController {
    @Autowired
    EquipmentRepo equipmentRepo;
    @Autowired
    EquipmentTypeRepo equipmentTypeRepo;

    @GetMapping("/create")
    public String createEquipment(Model model){
        model.addAttribute("equipment", new Equipment());
        model.addAttribute("equipmentTypes", equipmentTypeRepo.fetchAll());
        return "/equipment/create";
    }

    @PostMapping("/create")
    public String addEquipment(@ModelAttribute Equipment equipment, RedirectAttributes redirectAttributes){
        equipmentRepo.add(equipment);
        return "redirect:/equipment/create";
    }

    // Lists all equipment
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("equipmentTypes", equipmentTypeRepo.fetchAll());
        model.addAttribute("equipment", equipmentRepo.readAll());
        return "/equipment/list";
    }

    // Lists only the selected equipment
    @PostMapping("/list")
    public String listOne(@ModelAttribute EquipmentType equipmentType, Model model){
        model.addAttribute("equipment", equipmentRepo.readAllByType(equipmentType.getType()));
        model.addAttribute("equipmentTypes", equipmentTypeRepo.fetchAll());
        return "/equipment/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("equipmentTypes", equipmentTypeRepo.fetchAll());
        model.addAttribute("equipment", equipmentRepo.read(id));
        return "/equipment/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Equipment equipment){
        equipmentRepo.update(equipment);
        return "redirect:/equipment/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        equipmentRepo.delete(id);
        return "redirect:/equipment/list";
    }

    @GetMapping("/gokart/list")
    public String manageEquipment(Model model) {
        model.addAttribute("viewEquipment", equipmentRepo.readGokart());
        return "home/Equipment/manageGokarts";
    }

    @GetMapping("/sumo/list")
    public String manageSumo(Model model) {
        model.addAttribute("viewEquipment", equipmentRepo.readSumo());
        return "home/Equipment/manageSumo";
    }

    @GetMapping("/paintball/list")
    public String managePaintball(Model model) {
        model.addAttribute("viewEquipment", equipmentRepo.readPaintball());
        return "home/Equipment/manageSumo";
    }

}
