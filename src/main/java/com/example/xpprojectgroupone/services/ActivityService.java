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
