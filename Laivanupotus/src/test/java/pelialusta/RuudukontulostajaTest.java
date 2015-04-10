/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelialusta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import upotus.laivanupotus.pelialusta.Ruudukontulostaja;
import upotus.laivanupotus.peliruudukko.Ruudukko;

/**
 *
 * @author Tanja
 */
public class RuudukontulostajaTest {
    
    public RuudukontulostajaTest() {
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

    @Test
    public void testLuoTyhjaRuudukko() {
        Ruudukko lehtio = new Ruudukko();
        Ruudukontulostaja tulostaja = new Ruudukontulostaja(lehtio);
        
        String malliruudukko = "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n";
        
        assertEquals(malliruudukko, tulostaja.TulostaRuudukko(Boolean.TRUE));
    }
    
    @Test
    public void testLuoRuudukkoLaivoilla() {
        Ruudukko lehtio = new Ruudukko();
        lehtio.lisaaLaiva(1, 1, 3, true);
        lehtio.lisaaLaiva(3, 3, 2, true);
        
        Ruudukontulostaja tulostaja = new Ruudukontulostaja(lehtio);
        
        String malliruudukko = 
                  "wwwwwwwwww" + "\n"
                + "wssswwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwsswwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n"
                + "wwwwwwwwww" + "\n";
        
        assertEquals(malliruudukko, tulostaja.TulostaRuudukko(Boolean.FALSE));
    }
}
