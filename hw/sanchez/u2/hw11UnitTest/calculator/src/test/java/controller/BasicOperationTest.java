/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
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
        float addent1 = 1.2F;
        float addent2 = 2.4F;
        float expResult = 3.6F;
        float result = BasicOperation.add(addent1, addent2);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     @Test
    public void testAddsmall() {
        System.out.println("add");
        float addent1 = 4.2F;
        float addent2 = 2.4F;
        float expResult = 3.6F;
        float result = BasicOperation.add(addent1, addent2);
        assertEquals(expResult, result, 3);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtract method, of class BasicOperation.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        float minuend = 0.0F;
        float subtrahend = 0.0F;
        float expResult = 0.0F;
        float result = BasicOperation.subtract(minuend, subtrahend);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
