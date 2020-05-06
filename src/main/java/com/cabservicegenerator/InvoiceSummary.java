package com.cabservicegenerator;

public class InvoiceSummary {

    /**
     * Variables
     */
    private final double totalFare;
    private final int numberOfRides;
    private final double averageFare;

    /**
     * Parameterized constructor
     */
    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numberOfRides;
    }

    /**
     * Object equality method
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        InvoiceSummary that = (InvoiceSummary) object;
        return Double.compare(that.totalFare, totalFare) == 0 &&
                numberOfRides == that.numberOfRides &&
                Double.compare(that.averageFare, averageFare) == 0;
    }
}
