package com.example.xpprojectgroupone.repositories;


import com.example.xpprojectgroupone.models.Equipment;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




@Repository
public class EquipmentRepo {
    // JDBC driver


    private static Connection conn;

    public EquipmentRepo() {
        this.conn = DatabaseConnectionManager.getDBConnection();
    }

    // create
    // read
    // update
    // delete
/*
    id int auto_increment,
    name varchar(40) not null,
    description varchar(255) not null,
    ageLimit int not null,
    heightLimit int not null,
    price double not null,
    constraint Activity_pk
 */
    public static boolean create(Equipment model) {
        try {
            PreparedStatement createEquipment = conn.prepareStatement("INSERT INTO Equipment" + "(equipmenttypes, needsRepair)VALUES" + "(?,?);");
            //createEquipment.setInt(1, model.getId());
            createEquipment.setString(1, model.getType());
            createEquipment.setBoolean(2, model.isNeedsRepair());
            createEquipment.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Equipment read(int id) {
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
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Equipment WHERE equipmenttypes = \"Gokart\" ORDER BY needsRepair DESC;");
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
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Equipment WHERE equipmenttypes = \"Sumo\" ORDER BY needsRepair DESC;");
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
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Equipment WHERE equipmenttypes = \"Paintball\" ORDER BY needsRepair DESC;");
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

                allEquipment.add(tempEquipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEquipment;
    }


    public boolean update(Equipment equipment) {
        try {
            PreparedStatement myStmt = conn.prepareStatement("UPDATE Equipment SET id = ?, equipmenttypes = ?, needsRepair = ?" + " " +
                    "WHERE id =" + equipment.getId());
            myStmt.setInt(1, equipment.getId());
            myStmt.setString(2, equipment.getType());
            myStmt.setBoolean(3, equipment.isNeedsRepair());



            System.out.println(myStmt);
            myStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean delete(int id) {
        String sql = "DELETE FROM Equipment WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Success");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Fail");

        return false;
    }
}

