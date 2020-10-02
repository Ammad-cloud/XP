package com.example.xpprojectgroupone.repositories;


import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EquipmentRepo {
    private Connection conn;

    public EquipmentRepo(){
        this.conn = DatabaseConnectionManager.getDBConnection();
    }


    private static List<Equipment> equipmentList = new ArrayList<>();

    public void add(Equipment equipment) {
        try {
            PreparedStatement myStmt = conn.prepareStatement("INSERT INTO equipment VALUES (?, ?, ?, ?)");
            myStmt.setInt(1, equipment.getId());
            myStmt.setString(2, equipment.getType());
            myStmt.setBoolean(3, equipment.isNeedsRepair());
            myStmt.setDouble(4, equipment.getPrice());
        } catch (SQLException e){
            System.out.println("Equipment error " + e);
        }

    }

}
