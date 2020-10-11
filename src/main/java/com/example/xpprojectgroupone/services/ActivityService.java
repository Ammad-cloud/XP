/*
USER STORIES: 1, 8, 2, 3

En service klasse til Activity
Klassen skal bruges til at manipulere data og andre specielle funktioner som CRUD ikke kan

 */



package com.example.xpprojectgroupone.services;

import com.example.xpprojectgroupone.repositories.ActivityRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityService {

    ActivityRepo activityRepo;

    public ActivityService() {

        activityRepo = new ActivityRepo();

    }


    public String returnName(int id){

        try{
            return activityRepo.read(id).getName();
        }

        catch (Exception e)
        {
            System.out.println("Does not exist - returnName()");
            return null;
        }

    }


}
