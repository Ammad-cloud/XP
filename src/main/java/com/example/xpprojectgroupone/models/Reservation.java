package com.example.xpprojectgroupone.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class Reservation {
    private int id;
    //@DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm")
    private String date;
    private int customerPhoneNumber;
    private int activityId;
    private String activityName; // Used for listing reservation
    private int participants;
    private int equipmentId;
    private int equipmentAmount;

    public Reservation() {
    }

    public Reservation(int id, String date, int customerPhoneNumber, int activityId, int equipmentID, int equipmentAmount, int participants) {
        this.id = id;
        this.date = date;
        this.customerPhoneNumber = customerPhoneNumber;
        this.activityId = activityId;
        this.equipmentId = equipmentID;
        this.equipmentAmount = equipmentAmount;
        this.participants = participants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(int customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getEquipmentAmount() {
        return equipmentAmount;
    }

    public void setEquipmentAmount(int equipmentAmount) {
        this.equipmentAmount = equipmentAmount;
    }

    public int getMonth(){
        return Integer.parseInt(this.date.substring(5, 7));
    }

    public int getDay(){
        return Integer.parseInt(this.date.substring(8, 10));
    }
}
