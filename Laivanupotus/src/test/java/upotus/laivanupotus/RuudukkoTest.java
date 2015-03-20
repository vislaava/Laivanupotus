/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Tanja
 */
public class RuudukkoTest {
    
    public RuudukkoTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of lisaaLaiva method, of class Ruudukko.
     */
    @Test
    public void testLisaaLaivaKunOikein() {
        Ruudukko lehtio = new Ruudukko();
        assertEquals(true, lehtio.lisaaLaiva(3, 2, 2, true));
    }
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void testLisaaLaivaKunVaarin() {
        Ruudukko lehtio = new Ruudukko();
        exception.expect(ArrayIndexOutOfBoundsException.class);
        assertEquals(false, lehtio.lisaaLaiva(2, 2, 12, true));
    }

    /**
     * Test of mahtuukoLaiva method, of class Ruudukko.
     */
    
    @Test
    public void testOnkoAllaTilaa() {
        Ruudukko lehtio = new Ruudukko();
        
        lehtio.LaitaLaiva(1, 1, true);
        
        assertEquals(true, lehtio.onkoAlla(1, 1));
    }
    
    @Test
    public void testAntaakoLaittaaLaivanViereen() {
        Ruudukko lehtio = new Ruudukko();
        
        lehtio.LaitaLaiva(1, 1, true);
        
        assertEquals(false, lehtio.lisaaLaiva(2, 1, 2, true));
    }
    
    @Test
    public void testAntaakoLaittaaJosVastaTokanAllaLaiva() {
        Ruudukko lehtio = new Ruudukko();
        
        lehtio.LaitaLaiva(1, 1, true);
        
        assertEquals(false, lehtio.lisaaLaiva(0, 1, 2, true));
    }
    
    @Test
    public void testTekeekoPitkanLaivan() {
        Ruudukko lehtio = new Ruudukko();
        
        lehtio.lisaaLaiva(1, 1, 3, false);
        
        assertEquals(true, lehtio.onkoAlla(1, 1));
        assertEquals(true, lehtio.onkoAlla(1, 2));
        assertEquals(true, lehtio.onkoAlla(1, 3));
    }
    
    @Test
    public void testTekeekoPitkanLaivanKunVieressaLaiva() {
        Ruudukko lehtio = new Ruudukko();
        
        lehtio.lisaaLaiva(1, 1, 3, false);
        
        assertEquals(false, lehtio.lisaaLaiva(2, 3, 3, false));
    }
    
    @Test
    public void testSaakoLaittaaRuudukonReunaan() {
        Ruudukko lehtio = new Ruudukko();
        
        assertEquals(true, lehtio.lisaaLaiva(0, 0, 3, false));
    }
    

    /**
     * Test of onkoReunoillaTilaa method, of class Ruudukko.
     */
    @Test
    public void testOnkoReunoillaTilaa() {
    }

    /**
     * Test of onkoYlapuolella method, of class Ruudukko.
     */
    @Test
    public void testOnkoYlapuolella() {
    }

    /**
     * Test of onkoAlapuolella method, of class Ruudukko.
     */
    @Test
    public void testOnkoAlapuolella() {
//        System.out.println("onkoAlapuolella");
//        int x = 0;
//        int y = 0;
//        Ruudukko instance = new Ruudukko();
//        boolean expResult = false;
//        boolean result = instance.onkoAlapuolella(x, y);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of onkoOikealla method, of class Ruudukko.
     */
    @Test
    public void testOnkoOikealla() {
//        System.out.println("onkoOikealla");
//        int x = 0;
//        int y = 0;
//        Ruudukko instance = new Ruudukko();
//        boolean expResult = false;
//        boolean result = instance.onkoOikealla(x, y);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of onkoVasemmalla method, of class Ruudukko.
     */
    @Test
    public void testOnkoVasemmalla() {
//        System.out.println("onkoVasemmalla");
//        int x = 0;
//        int y = 0;
//        Ruudukko instance = new Ruudukko();
//        boolean expResult = false;
//        boolean result = instance.onkoVasemmalla(x, y);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
