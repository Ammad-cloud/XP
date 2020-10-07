package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Reservation;
import com.example.xpprojectgroupone.utilities.DatabaseConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Repository
public class ReservationRepo {
    private Connection conn;
    @Autowired
    public ReservationRepo(){
        this.conn = DatabaseConnectionManager.getDBConnection();
    }
    @Autowired
    ActivityRepo ar;
    @Autowired
    EmployeeRepo er;

    public ArrayList<Reservation> fetchAll(){
        ArrayList<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Booking";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");
                int customerPhoneNumber = rs.getInt("customerPhoneNumber");
                int activityId = rs.getInt("activityId");
                int instructorId = rs.getInt("instructorId");
                int equipmentId = rs.getInt("equipmentId");
                int equipmentAmount = rs.getInt("equipmentAmount");
                int participants = rs.getInt("participants");
                Reservation reservation = new Reservation(id, startDate, endDate, customerPhoneNumber, activityId, instructorId, equipmentId, equipmentAmount, participants);

                // To display the name of the activity and instructor, we add them here.
                // They are not normally a part of the model
                reservation.setActivityName(ar.read(reservation.getActivityId()).getName());
                String firstName = er.read(reservation.getInstructorId()).getFirstName();
                String lastName = er.read(reservation.getInstructorId()).getLastName();
                reservation.setInstructorName(String.format("%s %s", firstName, lastName));

                reservations.add(reservation);
            }
        } catch(SQLException e){
            throw new IllegalArgumentException("No reservations.");
        }
        return reservations;
    }

    public void add(Reservation reservation) {
        String sql = "INSERT INTO Booking VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, reservation.getStartDate().replace("T", " "));
            ps.setString(2, reservation.getEndDate().replace("T", " "));
            ps.setInt(3, reservation.getCustomerPhoneNumber());
            ps.setInt(4, reservation.getActivityId());
            ps.setInt(5, reservation.getInstructorId());
            ps.setInt(6, reservation.getEquipmentId());
            ps.setInt(7, reservation.getEquipmentAmount());
            ps.setInt(8, reservation.getParticipants());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // NOT WORKING/TESTED
    public void edit(Reservation reservation) {
        String sql = "UPDATE Booking SET startDate = ?, endDate = ?, customerPhoneNumber = ?, activityId = ?, instructorId = ?, equipmentId = ?, equipmentAmount = ?, participants = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, reservation.getStartDate().replace("T", " "));
            ps.setString(2, reservation.getEndDate().replace("T", " "));
            ps.setInt(3, reservation.getCustomerPhoneNumber());
            ps.setInt(4, reservation.getActivityId());
            ps.setInt(5, reservation.getInstructorId());
            ps.setInt(6, reservation.getEquipmentId());
            ps.setInt(7, reservation.getEquipmentAmount());
            ps.setInt(8, reservation.getParticipants());
            ps.setInt(9, reservation.getId());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            if(e instanceof SQLIntegrityConstraintViolationException){
                throw new NullPointerException("Editing failed, try again.");
            }
        }
    }

    // NOT WORKING/TESTED
    public void deleteReservation(Reservation reservation) {
        String sql = "DELETE FROM Booking WHERE id = ?";
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

    public Reservation findById(int id) {
        Reservation reservation = new Reservation();
        String sql = "SELECT * FROM Booking WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                reservation.setId(rs.getInt("id"));
                reservation.setStartDate(rs.getString("startDate"));
                reservation.setEndDate(rs.getString("endDate"));
                reservation.setCustomerPhoneNumber(rs.getInt("customerPhoneNumber"));
                reservation.setActivityId(rs.getInt("activityId"));
                reservation.setInstructorId(rs.getInt("instructorId"));
                reservation.setEquipmentId(rs.getInt("equipmentId"));
                reservation.setEquipmentAmount(rs.getInt("equipmentAmount"));
                reservation.setParticipants(rs.getInt("participants"));
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return reservation;
    }
}
