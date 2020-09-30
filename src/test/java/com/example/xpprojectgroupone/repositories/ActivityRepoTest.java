package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Activity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<Activity> activitysArray = new ArrayList<>();
        activitysArray = activityRepo.readAll();

        List<Activity> testArray = new ArrayList<>();

        for (int i = 1; i < activitysArray.size() + 1; i++) {
            testArray.add(activityRepo.read(i));
        }
        System.out.println(activitysArray.size());
        System.out.println(testArray.size());
        assertEquals(activitysArray.toString(), testArray.toString());

    }

    @Test
    void update() {
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
    void delete() {
    }
}