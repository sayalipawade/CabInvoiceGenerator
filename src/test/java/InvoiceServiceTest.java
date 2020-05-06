import com.cabservicegenerator.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

    /**
     * Variables
     */
    private InvoiceGenerator generator;
    private RideRepository rideRepository;
    private Ride[] rides = null;
    InvoiceSummary expectedInvoice;

    /**
     * Method for initialization
     */
    @Before
    public void initialization() {
        generator = new InvoiceGenerator();
        rideRepository = new RideRepository();
        generator.setRideRepository(rideRepository);
        rides = new Ride[]{
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)};
        expectedInvoice = new InvoiceSummary(2,45.0);
    }

    /**
     * Given distance and time should return total fare
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceSummary invoiceSummary = generator.getTotalFare(rides);
        Assert.assertEquals(invoiceSummary, expectedInvoice);
    }

    /**
     * Given distance and time if total fare is less than minimum fare should return minimum fare
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare(){
        InvoiceGenerator generator=new InvoiceGenerator();
        double distance=0.3;
        int time=1;
        double fare=generator.calculateFare(distance,time);
        Assert.assertEquals(5.0,fare,0.0);
    }

    /**
     * Given user Id should return Invoice summary
     */
    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        String userId = "sayali123";
        generator.addRides(userId, rides);
        InvoiceSummary invoiceSummary = generator.getInvoiceSummary(userId);
        Assert.assertEquals(invoiceSummary, expectedInvoice);
    }
}



