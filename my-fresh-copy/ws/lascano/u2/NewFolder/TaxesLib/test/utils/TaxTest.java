package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Edison Lascano, Object Masters, @ESPE
 */
public class TaxTest {
    
    public TaxTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testComputeIva() {
        System.out.println("computeIva");
        float amount = 0.0F;
        float taxPercentage = 0.0F;
        float expResult = 0.0F;
        float result = Tax.computeIva(amount, taxPercentage);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    @Test
    public void testComputeTotal() {
        System.out.println("computeTotal");
        float amount = 0.0F;
        float taxPercentage = 0.0F;
        float expResult = 0.0F;
        float result = Tax.computeTotal(amount, taxPercentage);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
