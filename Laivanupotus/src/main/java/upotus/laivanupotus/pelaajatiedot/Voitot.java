/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelaajatiedot;

import java.io.Serializable;

/**
 * Voitot
 * 
 * Luokka hallinnoi pelaajan voittoja ja siirtoja
 * @author Tanja
 */
public class Voitot implements Serializable {
    private int voittoja;
    private int siirtoja;
    
    public Voitot() {
        voittoja = 0;
        siirtoja = 0;
    }
    
    public void lisaaVoitto() {
        voittoja++;
    }
    
    /**
     * PaivitaSiirrot
     * 
     * Metodi lisää pelaajan siirrot-tiliin uudet siirrot
     * @param uusiaSiirtoja viimeisimmän voitetun pelin siirrot
     */
    
    public void paivitaSiirrot(int uusiaSiirtoja) {
        siirtoja = siirtoja + uusiaSiirtoja;
    }
    
    public int getVoitot() {
        return voittoja;
    }
    
    /**
     * SiirtojaKeskimaarin
     * 
     * Metodi palauttaa keskiarvon siirtojen määrästä
     * @return keskiarvo
     */
    
    public double siirtojaKeskimaarin() {
        if (voittoja == 0) {
            return 0.0;
        } else {
            double keskiarvo = ((double) siirtoja) / voittoja;
            return keskiarvo;
        }
    }
    
    public String toString() {
        return " Voittoja: " + Integer.toString(voittoja) + " Siirtoja: " + Integer.toString(siirtoja) + "";
    }
}
