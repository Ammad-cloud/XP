package com.example.xpprojectgroupone.models;

import java.sql.Timestamp;

public class Reservation {
    int id;
    Timestamp date;
    int customerId;
    int activityId;
    int equipmentId;
    int instructorId;
    int participants;

    public Reservation() {
    }

    public Reservation(int id, Timestamp date, int customerId, int activityId, int equipmentId, int instructorId, int participants) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
        this.activityId = activityId;
        this.equipmentId = equipmentId;
        this.instructorId = instructorId;
        this.participants = participants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }
}
