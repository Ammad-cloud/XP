package com.example.xpprojectgroupone.repositories;

import java.util.Random;

public class TestHelper {

    public static String getSeed(){
        Random rand = new Random(System.currentTimeMillis());
        int seed = rand.nextInt();
        return String.format(" %d", seed);
    }
}
