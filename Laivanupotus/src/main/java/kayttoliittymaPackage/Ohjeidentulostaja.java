/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittymaPackage;

import javax.swing.JLabel;
import upotus.laivanupotus.pelialusta.Peli;

/**
 * Luokka tulee tulostamaan GUIssa tekstikentässä ohjeita ja palautetta pelaajalle
 * @author Tanja
 */
public class Ohjeidentulostaja {
    private JLabel ohjelabel;
    private Peli peli;
    
    public Ohjeidentulostaja(JLabel ohjelabel, Peli peli) {
        this.ohjelabel = ohjelabel;
        this.peli = peli;
    }
    
    /**
     * Tulosta
     * 
     * Luokka tulostaa pelaajalle ohjeita riippuen siitä, asetellaanko laivoja vai ammutaanko niitä
     */
    
    public void tulosta() {
        if (peli.getLaivojenlaittaminen() == true) {
            ohjelabel.setText(peli.getPelaajanNimi() + ", aseta laivasi. Laivan pituus on " + peli.laivojenlaittaminen().getPituus());
        } else {
            ohjelabel.setText("Pelaajan " + peli.getPelaajanNimi() + " vuoro.");
        }
    }
}
