/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.tilastot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import upotus.laivanupotus.tilastot.Tilastojentekija;
import upotus.laivanupotus.pelaajatiedot.Nimivarasto;

/**
 *
 * @author Tanja
 */
public class TilastojentekijaTest {
    private Nimivarasto varasto;
    
    public TilastojentekijaTest() {
        varasto = new Nimivarasto();
        varasto.LuoKayttaja("Lupu");
        varasto.LuoKayttaja("Hupu");
        varasto.LuoKayttaja("Tupu");
        varasto.PaivitaKayttajanTietoja("Hupu", 8);
        varasto.PaivitaKayttajanTietoja("Hupu", 9);
        varasto.PaivitaKayttajanTietoja("Lupu", 100);
        varasto.PaivitaKayttajanTietoja("Tupu", 10);
        varasto.PaivitaKayttajanTietoja("Tupu", 11);
        varasto.PaivitaKayttajanTietoja("Tupu", 12);
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
     * Test of VoittajaLuettelo method, of class Tilastojentekija.
     */
    @Test
    public void testTuleekoSuurin() {
        Tilastojentekija tilastot = new Tilastojentekija(varasto);
        
        System.out.println(tilastot.VoittajaLuettelo());
    }
    
}
