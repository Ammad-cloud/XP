package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Activity;
import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.models.EquipmentType;
import com.example.xpprojectgroupone.services.EquipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EquipmentRepoTest {
    Equipment equipment;
    @Autowired()
    EquipmentRepo equipmentRepo;
    @Autowired
    EquipmentTypeRepo equipmentTypeRepo;


    // readAllByType is also tested here
    @Test
    void create() {
        Random rand = new Random(System.currentTimeMillis());
        int seed = rand.nextInt();
        // Adding equipment type
        String eqtString = "TestEqType" + seed;
        EquipmentType eqt = new EquipmentType(eqtString);
        equipmentTypeRepo.add(eqt);

        // Adding equipment
        Equipment eq = new Equipment();
        eq.setType(eqtString);
        eq.setNeedsRepair(true);
        equipmentRepo.add(eq);

        // Reading equipment from database and asserting it was correctly added
        List<Equipment> equipmentList = equipmentRepo.readAllByType(eqtString);
        assertEquals(eq.toString(), equipmentList.get(0).toString());
}


    @Test
    void read() {
        Random rand = new Random(System.currentTimeMillis());
        int seed = rand.nextInt();
        // Adding equipment type
        String eqtString = "TestEqType" + seed;
        EquipmentType eqt = new EquipmentType(eqtString);
        equipmentTypeRepo.add(eqt);

        // Adding equipment
        Equipment eq = new Equipment();
        eq.setType(eqtString);
        eq.setNeedsRepair(true);
        int id = equipmentRepo.add(eq);

        assertEquals(eq.toString(), equipmentRepo.read(id).toString(), "Asserting equipment was correctly read from database");
    }

    @Test
    void readAll() {
        Random rand = new Random(System.currentTimeMillis());
        int seed = rand.nextInt();
        // Adding equipment type
        String eqtString = "TestEqType" + seed;
        EquipmentType eqt = new EquipmentType(eqtString);
        equipmentTypeRepo.add(eqt);

        // Adding equipment
        Equipment eq = new Equipment();
        eq.setType(eqtString);
        eq.setNeedsRepair(true);
        int id1 = equipmentRepo.add(eq);
        eq.setNeedsRepair(false);
        int id2 = equipmentRepo.add(eq);

        List<Equipment> equipmentList = equipmentRepo.readAll();
        // It is impossible to test for unknown values. Testing read all does not return empty list
        assertTrue(equipmentList.size() > 0);
    }

    @Test
    void update() {
        Random rand = new Random(System.currentTimeMillis());
        int seed = rand.nextInt();
        // Adding equipment type
        String eqtString = "TestEqType" + seed;
        EquipmentType eqt = new EquipmentType(eqtString);
        equipmentTypeRepo.add(eqt);

        // Adding equipment
        Equipment eq = new Equipment();
        eq.setType(eqtString);
        eq.setNeedsRepair(true);
        equipmentRepo.add(eq);

        // Reading equipment from database and asserting it was correctly added
        List<Equipment> equipmentList = equipmentRepo.readAllByType(eqtString);
        assertEquals(eq.toString(), equipmentList.get(0).toString());
        eq.setId(equipmentList.get(0).getId());

        // Updating equipment repair status
        eq.setNeedsRepair(false);
        equipmentRepo.update(eq);
        // Asserting equipment was updated
        equipmentList = equipmentRepo.readAllByType(eqtString);
        assertEquals(eq.toString(), equipmentList.get(0).toString());
    }

    @Test
    void delete() throws InterruptedException {
        Thread.sleep(100);
        Random rand = new Random(System.currentTimeMillis());
        int seed = rand.nextInt();
        String eqtString = "TestEqType" + seed;
        System.out.println(eqtString);
        EquipmentType eqt = new EquipmentType(eqtString);
        equipmentTypeRepo.add(eqt);

        Equipment eq = new Equipment();
        eq.setType(eqtString);
        eq.setNeedsRepair(true);

        // Asserting equipment was added
        equipmentRepo.add(eq);
        List<Equipment> equipmentList = equipmentRepo.readAllByType(eqtString);
        assertEquals(eq.toString(), equipmentList.get(0).toString());

        // Deleting equipment
        equipmentRepo.delete(equipmentList.get(0).getId());
        equipmentList = equipmentRepo.readAllByType(eqtString);
        assertEquals(0, equipmentList.size());
    }
}