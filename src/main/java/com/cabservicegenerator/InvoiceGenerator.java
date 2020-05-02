package com.cabservicegenerator;

public class InvoiceGenerator {

    /**main method*/
    public static void main(String[] args) {
        System.out.println("Welcome to cab invoice generator");
    }

    /**Constants*/
    private static final int COST_PER_TIME=1;
    private static final double MINIMUM_COST_PER_KILOMETER=10;

    /**Method to calculate total fare*/
    public double calculateFare(double distance,int time) {
        return distance*MINIMUM_COST_PER_KILOMETER+time*COST_PER_TIME;
    }

    /**Method to calculate total fare for multiple rides*/
    public double calculateFare(Ride[] rides) {
        double totalFare=0;
        for(Ride ride:rides) {
            totalFare+=this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
