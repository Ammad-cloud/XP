package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Reservation;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class ReservationRepo {

    public ArrayList<Reservation> getAllReservations(){
        ArrayList<Reservation> resArray = new ArrayList<>();
        try{
            Connection connection = DatabaseConnectionManager.getDBConnection();
            String sql = "SELECT * FROM booking";
            PreparedStatement prepStatement = connection.prepareStatement(sql);
            ResultSet rs = prepStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Timestamp date = rs.getTimestamp("dateTime");
                int customerId = rs.getInt("customerId");
                int actitivityId = rs.getInt("activityId");
                int equipmentId = rs.getInt("equipmentId");
                int instructorId = rs.getInt("isntructorId");
                int participants = rs.getInt("participants");
                Reservation reservation = new Reservation(id, date, customerId, actitivityId, equipmentId, instructorId, participants);
                resArray.add(reservation);
            }
            return resArray;
        } catch(SQLException e){
            throw new IllegalArgumentException("No reservations.");
        }
    }

    public void createReservation(Reservation reservation) {
        try {
            Connection connection = DatabaseConnectionManager.getDBConnection();
            String sql = "INSERT INTO booking VALUES(default, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prepStatement = connection.prepareStatement(sql);
            prepStatement.setInt(1, reservation.getId());
            prepStatement.setTimestamp(2, reservation.getDate());
            prepStatement.setInt(3, reservation.getCustomerId());
            prepStatement.setInt(3, reservation.getActivityId());
            prepStatement.setInt(3, reservation.getEquipmentId());
            prepStatement.setInt(3, reservation.getInstructorId());
            prepStatement.setInt(3, reservation.getParticipants());
            prepStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editReservation(Reservation reservation) {
        try {
            Connection connection = DatabaseConnectionManager.getDBConnection();
            String sql = "UPDATE booking SET customerId = ?, activityId = ?, equipemntId = ?, instructorId = ?, participants = ? WHERE id=?";

            PreparedStatement prepStatement = connection.prepareStatement(sql);
            prepStatement.setInt(1, reservation.getCustomerId());
            prepStatement.setInt(2, reservation.getActivityId());
            prepStatement.setInt(3, reservation.getEquipmentId());
            prepStatement.setInt(4, reservation.getInstructorId());
            prepStatement.setInt(5, reservation.getParticipants());
            prepStatement.setInt(6, reservation.getId());
            prepStatement.executeUpdate();
        }catch(SQLException e){
            if(e instanceof SQLIntegrityConstraintViolationException){
                throw new NullPointerException("Editing failed, try again.");
            }
        }
    }

    public void deleteReservation(Reservation reservation) {
        try {
            Connection connection = DatabaseConnectionManager.getDBConnection();
            String sql = "DELETE FROM booking WHERE id = ?";
            PreparedStatement prepStatement = connection.prepareStatement(sql);
            prepStatement.setInt(1, reservation.getId());
            prepStatement.executeUpdate();
        }catch(SQLException e){
            if(e instanceof SQLIntegrityConstraintViolationException){
                System.out.println(e);
            }
        }
    }
}
