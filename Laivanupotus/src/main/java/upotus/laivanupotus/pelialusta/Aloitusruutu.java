/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta;

import upotus.laivanupotus.peliruudukko.Ruudukko;

/**
 *
 * @author Tanja
 */
public class Aloitusruutu {
    private Ruudukko ruudukko = new Ruudukko();
    private Ruudukontulostaja tulostaja = new Ruudukontulostaja(ruudukko);
    private Laivojenlaittaja laivat = new Laivojenlaittaja(ruudukko, tulostaja);
    
    public Laivojenlaittaja getLaivat() {
        return laivat;
    }


}
