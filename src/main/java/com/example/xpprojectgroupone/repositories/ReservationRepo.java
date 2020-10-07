package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Reservation;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ReservationRepo {
    private Connection conn;
    @Autowired
    public ReservationRepo(){
        this.conn = DatabaseConnectionManager.getDBConnection();
    }
    @Autowired
    ActivityRepo ar;

    public ArrayList<Reservation> fetchAll(){
        ArrayList<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Booking";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("date");
                int customerPhoneNumber = rs.getInt("customerPhoneNumber");
                int activityId = rs.getInt("activityId");
                int equipmentId = rs.getInt("equipmentId");
                int equipmentAmount = rs.getInt("equipmentAmount");
                int participants = rs.getInt("participants");
                Reservation reservation = new Reservation(id, date, customerPhoneNumber, activityId, equipmentId, equipmentAmount, participants);
                reservation.setActivityName(ar.read(reservation.getActivityId()).getName());
                reservations.add(reservation);
            }
        } catch(SQLException e){
            throw new IllegalArgumentException("No reservations.");
        }
        return reservations;
    }

    public void add(Reservation reservation) {
        String sql = "INSERT INTO Booking VALUES(default, ?, ?, ?, ?, ?, ?)";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, reservation.getDate().replace("T", " "));
            ps.setInt(2, reservation.getCustomerPhoneNumber());
            ps.setInt(3, reservation.getActivityId());
            ps.setInt(4, reservation.getEquipmentId());
            ps.setInt(5, reservation.getEquipmentAmount());
            ps.setInt(6, reservation.getParticipants());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // NOT WORKING/TESTED
    public void editReservation(Reservation reservation) {
        String sql = "UPDATE booking SET customerPhoneNumber = ?, activityId = ?, equipemntId = ?, instructorId = ?, participants = ? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reservation.getCustomerPhoneNumber());
            ps.setInt(2, reservation.getActivityId());
            ps.setInt(5, reservation.getParticipants());
            ps.setInt(6, reservation.getId());
            ps.executeUpdate();
        }catch(SQLException e){
            if(e instanceof SQLIntegrityConstraintViolationException){
                throw new NullPointerException("Editing failed, try again.");
            }
        }
    }

    // NOT WORKING/TESTED
    public void deleteReservation(Reservation reservation) {
        String sql = "DELETE FROM booking WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reservation.getId());
            ps.executeUpdate();
        }catch(SQLException e){
            if(e instanceof SQLIntegrityConstraintViolationException){
                System.out.println(e);
            }
        }
    }
}
