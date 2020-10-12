package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.models.EquipmentType;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EquipmentTypeRepo {
    private Connection conn;

    public EquipmentTypeRepo(){
        this.conn = DatabaseConnectionManager.getDBConnection();
    }

    public boolean add(EquipmentType equipmentType){
        String sql = "INSERT INTO EquipmentTypes VALUES (?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, equipmentType.getType());
            ps.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public List<EquipmentType> fetchAll(){
        List<EquipmentType> equipmentTypes = new ArrayList<EquipmentType>();
        String sql = "SELECT * FROM EquipmentTypes;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EquipmentType tempEquipmentType = new EquipmentType();
                tempEquipmentType.setType(rs.getString(1));

                equipmentTypes.add(tempEquipmentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipmentTypes;
    }

    public EquipmentType read(String type){
        String sql = "SELECT * FROM EquipmentTypes WHERE equipmentType = ?";
        EquipmentType equipmentTypeToReturn = new EquipmentType();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                equipmentTypeToReturn.setType(rs.getString(1));
            } else{
                return null;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return equipmentTypeToReturn;
    }

}
