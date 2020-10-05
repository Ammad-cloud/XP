package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.DBManager.DBManager;
import com.example.xpprojectgroupone.models.Reservation;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class ReservationRepo {

    DBManager dbManager = new DBManager();

    public ArrayList<Reservation> getAllReservations(){
        ArrayList<Reservation> resArray = new ArrayList<>();
        try{
            Connection connection = DBManager.getConnection();
            String sql = "SELECT * FROM reservation"; //todo BOOKING???
            PreparedStatement prepStatement = connection.prepareStatement(sql);
            ResultSet rs = prepStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String idfk = rs.getString("idfk");
                Reservation reservation = new Reservation(id, idfk);
                resArray.add(reservation);
            }
            return resArray;
        } catch(SQLException e){
            throw new IllegalArgumentException("No reservations.");
        }
    }

    public void createReservation(Reservation reservation) {
        try {
            Connection connection = DBManager.getConnection();
            String sql = "INSERT INTO reservation VALUES(default, ?, ?)";
            PreparedStatement prepStatement = connection.prepareStatement(sql);
            prepStatement.setInt(1, reservation.getId());
            prepStatement.setString(2, reservation.getIdfk());
            prepStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editReservation(Reservation reservation) {
        try {
            Connection connection = DBManager.getConnection();
            String sql = "UPDATE reservation SET column1 = 1, column2 = 2 WHERE id=?";

            PreparedStatement prepStatement = connection.prepareStatement(sql);
            prepStatement.setString(1, reservation.getIdfk());
            prepStatement.setInt(2, reservation.getId());
            prepStatement.executeUpdate();
        }catch(SQLException e){
            if(e instanceof SQLIntegrityConstraintViolationException){
                throw new NullPointerException("Editing failed, try again.");
            }
        }
    }

    public void deleteReservation(Reservation reservation) {
        try {
            Connection connection = DBManager.getConnection();
            String sql = "DELETE FROM reservation WHERE id = ?";
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
