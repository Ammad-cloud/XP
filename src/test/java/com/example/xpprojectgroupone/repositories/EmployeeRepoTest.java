package com.example.xpprojectgroupone.repositories;


import com.example.xpprojectgroupone.models.Employee;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeRepoTest {

    @Autowired
    EmployeeRepo employeeRepo;

    @Test
    @Description("Testing that an employee can be added to the database")
    void create(){
        String seed = TestHelper.getSeed();
        // Adding an employee
        Employee employee = new Employee(-1, "FirstName" + seed, "LastName" + seed, 1);
        int id = employeeRepo.add(employee);
        employee.setId(id);

        assertEquals(employee.toString(), employeeRepo.read(id).toString());
    }

    @Test
    @Description("Testing that an employee can be edited")
    void edit(){
        String seed = TestHelper.getSeed();
        // Adding an employee
        Employee employee = new Employee(-1, "FirstName" + seed, "LastName" + seed, 1);
        int id = employeeRepo.add(employee);
        employee.setId(id);

        // Editing name of employee
        employee.setFirstName("NewFirstName" + seed);
        employee.setLastName("NewLastName" + seed);
        employeeRepo.update(employee);

        assertEquals(employee.toString(), employeeRepo.read(id).toString());
    }

    @Test
    @Description("Testing that all employees an be read from the database")
    void readAll(){
        List<Employee> readAllList = employeeRepo.readAll();
        List<Employee> forLoopList = new ArrayList<>();

        for(int i = 1; i < readAllList.get(readAllList.size() - 1).getId() + 1; i++){
            Employee employee = employeeRepo.read(i);
            if(employee != null){
                forLoopList.add(employee);
            }
        }
        assertEquals(forLoopList.toString(), readAllList.toString());
    }

    @Test
    @Description("Testing that an employee can be deleted from the database")
    void delete(){
        String seed = TestHelper.getSeed();
        // Adding an employee
        Employee employee = new Employee(-1, "FirstName" + seed, "LastName" + seed, 1);
        int id = employeeRepo.add(employee);
        employee.setId(id);

        // Asserting employee has been added before deleeting
        assertNotNull(employeeRepo.read(id));

        // Deleting employee
        employeeRepo.delete(id);
        assertNull(employeeRepo.read(id));
    }
}
