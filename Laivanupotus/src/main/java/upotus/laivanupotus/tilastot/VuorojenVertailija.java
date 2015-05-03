/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.tilastot;

import java.util.Comparator;
import java.util.Map;
import upotus.laivanupotus.pelaajatiedot.Voitot;

/**
 * VuorojenVertailija
 * 
 * metodi asettaa pelaajat järjestykseen sen mukaan kuka on voittanut nopeimmin
 * 
 * @author Tanja
 */
class VuorojenVertailija implements Comparator <String>{
    private Map<String, Voitot> lista;

    public VuorojenVertailija(Map lista) {
        this.lista = lista;
    }
    
    /**
     * Compare
     * 
     * metodi eroaa tavallisesta comparesta sen osalta, että se ei palauta nollaa
     * jotta kaikki pelaajat tulisivat tallennetuksi
     * @param a
     * @param b
     * @return 
     */

    @Override
    public int compare(String a, String b) {
        if (lista.get(a).siirtojaKeskimaarin() >= lista.get(b).siirtojaKeskimaarin()) {
            return 1;
        } else {
            return -1;
        }
    }
    
    
    
}
