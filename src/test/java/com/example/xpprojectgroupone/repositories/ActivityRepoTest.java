/*
USER STORIES: 1, 8, 2, 3

Unit tests til ActivityRepo klassen
Testene er skrevet først derefter blev Repo funktionerne skrevet

 */



package com.example.xpprojectgroupone.repositories;

import com.example.xpprojectgroupone.models.Activity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ActivityRepoTest {

    ActivityRepo activityRepo = new ActivityRepo();

    @Test
    @Description("Testing that readAll() reads all activities")
    void readAll() {
        List<Activity> forLoopArray = new ArrayList<>();
        List<Activity> readAllArray;

        readAllArray = activityRepo.readAll();

        for (int i = 1; i < readAllArray.get(readAllArray.size() - 1).getId() + 1; i++) {
            Activity activity = activityRepo.read(i);
            if(activity != null){
                forLoopArray.add(activity);
            }
        }

        assertEquals(readAllArray.toString(), forLoopArray.toString());
    }

    @Test
    @Description("Testing that create adds the activity as expected")
    void create() {
        String seed = TestHelper.getSeed();

        // Creating an activity
        Activity activity = new Activity();
        activity.setName("Sumo" +  seed);
        activity.setHeightLimit(170);
        activity.setAgeLimit(18);
        activity.setDescription("Hygge");
        activity.setPrice(2500);
        // Adding the activity to the data base
        int id = activityRepo.create(activity);
        activity.setId(id);

        Activity createdActivity = activityRepo.read(id);

        assertEquals(activity.toString(), createdActivity.toString());
    }

    @Test
    @Description("Testing that read can read the activity from the database as expected")
    void read() {
        String seed = TestHelper.getSeed();

        // Creating an activity
        Activity activity = new Activity("Sumo" + seed,"hygge", 170, 18,2500);
        int id = activityRepo.create(activity);
        activity.setId(id);

        Activity readActivity = activityRepo.read(id);

        assertEquals(activity.toString(), readActivity.toString(), "Asserting activity was correctly read from database");
    }

    @Test
    @Description("Testing that update functionality works as expected")
    void update() {
        String seed = TestHelper.getSeed();

        Activity activity = new Activity("Sumo" + seed,"hygge", 170, 18,2500);
        int id = activityRepo.create(activity);
        activity.setId(id);

        activity.setName("Paintball" + seed);
        activity.setHeightLimit(150);
        activity.setAgeLimit(16);
        activity.setDescription("Skyd din makker");
        activity.setPrice(300);
        activityRepo.update(activity);

        assertEquals(activity.toString(), activityRepo.read(id).toString());

    }

    @Test
    @Description("Testing that delete can delete an activity from the database")
    void delete() {
        String seed = TestHelper.getSeed();

        // Creating an activity
        Activity activity = new Activity("Sumo" + seed,"hygge", 170, 18,2500);
        int id = activityRepo.create(activity);
        activity.setId(id);

        // Testing activity was written to database
        Activity writtenActivity = activityRepo.read(id);
        assertEquals(activity.toString(), writtenActivity.toString());

        // Deleting activity
        activityRepo.delete(id);
        writtenActivity = activityRepo.read(id);
        assertNull(writtenActivity, "Asserting activity was deleted from the database");
    }
}