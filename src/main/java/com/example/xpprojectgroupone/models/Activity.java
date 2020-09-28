package com.example.xpprojectgroupone.models;

public class Activity {

    int id;
    String name;
    String description;
    int equipmentId;
    int ageLimit;
    int heightLimit;
    double price;

    public Activity() {
    }

    public Activity(int id, String name, String description, int equipmentId, int ageLimit, int heightLimit, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.equipmentId = equipmentId;
        this.ageLimit = ageLimit;
        this.heightLimit = heightLimit;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getHeightLimit() {
        return heightLimit;
    }

    public void setHeightLimit(int heightLimit) {
        this.heightLimit = heightLimit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
