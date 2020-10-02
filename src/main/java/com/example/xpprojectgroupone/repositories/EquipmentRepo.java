package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EquipmentRepo {
    private Connection conn;
    @Autowired
    JdbcTemplate template;

    public EquipmentRepo(){
        this.conn = DatabaseConnectionManager.getDBConnection();
    }


    private static List<Equipment> equipmentList = new ArrayList<>();

    public void add(Equipment equipment) {
        String sql = "INSERT INTO Equipment VALUES (0, ?, ?, ?)";
        template.update(sql, equipment.getType(), equipment.isNeedsRepair(), equipment.getPrice());
        /*try {
            System.out.println("Equipment repo add running");
            PreparedStatement myStmt = conn.prepareStatement("");
            myStmt.setInt(1, equipment.getId());
            myStmt.setString(2, equipment.getType());
            myStmt.setBoolean(3, equipment.isNeedsRepair());
            myStmt.setDouble(4, equipment.getPrice());
            System.out.println("Connection: " + myStmt.getConnection());
        } catch (SQLException e){
            System.out.println("Equipment error " + e);
        }*/

    }

}
