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
        List<Activity> activitysArray;
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
        Activity activity = new Activity("Sumo","hygge", 170, 18,2500);
        activityRepo.create(activity);
        System.out.println(activity.getId());

        activity.setName("Paintball");
        activity.setHeightLimit(150);
        activity.setAgeLimit(16);
        activity.setDescription("Skyd din makker");
        activity.setPrice(300);
        activityRepo.update(activity);

        System.out.println(activity.toString());
        System.out.println(activityRepo.read(0));
        assertEquals(activity.toString(),activityRepo.read(0).toString());

        //Den returnerer en boolean (false værdi..)
    }

    @Test
    void delete() {
    }
}