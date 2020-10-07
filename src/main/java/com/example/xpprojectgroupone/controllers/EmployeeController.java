package com.example.xpprojectgroupone.controllers;

import com.example.xpprojectgroupone.models.Employee;
import com.example.xpprojectgroupone.repositories.EmployeeRepo;
import com.example.xpprojectgroupone.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    private EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeController(){
        employeeRepo = new EmployeeRepo();
        employeeService = new EmployeeService();
    }

    @GetMapping("/employeeIndex")
    public String EmployeeList(Model model){
        model.addAttribute("employee", employeeRepo.readAll());
        return "employee/employeeIndex";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model){
        model.addAttribute("addEmployee", new Employee());
        return "employee/addEmployee";
    }

    @PostMapping("addEmployee")
    public String addEmployeeToDB(@ModelAttribute Employee employee){
        employeeRepo.add(employee);
        return "redirect:/employeeIndex";
    }

    @GetMapping("updateEmployee")
    public String updateEmployeeView(Model model, @RequestParam int id){
        model.addAttribute("employee", employeeRepo.read(id));
        return "employee/updateEmployeeView";
    }

    @PostMapping("updatedEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee){
        employeeRepo.update(employee);
        return "redirect:/employeeIndex";
    }

    @GetMapping("deleteEmployee")
    public String deleteEmployee(@RequestParam int id){
        employeeRepo.delete(id);
        return "redirect:/employeeIndex";
    }



}
