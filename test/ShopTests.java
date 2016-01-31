import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ShopTests {

    public Transaction t;

    @Before
    public void init(){
        t = new Transaction();
    }

    @Test
    public void checkDiscount50(){

        t.setCount(50);
        t.setPrice(1);
        t.setDiscount();

        double discount = 0.0;
        double oldSum = t.getCount() * t.getPrice();
        if (oldSum >= 50 && oldSum < 100){
            discount = oldSum * 0.05;
        }

        assertFalse("no match discount to sum "+oldSum+" ["+discount+" != " + t.getDiscount() + "]", discount != t.getDiscount());
    }

    @Test
    public void checkDiscount100(){

        t.setCount(100);
        t.setPrice(1);
        t.setDiscount();

        double discount = 0.0;
        double oldSum = t.getCount() * t.getPrice();
        if (oldSum >= 100){
            discount = oldSum * 0.1;
        }
        assertFalse("no match discount to sum "+oldSum+" ["+discount+" != " + t.getDiscount() + "]", discount != t.getDiscount());
    }

}
