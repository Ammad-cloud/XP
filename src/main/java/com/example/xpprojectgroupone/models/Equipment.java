package com.example.xpprojectgroupone.models;

public class Equipment {

    // Fields
    private int id;
    private String type;
    private boolean needsRepair;

    // Constructor
    public Equipment(int id, String type, boolean needsRepair) {
        this.id = id;
        this.type = type;
        this.needsRepair = needsRepair;
    }

    public Equipment() {

    }

    // Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isNeedsRepair() {
        return needsRepair;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNeedsRepair(boolean needsRepair) {
        this.needsRepair = needsRepair;
    }

    public String toString() {
        return " Type " + type + " Needs repair " + needsRepair;
    }
}
