package com.example.xpprojectgroupone.services;

import com.example.xpprojectgroupone.repositories.EmployeeRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    EmployeeRepo employeeRepo;

    public EmployeeService() {

        employeeRepo = new EmployeeRepo();

    }

}
