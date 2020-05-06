package com.cabservicegenerator;

public class InvoiceGenerator {

    /**
     * Constants
     */
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to cab invoice generator");
    }

    /**
     * Object of RideRepository
     */
    RideRepository rideRepository = new RideRepository();

    /**
     * Method to set the ride
     * @param rideRepository
     */
    public void setRideRepository(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }


    /**
     * Method to calculate total fare
     */
    public double calculateFare(double distance,int time) {
        double totalFare= distance*MINIMUM_COST_PER_KILOMETER+time*COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     * Method to get total fare
     * @param rides
     * @return
     */
    public InvoiceSummary getTotalFare(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride:rides)
            totalFare += ride.cabRide.calculateCostOfRide(ride);
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * method to add user rides
     * @param userId
     * @param rides
     */
    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);
    }

    /**
     *  Function to Get Summary By UserId.
     * @param userId
     * @return
     */
    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.getTotalFare(rideRepository.getRide(userId));
    }
}
