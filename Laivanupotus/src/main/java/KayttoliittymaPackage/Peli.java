/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import java.util.List;
import upotus.laivanupotus.pelialusta.Laiva;
import upotus.laivanupotus.pelialusta.Laivavarasto;
import upotus.laivanupotus.peliruudukko.Ruudukko;

/**
 *
 * @author Tanja
 */
public class Peli {
    
    /**
     * Luokka luo kummallekin pelaajalle ruudukon ja Kuuntelijan kutsumana toteuttaa kulloisenkin vuoron.
     * Pitää huolta myös vuoroista.
     */

    private Ruudukko ruudukko1;
    private Ruudukko ruudukko2;
    private int kierroslaskuri = 0;
    private int laivojalaitettu = 0;
    private Laivavarasto varasto;
    private List<Laiva> laivat;
    private boolean laitetaankoLaivoja = true;
    private boolean pelaajan1vuoro = true;

    public Peli() {
        this.varasto = new Laivavarasto();
        laivat = varasto.getLaivat();
        this.ruudukko1 = new Ruudukko();
        this.ruudukko2 = new Ruudukko();
    }
    
    public Ruudukko getRuudukko() {
        return ruudukko1;
    }
    
    public boolean getLaivojenlaittaminen() {
        return laitetaankoLaivoja;
    }
    
    /**
     * LaitetaankoLaivoja
     * 
     * Metodi pitää kirjaa siitä onko laivojenlaittotilanne ja pelaajien vuoron vaihtumisesta kesken sen.
     */

    public void LaitetaankoLaivoja() {
        if (laivojalaitettu == 8) {
            laivojalaitettu = 0;
            if (pelaajan1vuoro) {
                pelaajan1vuoro = false;
            } else {
                laitetaankoLaivoja = false;
            }
        }
    }
    
    /**
     * TapahtumaRuudussa
     * 
     * Metodi vastaa Kuuntelijan kutsuun ja toteuttaa napin painallukseen reaktiona 
     * tapahtuman, joka luokan kirjanpidon perusteella on ajankohtainen
     * 
     * @param x parametrit ruudukon parametreja
     * @param y
     * @param vaaka
     * @return palauttaa sanalliset ohjeet ja palautteen pelaajalle
     */

    public String TapahtumaRuudussa(int x, int y, boolean vaaka) {
        // Laitetaan laivat
        if (laitetaankoLaivoja == true) {
            if (pelaajan1vuoro == true) {
                if (ruudukko1.lisaaLaiva(x, y, Laivojenlaittaminen().getPituus(), vaaka) == true) {
                    laivojalaitettu++;
                    LaitetaankoLaivoja();
                    return "Laiva sopii siihen.";
                } else {
                    return "Laiva ei sovi tähän, koita toista paikkaa.";
                }
            } else {
                if (ruudukko2.lisaaLaiva(x, y, Laivojenlaittaminen().getPituus(), vaaka) == true) {
                    laivojalaitettu++;
                    LaitetaankoLaivoja();
                    return "Laiva sopii siihen.";
                } else {
                    LaitetaankoLaivoja();
                    return "Laiva ei sovi tähän, koita toista paikkaa.";
                }
            }
        } else {
            return "Blöö";
        }
    }
    
    /**
     * Laivojenlaittaminen
     * 
     * Metodi antaa vuorossa olevan laivan
     * @return Laivan joka seuraavaksi sijoitetaan ruudukkoon
     */

    public Laiva Laivojenlaittaminen() {
        Laiva laiva = laivat.get(laivojalaitettu);
        return laiva;
    }
}
