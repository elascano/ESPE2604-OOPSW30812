/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ronald Tipan <The_Softwarrios at ESPE>
 */
public class BasicOperationTest {
    
    public BasicOperationTest() {
    }

    @org.junit.jupiter.api.Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class BasicOperation.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        float addend1 = 1.0F;
        float addend2 = 2.0F;
        float expResult = 3.0F;
        float result = BasicOperation.add(addend1, addend2);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtract method, of class BasicOperation.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        float minued = 3.6F;
        float subtrahend = 1.2F;
        float expResult = 2.4F;
        float result = BasicOperation.subtract(minued, subtrahend);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
