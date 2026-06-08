/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.calculator.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
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
        float addend1 = -2.6F;
        float addend2 = 3.5F;
        float expResult = 0.9F;
        float result = BasicOperation.add(addend1, addend2);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of substract method, of class BasicOperation.
     */
    @Test
    public void testSubstract() {
        System.out.println("substract");
        float minuend = 0.0F;
        float substraend = 0.0F;
        float expResult = 0.0F;
        float result = BasicOperation.substract(minuend, substraend);
        assertEquals(expResult, result, 0);
    }
    
}
