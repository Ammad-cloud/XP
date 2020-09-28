package com.example.xpprojectgroupone.models;

public class Equipment {

    // Fields
    private String id;
    private String type;
    private boolean needsRepair;
    private double price;

    public Equipment(String id, String type, boolean needsRepair, double price) {
        this.id = id;
        this.type = type;
        this.needsRepair = needsRepair;
        this.price = price;
    }

    public Equipment(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNeedsRepair() {
        return needsRepair;
    }

    public void setNeedsRepair(boolean needsRepair) {
        this.needsRepair = needsRepair;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
