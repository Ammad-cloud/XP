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
        //activity.setId(1);
        equipment.setType("Sumo");
        equipment.setNeedsRepair(false);

        equipmentRepo().create(equipment);
        assertEquals(equipment.toString(),equipmentRepo.read(1).toString());
    }Activity activity = new Activity();
    //activity.setId(1);
        activity.setName("Sumo");
        activity.setHeightLimit(170);
        activity.setAgeLimit(18);
        activity.setDescription("hygge");
        activity.setPrice(2500);
        activityRepo.create(activity);
    assertEquals(activity.toString(),activityRepo.read(1).toString());
}
    }

    @Test
    void read() {
    }

    @Test
    void readAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}