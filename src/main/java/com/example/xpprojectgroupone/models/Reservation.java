package com.example.xpprojectgroupone.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

public class Reservation {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private int customerPhoneNumber;
    private int activityId;
    private String activityName;
    int participants;

    public Reservation() {
    }

    public Reservation(int id, Date date, int customerPhoneNumber, int activityId, int participants) {
        this.id = id;
        this.date = date;
        this.customerPhoneNumber = customerPhoneNumber;
        this.activityId = activityId;
        this.participants = participants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
