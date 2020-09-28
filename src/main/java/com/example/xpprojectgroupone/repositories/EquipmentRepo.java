package com.example.xpprojectgroupone.repositories;


import com.example.xpprojectgroupone.models.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EquipmentRepo {
    @Autowired
    JdbcTemplate template;

    private static List<Equipment> equipmentList = new ArrayList<>();

    public void add(Equipment equipment){
        String sql = "INSERT INTO equipment VALUES (?, ?, ?, ?)";
        template.update(sql, equipment.getId(), equipment.getType(), equipment.isNeedsRepair(), "null");
        equipmentList.add(equipment);
    }

}
