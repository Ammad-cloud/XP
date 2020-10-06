package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Activity;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ActivityRepo {
    // JDBC driver
    private Connection conn;

    public ActivityRepo() { // try catch
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
    public boolean create(Activity model) {
        try {
            PreparedStatement createActivity = conn.prepareStatement("INSERT INTO Activity" + "(name, description, ageLimit, heightLimit, price)VALUES" + "(?,?,?,?,?);");
            createActivity.setString(1, model.getName());
            createActivity.setString(2, model.getDescription());
            createActivity.setInt(3, model.getAgeLimit());
            createActivity.setInt(4, model.getHeightLimit());
            createActivity.setDouble(5, model.getPrice());


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
            PreparedStatement getSingleAccessory = conn.prepareStatement("SELECT * FROM Activity WHERE id=" + id);
            ResultSet rs = getSingleAccessory.executeQuery();
            while (rs.next()) {
                activityToReturn.setId((rs.getInt(1)));
                activityToReturn.setName(rs.getString(2));
                activityToReturn.setDescription(rs.getString(3));
                activityToReturn.setAgeLimit(rs.getInt(4));
                activityToReturn.setHeightLimit(rs.getInt(5));
                activityToReturn.setPrice(rs.getInt(6));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return activityToReturn;
    }


    public List<Activity> readAll() {
        List<Activity> allActivitys = new ArrayList<Activity>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Activity");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Activity tempActivity = new Activity();
                tempActivity.setId(rs.getInt(1));
                tempActivity.setName(rs.getString(2));
                tempActivity.setDescription(rs.getString(3));
                tempActivity.setAgeLimit(rs.getInt(4));
                tempActivity.setHeightLimit(rs.getInt(5));
                tempActivity.setPrice(rs.getDouble(6));
                allActivitys.add(tempActivity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allActivitys;
    }


    public boolean update(Activity activity) {
        try {
            PreparedStatement myStmt = conn.prepareStatement("UPDATE Activity SET name = ?, description = ?, ageLimit = ?, heightLimit = ?, price = ?  " +
                    "WHERE id =" + activity.getId());
            myStmt.setString(1, activity.getName());
            myStmt.setString(2, activity.getDescription());
            myStmt.setInt(3,activity.getAgeLimit());
            myStmt.setInt(4, activity.getHeightLimit());
            myStmt.setDouble(5, activity.getPrice());


            System.out.println(myStmt);
            myStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean delete(int id) {
        String sql = "DELETE FROM Activity WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Fail");
        }


        return false;

    }
}