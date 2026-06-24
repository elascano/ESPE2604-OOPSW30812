/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.librarysystem.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class BookTest {
    
    public BookTest() {
    }

    /**
     * Test of getBookId method, of class Book.
     */
    @org.junit.jupiter.api.Test
    public void testGetBookId() {
        System.out.println("getBookId");
        Book instance = null;
        String expResult = "";
        String result = instance.getBookId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBookId method, of class Book.
     */
    @org.junit.jupiter.api.Test
    public void testSetBookId() {
        System.out.println("setBookId");
        String bookId = "";
        Book instance = null;
        instance.setBookId(bookId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @org.junit.jupiter.api.Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Book instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @org.junit.jupiter.api.Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Book instance = null;
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    @org.junit.jupiter.api.Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Book instance = null;
        String expResult = "";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAuthor method, of class Book.
     */
    @org.junit.jupiter.api.Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String author = "";
        Book instance = null;
        instance.setAuthor(author);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
