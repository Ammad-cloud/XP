package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.services.EquipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentRepoTest {

    Equipment equipment;
    @Autowired(required = true)
    EquipmentService equipmentService;

    @BeforeEach
    void setUp() {
        equipment = new Equipment(0, "gokart", false, 0.0);
    }

    @Test
    void add() {
        equipmentService.add(equipment);
    }
}