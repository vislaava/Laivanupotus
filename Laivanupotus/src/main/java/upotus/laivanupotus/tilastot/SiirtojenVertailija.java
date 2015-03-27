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
 *
 * @author Tanja
 */
class SiirtojenVertailija implements Comparator <String>{
    private Map<String, Voitot> lista;

    public SiirtojenVertailija(Map lista) {
        this.lista = lista;
    }

    @Override
    public int compare(String a, String b) {
        if (lista.get(a).SiirtojaKeskimaarin() >= lista.get(b).SiirtojaKeskimaarin()) {
            return 1;
        } else {
            return -1;
        }
    }
    
    
    
}
