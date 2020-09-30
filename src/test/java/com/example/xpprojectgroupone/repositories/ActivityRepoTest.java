package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Activity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityRepoTest {

    ActivityRepo activityRepo = new ActivityRepo();

    @Test
    void create() {
        Activity activity = new Activity();
        //activity.setId(1);
        activity.setName("Sumo");
        activity.setHeightLimit(170);
        activity.setAgeLimit(18);
        activity.setDescription("hygge");
        activity.setPrice(2500);
        activityRepo.create(activity);
        assertEquals(activity.toString(),activityRepo.read(1).toString());
    }

    @Test
    void read() {
    }

    @Test
    void readAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}