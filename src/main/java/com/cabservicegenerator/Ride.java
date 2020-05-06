package com.cabservicegenerator;

public class Ride {

    /**
     * Variables
     */
    public final double distance;
    public final int time;
    public final CabRide cabRide;

    /**
     * Parameterized constructor
     * @param ride
     * @param distance
     * @param time
     */
    public Ride(CabRide ride,double distance, int time) {
        this.cabRide=ride;
        this.distance = distance;
        this.time = time;
    }
}
