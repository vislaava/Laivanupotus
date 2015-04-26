/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import java.util.ArrayList;
import KayttoliittymaPackage.OmaButton;
import upotus.laivanupotus.peliruudukko.Ruudukko;
import upotus.laivanupotus.peliruudukko.Ruutu;

/**
 *Luokka tulostaa jokaiseen ruudukon nappiin kirjaimen riippuen pelaajasta, eli onko hyökkääjän vai puolustajan ruudukko
 * @author Tanja
 */
public class Nappienkirjoittaja {

    private ArrayList<OmaButton> napit;
    private Ruudukko ruudukko;

    public Nappienkirjoittaja(ArrayList<OmaButton> napit) {
        this.napit = napit;
    }
    
    /**
     * Kirjaintenmuuttaminen
     * 
     * Metodi tulostaa halutunlaisen ruudukon, eli joko puolustajan tai hyökkääjän ruudukon
     * jotka eroavat ruudukon näkyvyyden osalta
     * @param ruudukko tallentaa ruudut, joissa tietona ammuttu- ja laiva-tilanteet
     * @param pelaajaitse hyökkääjä vai puolustaja
     */

    public void Kirjaintenmuuttaminen(Ruudukko ruudukko, boolean pelaajaitse) {
        this.ruudukko = ruudukko;
        Ruutu[][] ruudut = ruudukko.getRuudut();
        for (OmaButton nappi : napit) {
            if (pelaajaitse == true) {

                if (ruudut[nappi.getParX()][nappi.getParY()].onkoLaivaa() == true) {
                    if (ruudut[nappi.getParX()][nappi.getParY()].onkoAmmuttu() == true) {
                        nappi.setText("x");
                    } else {
                        nappi.setText("s");
                    }
                } else {
                    nappi.setText("w");
                }
                
            } else {
                if (ruudut[nappi.getParX()][nappi.getParY()].onkoAmmuttu() == false) {
                    nappi.setText("w");
                } else {
                    if (ruudut[nappi.getParX()][nappi.getParY()].onkoLaivaa() == true) {
                        nappi.setText("x");
                    } else {
                        nappi.setText("o");
                    }
                }
            }
        }
    }
}
