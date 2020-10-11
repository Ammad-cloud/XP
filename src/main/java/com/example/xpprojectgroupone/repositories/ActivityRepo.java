/*
USER STORIES: 1, 8, 2, 3

Dette er Data Access Objektet som tilgår databasen både med input og output
Det er et simpelt CRUD setup og data manipulation bliver ikke gjort her

Testklasse: ActivityRepoTest

 */



package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Activity;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
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
    // Returns the auto generated ID
    public int create(Activity model) {
        String sql = "INSERT INTO Activity" + "(name, description, ageLimit, heightLimit, price)VALUES" + "(?,?,?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, model.getName());
            ps.setString(2, model.getDescription());
            ps.setInt(3, model.getAgeLimit());
            ps.setInt(4, model.getHeightLimit());
            ps.setDouble(5, model.getPrice());
            ps.executeUpdate();

            // Getting auto generated ID
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Activity read(int id) {
        Activity activityToReturn = new Activity();
        try {
            PreparedStatement getSingleAccessory = conn.prepareStatement("SELECT * FROM Activity WHERE id=" + id);
            ResultSet rs = getSingleAccessory.executeQuery();
            // If no result is found, we return null
            if(!rs.next()){
                return null;
            }else{
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

    public Activity readFromName(String name){
        Activity activityToReturn = new Activity();
        String sql = "SELECT * FROM Activity WHERE name = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                activityToReturn.setId((rs.getInt(1)));
                activityToReturn.setName(rs.getString(2));
                activityToReturn.setDescription(rs.getString(3));
                activityToReturn.setAgeLimit(rs.getInt(4));
                activityToReturn.setHeightLimit(rs.getInt(5));
                activityToReturn.setPrice(rs.getInt(6));
            }

        }catch (SQLException s){
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