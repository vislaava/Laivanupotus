/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelaajatiedot;

/**
 *
 * @author Tanja
 */
public class Voitot {
    private int voittoja;
    private int siirtoja;
    
    public Voitot() {
        voittoja = 0;
        siirtoja = 0;
    }
    
    public void LisaaVoitto() {
        voittoja++;
    }
    
    public void PaivitaSiirrot(int uusiaSiirtoja) {
        siirtoja = siirtoja + uusiaSiirtoja;
    }
    
    public int getVoitot() {
        return voittoja;
    }
    
    public double SiirtojaKeskimaarin() {
        if (voittoja == 0) {
            return 0.0;
        } else {
            double keskiarvo = ((double) siirtoja) / voittoja;
            return keskiarvo;
        }
    }
    
    public String toString() {
        return Integer.toString(voittoja) + " " + Integer.toString(siirtoja);
    }
}
