package com.cabservicegenerator;

/**
 * Enum for cab ride
 */
public enum CabRide {
    NORMAL(10.0,1.0,5.0),
    PREMIUM(15.0,2.0,20.0);

    /**
     * Variables
     */
    private final double rsPerKilometer;
    private final double rsPerMinute;
    private final double minFarePerRide;

    /**
     * Parameterized constructor
     * @param costPerKilometer
     * @param costPerMinute
     * @param minFarePerRide
     */
    CabRide(double costPerKilometer, double costPerMinute, double minFarePerRide) {
        this.rsPerKilometer = costPerKilometer;
        this.rsPerMinute = costPerMinute;
        this.minFarePerRide = minFarePerRide;
    }

    /**
     * Function to calculate cost of ride
     * @param ride
     * @return
     */
    public double calculateCostOfRide(Ride ride) {
        double rideCost = ride.distance * rsPerKilometer + ride.time * rsPerMinute;
        return Math.max(rideCost, minFarePerRide);
    }
}
