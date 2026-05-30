
package ec.edu.espe.calculator.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public class BasicOperationTest {
    
    public BasicOperationTest() {
    }
    /**
     * Test of add method, of class BasicOperation.
     */
    @org.junit.jupiter.api.Test
    public void testAdd() {
        System.out.println("add");
        float addend1 = 1.2F;
        float addend2 = 2.4F;
        float expResult = 3.4F;
        float result = BasicOperation.add(addend1, addend2);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtract method, of class BasicOperation.
     */
    @org.junit.jupiter.api.Test
    public void testSubtract() {
        System.out.println("subtract");
        float minuend = 3.6F;
        float subtrahend = 1.2F;
        float expResult = 2.4F;
        float result = BasicOperation.subtract(minuend, subtrahend);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
