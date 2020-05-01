package com.cabservicegenerator;

public class InvoiceGenerator {
    public static void main(String[] args) {
        System.out.println("Welcome to cab invoice generator");
    }

    private static final int COST_PER_TIME=1;
    private static final double MINIMUM_COST_PER_KILOMETER=10;

    public double calculateFare(double distance,int time) {
        return distance*MINIMUM_COST_PER_KILOMETER+time*COST_PER_TIME;
    }
}
