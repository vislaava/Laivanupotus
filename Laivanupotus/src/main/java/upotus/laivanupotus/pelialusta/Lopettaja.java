/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta;

import upotus.laivanupotus.pelaajatiedot.Nimivarasto;

/**
 *
 * @author Tanja
 */
public class Lopettaja {
    private Nimivarasto nimivarasto;
    
    
    public Lopettaja(Nimivarasto nimivarasto) {
        this.nimivarasto = nimivarasto;
    }
    
    public void Lopeta(int kierrokset, boolean onko1pelaaja, String nimi) {
        nimivarasto.LuoKayttaja(nimi);
        nimivarasto.PaivitaKayttajanTietoja(nimi, kierrokset);
        nimivarasto.TallennaKayttajatTiedostoon();
    }
    
}
