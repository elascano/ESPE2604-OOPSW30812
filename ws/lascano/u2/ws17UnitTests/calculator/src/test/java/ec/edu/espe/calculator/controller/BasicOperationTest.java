package ec.edu.espe.calculator.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Edison Lascano, Object Masters, @ESPE
 */
public class BasicOperationTest {
    
    public BasicOperationTest() {
    }

    /**
     * Test of add method, of class BasicOperation.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        float addend1 = 1.2F;
        float addend2 = 2.4F;
        float expResult = 3.6F;
        float result = BasicOperation.add(addend1, addend2);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testAddSmallNumbers() {
        System.out.println("add");
        float addend1 = 1.0F;
        float addend2 = 2.0F;
        float expResult = 3.0F;
        float result = BasicOperation.add(addend1, addend2);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of subtract method, of class BasicOperation.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        float minuend = 1.0F;
        float subtrahend = 2.0F;
        float expResult = -1.0F;
        float result = BasicOperation.subtract(minuend, subtrahend);
        assertEquals(expResult, result, 0);
 
    }
    
}
