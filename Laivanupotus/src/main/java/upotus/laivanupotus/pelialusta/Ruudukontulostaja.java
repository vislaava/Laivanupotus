/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta;

import upotus.laivanupotus.peliruudukko.Ruudukko;
import upotus.laivanupotus.peliruudukko.Ruutu;

/**
 *
 * @author Tanja
 */
public class Ruudukontulostaja {
    private Ruudukko ruudukko;
    private Ruutu[][] ruudut;
    
    public Ruudukontulostaja(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.ruudut = ruudukko.getRuudut();
    }
    
    public String TulostaRuudukko(Boolean hyokkaaja) {
        String palautettavaRuudukko = "";
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (hyokkaaja == true) {
                    if (ruudut[x][y].onkoAmmuttu() == false) {
                        palautettavaRuudukko = palautettavaRuudukko + "w";
                    } else {
                        if (ruudut[x][y].onkoLaivaa() == true) {
                            palautettavaRuudukko = palautettavaRuudukko + "x";
                        } else {
                            palautettavaRuudukko = palautettavaRuudukko + "o";
                        }
                    }
                } else {
                    if (ruudut[x][y].onkoLaivaa() == true) {
                        if (ruudut[x][y].onkoAmmuttu() == true) {
                            palautettavaRuudukko = palautettavaRuudukko + "x";
                        } else {
                            palautettavaRuudukko = palautettavaRuudukko + "s";
                        }
                    } else {
                        palautettavaRuudukko = palautettavaRuudukko + "w";
                    }
                }
            }
            palautettavaRuudukko = palautettavaRuudukko + "\n";
        }
        
        return palautettavaRuudukko;
    }
}
