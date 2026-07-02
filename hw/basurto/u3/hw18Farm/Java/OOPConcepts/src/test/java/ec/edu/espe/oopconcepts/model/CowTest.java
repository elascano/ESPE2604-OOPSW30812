/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.oopconcepts.model;

import java.time.LocalDate;
import java.util.ArrayList;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class CowTest {

    @Test
    public void testMilkAvailable() {

        Cow cow = new Cow(1, "Holstein", LocalDate.now(), 500, true);

        assertEquals(cow.milk(), 5);

    }


}
