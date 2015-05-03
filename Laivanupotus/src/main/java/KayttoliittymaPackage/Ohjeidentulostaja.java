/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

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
    
    public void Tulosta() {
        if (peli.getLaivojenlaittaminen() == true) {
            ohjelabel.setText(peli.getPelaajanNimi() + ", aseta laivasi. \n Laivoja on 1 x 5, 1 x 4, 1 x 3, 2 x 2 ja 3 x 1");
        } else {
            ohjelabel.setText("Pelaajan " + peli.getPelaajanNimi() + " vuoro.");
        }
    }
}
