package com.example.xpprojectgroupone.models;

public class Equipment {

    // Fields
    private String id;
    private String type;
    private boolean needsRepair;

    // Constructor
    public Equipment(String id, String type, boolean needsRepair) {
        this.id = id;
        this.type = type;
        this.needsRepair = needsRepair;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isNeedsRepair() {
        return needsRepair;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNeedsRepair(boolean needsRepair) {
        this.needsRepair = needsRepair;
    }
}
