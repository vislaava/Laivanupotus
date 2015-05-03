/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.tilastot;

import java.util.Comparator;
import java.util.Map;
import upotus.laivanupotus.pelaajatiedot.Nimivarasto;
import upotus.laivanupotus.pelaajatiedot.Voitot;

/**
 * VoittojenVertailija
 * 
 * Luokka järjestää pelaajat voittojen määrän mukaan
 * @author Tanja
 */
class VoittojenVertailija implements Comparator <String> {
    private Map<String, Voitot> lista;

    public VoittojenVertailija(Map lista) {
        this.lista = lista;
    }
    
    /**
     * Compare
     * 
     * Metodi poikkeaa tavallisesta comparesta sen suhteen, että se ei anna arvoksi nollaa
     * jotta jokainen pelaaja tulee tallennetuksi
     * @param a
     * @param b
     * @return 
     */

    @Override
    public int compare(String a, String b) {
        if (lista.get(a).getVoitot() >= lista.get(b).getVoitot()) {
            return -1;
        } else {
            return 1;
        }
    }
    
}
