/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.tilastot;

import java.util.HashMap;
import java.util.Map;
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
    public void testTuleekoVoittajaListaOikeassaJarjestyksessa() {
        Tilastojentekija tilastot = new Tilastojentekija(varasto);
        String lista = "";
        lista = tilastot.VoittajaLuettelo(varasto.getLista());
        

        assertEquals("Tupu 3 33"
                + "Hupu 2 17"
                + "Lupu 1 100", lista);     
    }
    
    @Test
    public void testTuleekoVoittaja() {
        varasto.LuoKayttaja("Hannu");
        varasto.PaivitaKayttajanTietoja("Hannu", 7);
        varasto.PaivitaKayttajanTietoja("Hannu", 7);
        varasto.PaivitaKayttajanTietoja("Hannu", 7);
        varasto.PaivitaKayttajanTietoja("Hannu", 7);
        
        Tilastojentekija tilastot = new Tilastojentekija(varasto);
        
        String lista = tilastot.VoittajaLuettelo(varasto.getLista());
        
        assertEquals("Hannu 4 28"
                + "Tupu 3 33"
                + "Hupu 2 17"
                + "Lupu 1 100", lista); 
    }
    
    @Test
    public void testJosKaksiVoittajaa() {
        varasto.LuoKayttaja("Hannu");
        varasto.PaivitaKayttajanTietoja("Hannu", 7);
        varasto.PaivitaKayttajanTietoja("Hannu", 7);
        varasto.PaivitaKayttajanTietoja("Hannu", 7);
        
        Tilastojentekija tilastot = new Tilastojentekija(varasto);
        
        String lista = tilastot.VoittajaLuettelo(varasto.getLista());
        
        assertEquals("Hannu 3 21"
                + "Tupu 3 33"
                + "Hupu 2 17"
                + "Lupu 1 100", lista); 
    }
    
    @Test
    public void testTuleekoSiirtoListaOikeassaJarjestyksessa() {
        Tilastojentekija tilastot = new Tilastojentekija(varasto);
        String lista = "";
        lista = tilastot.VähitenSiirtojaSuhteessaVoittoihinLuettelo(varasto.getLista());
        

        assertEquals("Hupu 2 17"
                + "Tupu 3 33"
                + "Lupu 1 100", lista);
    }
    
    @Test
    public void testJosKahdellaYhtaVahanSiirtoja() {
        varasto.LuoKayttaja("Hannu");
        varasto.PaivitaKayttajanTietoja("Hannu", 7);
        varasto.PaivitaKayttajanTietoja("Hannu", 5);
        varasto.PaivitaKayttajanTietoja("Hannu", 5);
        
        Tilastojentekija tilastot = new Tilastojentekija(varasto);
        String lista = "";
        lista = tilastot.VähitenSiirtojaSuhteessaVoittoihinLuettelo(varasto.getLista());
        
        assertEquals("Hannu 3 17"
                + "Hupu 2 17"
                + "Tupu 3 33"
                + "Lupu 1 100", lista);
    }
    
    @Test
    public void testJosEnemmanSiirtojaMuttaKeskiarvoPienempi() {
        varasto.LuoKayttaja("Hannu");
        varasto.PaivitaKayttajanTietoja("Hannu", 7);
        varasto.PaivitaKayttajanTietoja("Hannu", 5);
        varasto.PaivitaKayttajanTietoja("Hannu", 5);
        varasto.PaivitaKayttajanTietoja("Hannu", 5);
        varasto.PaivitaKayttajanTietoja("Hannu", 5);
        
        Tilastojentekija tilastot = new Tilastojentekija(varasto);
        String lista = "";
        lista = tilastot.VähitenSiirtojaSuhteessaVoittoihinLuettelo(varasto.getLista());
        
        assertEquals("Hannu 5 27"
                + "Hupu 2 17"
                + "Tupu 3 33"
                + "Lupu 1 100", lista);
    }
    
}
