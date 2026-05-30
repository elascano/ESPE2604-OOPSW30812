package espe.edu.ec.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Lomas Christopher, CodeBros, @ESPE
 */
public class BasicOperationTest {

    
    private static final float DELTA = 0.001f;

    @ParameterizedTest
    @CsvSource({
        "1.2, 2.4, 3.6",       
        "5.0, 5.0, 10.0",      
        "0.0, 0.0, 0.0",       
        "-1.5, -2.5, -4.0",    
        "-5.0, 3.0, -2.0",     
        "100.5, 200.5, 301.0", 
        "0.001, 0.002, 0.003", 
        "10.0, 20.0, 30.0",   
        "1.1, 1.1, 2.2",      
        "9.9, 0.1, 10.0",     
        "-10.0, -10.0, -20.0",
        "50.0, 25.0, 75.0",   
        "0.5, 0.25, 0.75"      
    })
    public void testAdd(float addend1, float addend2, float expectedResult) {
        System.out.println("Running parameterized add test for: " + addend1 + " + " + addend2);
        float result = BasicOperation.add(addend1, addend2);
        assertEquals(expectedResult, result, DELTA);
    }

    @ParameterizedTest
    @CsvSource({
        "3.6, 1.2, 2.4",       
        "10.0, 5.0, 5.0",      
        "0.0, 0.0, 0.0",      
        "-4.0, -1.5, -2.5",    
        "-2.0, 3.0, -5.0",     
        "301.0, 100.5, 200.5", 
        "0.003, 0.001, 0.002", 
        "30.0, 10.0, 20.0",    
        "2.2, 1.1, 1.1",       
        "10.0, 0.1, 9.9",     
        "-20.0, -10.0, -10.0", 
        "75.0, 25.0, 50.0",    
        "0.75, 0.25, 0.5"      
    })
    public void testSubtract(float minuend, float subtrahend, float expectedResult) {
        System.out.println("Running parameterized subtract test for: " + minuend + " - " + subtrahend);
        float result = BasicOperation.subtract(minuend, subtrahend);
        assertEquals(expectedResult, result, DELTA);
    }
}
