package com.example.xpprojectgroupone.repositories;


import com.example.xpprojectgroupone.models.Equipment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EquipmentRepo {
    private static List<Equipment> equipmentList = new ArrayList<>();

    public void add(Equipment equipment){
        equipmentList.add(equipment);
    }

}
