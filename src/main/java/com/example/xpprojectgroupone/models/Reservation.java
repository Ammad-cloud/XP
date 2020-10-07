package com.example.xpprojectgroupone.models;

public class Reservation {
    private int id;
    //@DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm")
    private String startDate;
    private String endDate;
    private int customerPhoneNumber;
    private int activityId;
    private int instructorId;
    private int equipmentId;
    private int equipmentAmount;
    private int participants;

    private String activityName; // Used for listing reservation
    private String instructorName; // Used for listing reservation

    public Reservation() {
    }

    public Reservation(int id, String startDate, String endDate, int customerPhoneNumber, int activityId, int instructorId, int equipmentID, int equipmentAmount, int participants) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerPhoneNumber = customerPhoneNumber;
        this.activityId = activityId;
        this.instructorId = instructorId;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
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
        return Integer.parseInt(this.startDate.substring(5, 7));
    }

    public int getDay(){
        return Integer.parseInt(this.startDate.substring(8, 10));
    }
}
