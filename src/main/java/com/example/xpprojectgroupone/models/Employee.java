package com.example.xpprojectgroupone.models;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int activityId;

    public Employee(){
    }

    public Employee(int id, String firstName, String lastName, int activityId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", activityId=" + activityId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
}
