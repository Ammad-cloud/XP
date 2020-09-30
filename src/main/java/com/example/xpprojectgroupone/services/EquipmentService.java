package com.example.xpprojectgroupone.services;

import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.repositories.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EquipmentService {
    @Autowired
    EquipmentRepo equipmentRepo;

    public void add(Equipment equipment) {
        equipmentRepo.add(equipment);
    }
}
