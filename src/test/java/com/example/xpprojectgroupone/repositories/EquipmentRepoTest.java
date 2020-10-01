package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Activity;
import com.example.xpprojectgroupone.models.Equipment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentRepoTest {

    EquipmentRepo equipmentRepo = new EquipmentRepo();

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