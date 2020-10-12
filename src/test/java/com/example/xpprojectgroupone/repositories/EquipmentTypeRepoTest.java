package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.EquipmentType;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class EquipmentTypeRepoTest {

    @Autowired
    EquipmentTypeRepo equipmentTypeRepo;

    @Test
    @Description("Testing that an equipment type can be added. Read is also tested")
    void create(){
        String seed = TestHelper.getSeed();
        // Creating an equipment type
        EquipmentType equipmentType = new EquipmentType("Bat" + seed);
        equipmentTypeRepo.add(equipmentType);

        assertEquals(equipmentType.toString(), equipmentTypeRepo.read("Bat" + seed).toString());
    }
}
