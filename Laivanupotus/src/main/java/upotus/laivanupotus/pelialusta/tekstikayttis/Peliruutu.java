/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta.tekstikayttis;

import upotus.laivanupotus.pelialusta.Laivavarasto;
import upotus.laivanupotus.pelialusta.Lukija;
import upotus.laivanupotus.pelialusta.tekstikayttis.Ruudukontulostaja;
import upotus.laivanupotus.peliruudukko.Ruudukko;
import upotus.laivanupotus.peliruudukko.Ruutu;

/**
 * Peliruutu
 * 
 * Tekstikäyttöliittymäluokka
 * @author Tanja
 */
public class Peliruutu {
    
    /**
     * Luokka kuuluu tekstikäyttöliittymään ja alkaa olla melko turha. GUIn kanssa toimii luokka Peli.
     */

    private Ruudukko ruudukko;
    private Ruudukontulostaja tulostaja = new Ruudukontulostaja(ruudukko);
    private Laivavarasto laivojenlaittaja;
    private Lukija ruudunlukija = new Lukija();


    public Peliruutu(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.laivojenlaittaja = new Laivavarasto(ruudukko, tulostaja, ruudunlukija);
    }
    
    public Ruudukko getRuudukko() {
        return ruudukko;
    }

    public Laivavarasto getLaivojenlaittaja() {
        return laivojenlaittaja;
    }
    
    /**
     * TulostaPeliruudukko
     * 
     * Metodi kutsuu tulostajaa
     * @param vastustaja boolean-arvo annetaan parametrina kertomaan, tulostetaanko ruudukko mallilla
     * puolustava, vai hyökkäävä
     * @return palauttaa String-esityksen ruudukosta
     */

    public String tulostaPeliruudukko(boolean vastustaja) {
        return tulostaja.tulostaRuudukko(vastustaja);
    }
    
    /**
     * OnkoRuudukossaKaikkiUpotettu
     * 
     * Metodi tarkistaa onko kaikki ruudukon laivat ammuttu
     * @return palauttaa kyllä tai ei vastauksen
     */

    public Boolean onkoRuudukossaKaikkiUpotettu() {
        return ruudukko.onkoKaikkiAmmuttu();
    }
    
    /**
     * Kierros
     * 
     * Metodi hoitaa yhden kierroksen per pelaaja.
     * Metodi kutsuu tulostajaa tulostamaan oman ja vastustajan ruudukon.
     * Tämän jälkeen kutsuu Scanner-luokka-oliota lukemaan pelaajan kirjoituksia
     * Tämän jälkeen tarkistaa osuiko pelaaja ja reagoi sen mukaan. Jos pelaaja ampuu jo ampumaansa paikkaan,
     * metodi palaa ampumiseen, eikä lopeta ennen kuin tulee osu tai ohi.
     * @param vastustaja vastustajan ruudukko
     */

    public void kierros(Peliruutu vastustaja) {
        if (onkoRuudukossaKaikkiUpotettu() == false || vastustaja.onkoRuudukossaKaikkiUpotettu() == false) {

            while (true) {
                System.out.println(tulostaja.tulostaRuudukko(true));
                System.out.println(vastustaja.tulostaja.tulostaRuudukko(false));
                int x = ruudunlukija.kysyX();
                int y = ruudunlukija.kysyY();
                if (vastustaja.ruudukko.ammuLaiva(x, y) == true) {
                    if (vastustaja.ruudukko.onkoAlla(x, y) == true) {
                        System.out.println("Osui!");
                    } else {
                        System.out.println("Ohi!");
                    }
                    return;
                } else {
                    System.out.println("Ruutua on jo ammuttu.");
                }
            }
        } else {
            
        }
    }
}
