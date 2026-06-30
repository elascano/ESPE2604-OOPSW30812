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
public class PigTest {

    @Test
    public void testSendToButcherSuccess() {

        Pig pig = new Pig(1, "Yorkshire", LocalDate.now(), 120, 100);

        assertTrue(pig.sendToButcher());

    }

    @Test
    public void testSendToButcherFail() {

        Pig pig = new Pig(1, "Yorkshire", LocalDate.now(), 80, 100);

        assertFalse(pig.sendToButcher());

    }

    @Test
    public void testCut() {

        Pig pig = new Pig(1, "Yorkshire", LocalDate.now(), 120, 100);

        assertEquals(3, pig.cut().size());

    }


}
