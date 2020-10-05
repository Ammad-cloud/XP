package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Activity;
import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.services.EquipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EquipmentRepoTest {

    EquipmentRepo equipmentRepo = new EquipmentRepo();

    Equipment equipment;
    @Autowired()
    EquipmentService equipmentService;

    @BeforeEach
    void setUp() {
        equipment = new Equipment(0, "gokart", false, 0.0);
    }

    @Test
    void add() {
        equipmentService.add(equipment);
    }

    @Test
    void equipmentRepo() {

    }

    @Test
    void create() {
        Equipment equipment = new Equipment();
        equipment.setType("Gokart");
        equipment.setNeedsRepair(true);

        EquipmentRepo.create(equipment);
        assertEquals(equipment.toString(),equipmentRepo.read(1).toString());

}


    @Test
    void read() {
    }

    @Test
    void readAll() {

    }

    @Test
    void update() {
        Equipment equipment = new Equipment();
        equipment = equipmentRepo.read(1);
        equipment.setNeedsRepair(false);
        equipmentRepo.update(equipment);
    }

    @Test
    void delete() {
        equipmentRepo.delete(3);
    }
}