package utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Edison Lascano, Object Masters, @ESPE
 */
public class TaxTest {
    
    public TaxTest() {
    }



    @Test
    public void testComputeIva() {
        System.out.println("computeIva");
        float amount = 100.0F;
        float taxPercentage = 15.0F;
        float expResult = 15.0F;
        float result = Tax.computeIva(amount, taxPercentage);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testComputeTotal() {
        System.out.println("computeTotal");
        float amount = 10.0F;
        float taxPercentage = 15F;
        float expResult = 11.5F;
        float result = Tax.computeTotal(amount, taxPercentage);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
