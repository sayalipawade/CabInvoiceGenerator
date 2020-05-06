package com.cabservicegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Ride>> userRides;

    /**
     * Default constructor
     */
    public RideRepository() {
        this.userRides=new HashMap<>();
    }

    /**
     * Function to add ride list
     * @param userId
     * @param rides
     */
    public void addRides(String userId,Ride[] rides){
        this.userRides.put(userId,new ArrayList<>(Arrays.asList(rides)));
    }

    /**
     * Function to get the ride list
     * @param userId
     * @return
     */
    public Ride[] getRide(String userId){
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
