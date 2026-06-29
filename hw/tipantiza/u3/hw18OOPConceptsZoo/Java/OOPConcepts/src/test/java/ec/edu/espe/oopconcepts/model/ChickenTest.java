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
public class ChickenTest {

    @Test
    public void testLayEgg() {

        Chicken chicken = new Chicken(1, "Leghorn", LocalDate.now(), 2.5f, false, 5);

        assertTrue(chicken.layAnEgg());

    }

    @Test
    public void testIncreaseEggs() {

        Chicken chicken = new Chicken(1, "Leghorn", LocalDate.now(), 2.5f, false, 5);

        chicken.layAnEgg();

        assertEquals(6, chicken.getNumberOfEggs());

    }

}
