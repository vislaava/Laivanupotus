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

    public Peliruutu() {
        this.laivojenlaittaja = new Laivojenlaittaja(ruudukko, tulostaja, ruudunlukija);
    }

    public Laivojenlaittaja getLaivojenlaittaja() {
        return laivojenlaittaja;
    }

    public Boolean OnkoRuudukossaKaikkiUpotettu() {
        return ruudukko.OnkoKaikkiAmmuttu();
    }

    public void Kierros(Peliruutu vastustaja) {
        tulostaja.TulostaRuudukko(true);
        vastustaja.tulostaja.TulostaRuudukko(false);
        while (true) {
            if (vastustaja.ruudukko.AmmuLaiva(ruudunlukija.KysyX(), ruudunlukija.KysyY()) == true) {
                return;
            } else {
                System.out.println("Ruutua on jo ammuttu.");
            }
        }
    }

}
