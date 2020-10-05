package com.example.xpprojectgroupone.models;

public class Reservation {
    int id;
    String idfk;
    //isn't this just booking or what the heck


    public Reservation(int id, String idfk) {
        this.id = id;
        this.idfk = idfk;
    }

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdfk() {
        return idfk;
    }

    public void setIdfk(String idfk) {
        this.idfk = idfk;
    }
}
