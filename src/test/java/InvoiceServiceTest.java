import com.cabservicegenerator.InvoiceGenerator;
import com.cabservicegenerator.Ride;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

    /** Given distance and time should return total fare*/
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator generator=new InvoiceGenerator();
        double distance=2.0;
        int time=5;
        double fare=generator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    /** Given distance and time if total fare is less than minimum fare should return minimum fare */
    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare(){
        InvoiceGenerator generator=new InvoiceGenerator();
        double distance=0.3;
        int time=1;
        double fare=generator.calculateFare(distance,time);
        Assert.assertEquals(5.0,fare,0.0);
    }

    /** Given multiple rides should return total fare */
    @Test
    public void givenMultipleRides_ShouldReturnTotalFare(){
        InvoiceGenerator generator=new InvoiceGenerator();
        Ride[] rides={  new Ride(2.0,5),
                        new Ride(0.1,1)
                    };
        double fare=generator.calculateFare(rides);
        Assert.assertEquals(30,fare,0.0);
    }

}
