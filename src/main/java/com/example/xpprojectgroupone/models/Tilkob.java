package com.example.xpprojectgroupone.models;

import java.util.ArrayList;

public class Tilkob {
    private String type;
    private double price;
    private double number;
    ArrayList<Tilkob> items = new ArrayList<>();

    public Tilkob(String type, double price) {
        this.type = type;
        this.price = price;


    }


    public Tilkob() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return type + " " + price + "kr";
    }

    public double getTotalPrice() {
        return price * number;
    }


}
