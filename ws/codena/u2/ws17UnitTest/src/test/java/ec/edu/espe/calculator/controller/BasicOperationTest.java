package ec.edu.espe.calculator.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class BasicOperationTest {
    
    public BasicOperationTest() {
    }

    @org.junit.jupiter.api.Test
    public void testAdd() {
        System.out.println("add");
        float addend1 = 2.4F;
        float addend2 = 1.2F;
        float expResult = 3.6F;
        float result = BasicOperation.add(addend1, addend2);
        assertEquals(expResult, result, 0);
    }

    @org.junit.jupiter.api.Test
    public void testSubtract() {
        System.out.println("subtract");
        float minuend = 3.6F;
        float subtrahend = 1.2F;
        float expResult = 2.4F;
        float result = BasicOperation.subtract(minuend, subtrahend);
        assertEquals(expResult, result, 0);
    }
    
}
