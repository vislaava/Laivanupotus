/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta;

import java.util.List;
import upotus.laivanupotus.pelaajatiedot.Nimivarasto;
import upotus.laivanupotus.pelialusta.Laiva;
import upotus.laivanupotus.pelialusta.Laivavarasto;
import upotus.laivanupotus.pelialusta.Lopettaja;
import upotus.laivanupotus.peliruudukko.Ruudukko;
import upotus.laivanupotus.peliruudukko.Ruutu;

/**
 *
 * @author Tanja
 */
public class Peli {

    /**
     * Luokka luo kummallekin pelaajalle ruudukon ja Kuuntelijan kutsumana
     * toteuttaa kulloisenkin vuoron. Pitää huolta myös vuoroista.
     */
    private Ruudukko ruudukko1;
    private Ruudukko ruudukko2;
    private int kierroslaskuri = 0;
    private int laivojalaitettu = 0;
    private Laivavarasto varasto;
    private List<Laiva> laivat;
    private boolean laitetaankoLaivoja = true;
    private boolean pelaajan1vuoro = true;
    private Ruutu[][] ruudut1;
    private Ruutu[][] ruudut2;
    private Lopettaja lopettaja;
    private String pelaaja1;
    private String pelaaja2;
    private Nimivarasto nimivarasto;
    private boolean loppuiko;
    private boolean vaihtuikoVuoro;

    public Peli(Nimivarasto nimivarasto) {
        this.varasto = new Laivavarasto();
        this.laivat = varasto.getLaivat();
        this.ruudukko1 = new Ruudukko();
        this.ruudukko2 = new Ruudukko();
        this.ruudut1 = ruudukko1.getRuudut();
        this.ruudut2 = ruudukko2.getRuudut();
        this.nimivarasto = nimivarasto;
        this.lopettaja = new Lopettaja(nimivarasto);
        this.loppuiko = false;
        this.vaihtuikoVuoro = false;
    }

    /**
     * getRuudukko
     * 
     * @return Jos asetellaan laivoja, palauttaa pelaajalle pelaajan oman ruudukon,
     * jos pelitilanne, palauttaa käyttäjälle vastustajan ruudukon.
     */
    
    public Ruudukko getRuudukko() {
        if (laitetaankoLaivoja == true) {
            if (pelaajan1vuoro == true) {
                return ruudukko1;
            } else {
                return ruudukko2;
            }
        } else {
            if (pelaajan1vuoro == true) {
                return ruudukko2;
            } else {
                return ruudukko1;
            }
        }
    }
    
    public void setPelaaja1Nimi(String nimi1) {
        pelaaja1 = nimi1;
    }
    
    public void setPelaaja2Nimi (String nimi2) {
        pelaaja2 = nimi2;
    }
    
    public String getPelaajanNimi() {
        if (pelaajan1vuoro == true) {
            return pelaaja1;
        } else {
            return pelaaja2;
        }
    }

    public boolean getLaivojenlaittaminen() {
        return laitetaankoLaivoja;
    }
    public boolean getLoppuiko() {
        return loppuiko;
    }
    
    /**
     * resetPeli
     * 
     * Asettaa kaike tarvittavan alkuasetuksiin
     */
    
    public void resetPeli() {
        this.varasto = new Laivavarasto();
        this.laivat = varasto.getLaivat();
        this.ruudukko1 = new Ruudukko();
        this.ruudukko2 = new Ruudukko();
        this.ruudut1 = ruudukko1.getRuudut();
        this.ruudut2 = ruudukko2.getRuudut();
        this.lopettaja = new Lopettaja(nimivarasto);
        this.loppuiko = false;
        kierroslaskuri = 0;
        laivojalaitettu = 0;
        laitetaankoLaivoja = true;
        pelaajan1vuoro = true;
    }
    
    /**
     * LaitetaankoLaivoja
     *
     * Metodi pitää kirjaa siitä onko laivojenlaittotilanne ja pelaajien vuoron
     * vaihtumisesta kesken sen.
     */
    private void laitetaankoLaivoja() {
        if (laivojalaitettu == 8) {
            laivojalaitettu = 0;
            if (pelaajan1vuoro) {
                pelaajan1vuoro = false;
            } else {
                laitetaankoLaivoja = false;
                pelaajan1vuoro = true;
            }
        }
    }

    /**
     * TapahtumaRuudussa
     *
     * Metodi vastaa Kuuntelijan kutsuun ja toteuttaa napin painallukseen
     * reaktiona tapahtuman, joka luokan kirjanpidon perusteella on
     * ajankohtainen, eli laivojenlaittamisen tai pelaamisen
     *
     * @param x parametrit ruudukon parametreja
     * @param y
     * @param vaaka
     * @return palauttaa sanalliset ohjeet ja palautteen pelaajalle
     */
    
    public String tapahtumaRuudussa(int x, int y, boolean vaaka) {
        vaihtuikoVuoro = false;
        // Laitetaan laivat
        if (laitetaankoLaivoja == true) {
            if (pelaajan1vuoro == true) {
                if (ruudukko1.lisaaLaiva(x, y, laivojenlaittaminen().getPituus(), vaaka) == true) {
                    laivojalaitettu++;
                    laitetaankoLaivoja();
                    return "Laiva sopii siihen.";
                } else {
                    return "Laiva ei sovi tähän, koita toista paikkaa.";
                }
            } else {
                if (ruudukko2.lisaaLaiva(x, y, laivojenlaittaminen().getPituus(), vaaka) == true) {
                    laivojalaitettu++;
                    laitetaankoLaivoja();
                    return "Laiva sopii siihen.";
                } else {
                    laitetaankoLaivoja();
                    return "Laiva ei sovi tähän, koita toista paikkaa.";
                }
            }
        } else {
            if (pelaajan1vuoro == true) {
                kierroslaskuri++;
                if (ruudukko2.ammuLaiva(x, y) == true) {
                    if (ruudut2[x][y].onkoLaivaa() == true) {
                        if (ruudukko2.onkoKaikkiAmmuttu() == false) {
                            return "Pelaaja " + pelaaja1 + " osui!";
                        } else {
                            loppuiko = true;
                            lopettaja.lopeta(kierroslaskuri, pelaajan1vuoro, pelaaja1);
                            return "Kaikki laivat ammuttu, voitit!";
                        }
                    } else {
                        pelaajan1vuoro = false;
                        return "Pelaaja " + pelaaja1 + " ampui ohi!";
                    }
                } else {
                    return "Paikkaa on jo ammuttu";
                }
            } else {
                if (ruudukko1.ammuLaiva(x, y) == true) {
                    if (ruudut1[x][y].onkoLaivaa() == true) {
                        if (ruudukko1.onkoKaikkiAmmuttu() == false) {
                            return "Pelaaja " + pelaaja2 + " osui!";
                        } else {
                            loppuiko = true;
                            lopettaja.lopeta(kierroslaskuri, pelaajan1vuoro, pelaaja2);
                            return "Kaikki laivat ammuttu, voitit!";
                        }
                    } else {
                        pelaajan1vuoro = true;
                        return "Pelaaja " + pelaaja2 + " ampui ohi!";
                    }
                } else {
                    return "Paikkaa on jo ammuttu";
                }
            }
        }
    }

    /**
     * Laivojenlaittaminen
     *
     * Metodi antaa vuorossa olevan laivan
     *
     * @return Laivan joka seuraavaksi sijoitetaan ruudukkoon
     */
    public Laiva laivojenlaittaminen() {
        Laiva laiva = laivat.get(laivojalaitettu);
        return laiva;
    }
}
