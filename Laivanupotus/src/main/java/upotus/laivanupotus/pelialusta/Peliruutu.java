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
public class Peliruutu {

    private Ruudukko ruudukko = new Ruudukko();
    private Ruudukontulostaja tulostaja = new Ruudukontulostaja(ruudukko);
    private Laivojenlaittaja laivojenlaittaja;
    private Lukija ruudunlukija = new Lukija();
    private int kierroslaskuri = 0;

    public Peliruutu() {
        this.laivojenlaittaja = new Laivojenlaittaja(ruudukko, tulostaja, ruudunlukija);
    }
    
    public Ruudukko getRuudukko() {
        return ruudukko;
    }

    public Laivojenlaittaja getLaivojenlaittaja() {
        return laivojenlaittaja;
    }

    public String TulostaPeliruudukko(boolean vastustaja) {
        return tulostaja.TulostaRuudukko(vastustaja);
    }

    public Boolean OnkoRuudukossaKaikkiUpotettu() {
        return ruudukko.OnkoKaikkiAmmuttu();
    }

    public void Kierros(Peliruutu vastustaja) {
        if (OnkoRuudukossaKaikkiUpotettu() == false || vastustaja.OnkoRuudukossaKaikkiUpotettu() == false) {

            while (true) {
                System.out.println(tulostaja.TulostaRuudukko(true));
                System.out.println(vastustaja.tulostaja.TulostaRuudukko(false));
                int x = ruudunlukija.KysyX();
                int y = ruudunlukija.KysyY();
                if (vastustaja.ruudukko.AmmuLaiva(x, y) == true) {
                    if (vastustaja.ruudukko.onkoAlla(x, y) == true) {
                        System.out.println("Osui!");
                    } else {
                        System.out.println("Ohi!");
                    }
                    kierroslaskuri++;
                    return;
                } else {
                    System.out.println("Ruutua on jo ammuttu.");
                }
            }
        } else {
            
        }
    }

}
