/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta;

import upotus.laivanupotus.pelaajatiedot.Nimivarasto;

/**
 * Lopettaja
 * 
 * Luokkaa kutsutaan, kun jonkun pelaajan vuoron päätteeksi vastapelaajalla ei ole enää laivoja
 * @author Tanja
 */
public class Lopettaja {
    private Nimivarasto nimivarasto;
    
    
    public Lopettaja(Nimivarasto nimivarasto) {
        this.nimivarasto = nimivarasto;
    }
    
    /**
     * Lopeta
     * 
     * Metodi tallentaa voittaneen pelaajan tiedostoon
     * @param vuorot kuinka monta vuoroa tarvittiin voittoon
     * @param onko1pelaaja kumpi pelaaja kyseessä
     * @param nimi pelaajan nimi
     */
    
    public void lopeta(int vuorot, boolean onko1pelaaja, String nimi) {
        nimivarasto.luoKayttaja(nimi);
        nimivarasto.paivitaKayttajanTietoja(nimi, vuorot);
        nimivarasto.tallennaKayttajatTiedostoon();
    }
    
}
