/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group6cardgame;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;

/**
 *
 * @author John
 */
public class Group6CardGameTest {

    public Group6CardGameTest() {
    }

    public static void setUpClass() {
    }

    public static void tearDownClass() {
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    /**
     * Test of main method, of class Group6CardGame.
     */
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Group6CardGame.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of winCon method, of class Group6CardGame.
     */
    @Test
    public void testWinConBad() {
        System.out.println("winCon Bad");
        int p1 = 0;
        int p2 = 0;
        boolean expResult = false;
        boolean result = Group6CardGame.winCon(p1, p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testWinConGood() {
        System.out.println("winCon Good");
        int p1 = 30;
        int p2 = 30;
        boolean expResult = true;
        boolean result = Group6CardGame.winCon(p1, p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testWinConBoundary() {
        System.out.println("winCon Boundary");
        int p1 = 26;
        int p2 = 26;
        boolean expResult = true;
        boolean result = Group6CardGame.winCon(p1, p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of handSize method, of class Group6CardGame.
     */
    @Test
    public void testHandSizeBad() {
        System.out.println("handSize Bad");
        int size = 0;
        boolean expResult = true;
        boolean result = Group6CardGame.warDeckSize(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testHandSizeGood() {
        System.out.println("handSize Good");
        int size = 10;
        boolean expResult = false;
        boolean result = Group6CardGame.warDeckSize(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testHandSizeBoundary() {
        System.out.println("handSize Boundary");
        int size = 4;
        boolean expResult = true;
        boolean result = Group6CardGame.warDeckSize(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testDeckSizeGood() {
        System.out.println("deckSize Good");
        int size = 10;
        boolean expResult = false;
        boolean result = Group6CardGame.deckSize(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testDeckSizeBad() {
        System.out.println("deckSize Bad");
        int size = 0;
        boolean expResult = true;
        boolean result = Group6CardGame.deckSize(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testDeckSizeBoundary() {
        System.out.println("deckSize Boundary");
        int size = 2;
        boolean expResult = true;
        boolean result = Group6CardGame.deckSize(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /*
    Manual Tests / Tests not able to be performed using JUnit:
    ========================================================================
    
    - Test if all cards are in deck
    - Test if player discards 3 cards for war
    - Test if player wins the correct amount of points
     */
}
