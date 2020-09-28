package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityRepo {

    // JDBC driver
    private Connection conn;
    /*
    public AccessoryRepository()  { // try catch
        this.conn = DatabaseConnectionManager.getDBConnection();
    }
     */

    // create
    // read
    // update
    // delete

    public boolean create(Activity model) {
        try {
            PreparedStatement createActivity = conn.prepareStatement("INSERT INTO Activity" + "(Name,Description, EquipmentId, AgeLimit, HeightLimit, Price)VALUES" + "(?,?);");
            createActivity.setString(1, model.getName());
            createActivity.setString(2, model.getDescription());
            createActivity.setInt(3, model.getEquipmentId());
            createActivity.setInt(4, model.getAgeLimit());
            createActivity.setInt(5, model.getHeightLimit());
            createActivity.setDouble(6, model.getPrice());


            createActivity.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Activity read(int id) {
        Activity activityToReturn = new Activity();
        try {
            PreparedStatement getSingleAccessory = conn.prepareStatement("SELECT * FROM Activity WHERE Activity_id=" + id);
            ResultSet rs = getSingleAccessory.executeQuery();
            while (rs.next()) {
                activityToReturn.setId((rs.getInt(1)));
                activityToReturn.setName(rs.getString(2));
                activityToReturn.setDescription(rs.getString(3));
                activityToReturn.setEquipmentId(rs.getInt(4));
                activityToReturn.setAgeLimit(rs.getInt(5));
                activityToReturn.setHeightLimit(rs.getInt(6));
                activityToReturn.setPrice(rs.getInt(7));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return activityToReturn;
    }


    public List<Activity> readAll() {
        List<Activity> allActivitys = new ArrayList<Activity>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM accessories");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Activity tempActivity = new Activity();
                tempActivity.setId(rs.getInt(1));
                tempActivity.setName(rs.getString(2));
                tempActivity.setDescription(rs.getString(3));
                tempActivity.setEquipmentId(rs.getInt(4));
                tempActivity.setAgeLimit(rs.getInt(5));
                tempActivity.setHeightLimit(rs.getInt(6));
                tempActivity.setPrice(rs.getDouble(7));
                allActivitys.add(tempActivity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allActivitys;
    }


    public boolean update(Activity activity) {
        try {
            PreparedStatement myStmt = conn.prepareStatement("UPDATE Activity SET activityId = ?, Name = ?, Description = ?, EquipmentId = ?, AgeLimit = ?, HeighLimit = ?, Price = ?  " +
                    "WHERE activityId =" + activity.getId());
            myStmt.setInt(1, activity.getId());
            myStmt.setString(2, activity.getName());
            myStmt.setString(3, activity.getDescription());
            myStmt.setInt(4,activity.getEquipmentId());
            myStmt.setInt(5,activity.getAgeLimit());
            myStmt.setInt(6, activity.getHeightLimit());
            myStmt.setDouble(7, activity.getPrice());


            System.out.println(myStmt);
            myStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean delete(int id) {
        String sql = "DELETE FROM Activity WHERE ActivityId = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Fail");

        return false;

    }
}