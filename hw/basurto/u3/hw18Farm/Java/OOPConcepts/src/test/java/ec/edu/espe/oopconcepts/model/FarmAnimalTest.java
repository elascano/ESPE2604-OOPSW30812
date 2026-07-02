/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.oopconcepts.model;

import java.time.LocalDate;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class FarmAnimalTest {

    @Test
    public void testCalculateAgeInMonths() {

        Cow cow = new Cow(1, "Holstein", LocalDate.now().minusMonths(18), 500, true);

        int age = cow.getAgeInMonths();

        assertEquals(18, age);

    }

}
