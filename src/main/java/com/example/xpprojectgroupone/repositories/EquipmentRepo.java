package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    /*public void add(Equipment equipment) {
        String sql = "INSERT INTO Equipment VALUES (0, ?, ?, ?)";
        template.update(sql, equipment.getType(), equipment.isNeedsRepair());
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
        }

    }*/
    public boolean add(Equipment equipment) {
        try {
            PreparedStatement createEquipment = conn.prepareStatement("INSERT INTO Equipment (equipmentType, needsRepair) VALUES (?, ?);");
            //createEquipment.setInt(1, 0);
            createEquipment.setString(1, equipment.getType());
            createEquipment.setBoolean(2, equipment.isNeedsRepair());
            createEquipment.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Equipment read(int id) {
        Equipment equipmentToReturn = new Equipment();
        try {
            PreparedStatement getSingleAccessory = conn.prepareStatement("SELECT * FROM Equipment WHERE id=" + id);
            ResultSet rs = getSingleAccessory.executeQuery();
            while (rs.next()) {
                equipmentToReturn.setId((rs.getInt(1)));
                equipmentToReturn.setType(rs.getString(2));
                equipmentToReturn.setNeedsRepair(rs.getBoolean(3));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return equipmentToReturn;
    }


    public List<Equipment> readGokart() {
        List<Equipment> allEquipment = new ArrayList<Equipment>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Equipment WHERE equipmentType = \"Gokart\" ORDER BY needsRepair DESC;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Equipment tempEquipment = new Equipment();
                tempEquipment.setId(rs.getInt(1));
                tempEquipment.setType(rs.getString(2));
                tempEquipment.setNeedsRepair(rs.getBoolean(3));

                allEquipment.add(tempEquipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEquipment;
    }

    public List<Equipment> readSumo() {
        List<Equipment> allEquipment = new ArrayList<Equipment>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Equipment WHERE equipmentType = \"Sumo\" ORDER BY needsRepair DESC;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Equipment tempEquipment = new Equipment();
                tempEquipment.setId(rs.getInt(1));
                tempEquipment.setType(rs.getString(2));
                tempEquipment.setNeedsRepair(rs.getBoolean(3));

                allEquipment.add(tempEquipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEquipment;
    }

    public List<Equipment> readPaintball() {
        List<Equipment> allEquipment = new ArrayList<Equipment>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Equipment WHERE equipmentType = \"Paintball\" ORDER BY needsRepair DESC;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Equipment tempEquipment = new Equipment();
                tempEquipment.setId(rs.getInt(1));
                tempEquipment.setType(rs.getString(2));
                tempEquipment.setNeedsRepair(rs.getBoolean(3));

                allEquipment.add(tempEquipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEquipment;
    }

    public List<Equipment> readAll() {
        List<Equipment> allEquipment = new ArrayList<Equipment>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Equipment");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Equipment tempEquipment = new Equipment();
                tempEquipment.setId(rs.getInt(1));
                tempEquipment.setType(rs.getString(2));
                tempEquipment.setNeedsRepair(rs.getBoolean(3));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEquipment;
    }

    public boolean update(Equipment equipment) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Equipment SET id = ?, equipmentType = ?, needsRepair = ?" + " " +
                    "WHERE id = " + equipment.getId());
            ps.setInt(1, equipment.getId());
            ps.setString(2, equipment.getType());
            ps.setBoolean(3, equipment.isNeedsRepair());

            ps.executeUpdate();
            return true;
        } catch(SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Equipment WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch(SQLException e) {
            System.out.println(e);
        }
        return false;
    }

}
