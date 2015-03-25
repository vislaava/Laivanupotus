/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.tilastot;

import java.util.TreeMap;
import upotus.laivanupotus.pelaajatiedot.Nimivarasto;
import upotus.laivanupotus.pelaajatiedot.Voitot;
/**
 *
 * @author Tanja
 */
public class Tilastojentekija {
    private Nimivarasto varasto;
    private VoittojenVertailija voittojenVertailija;
    private TreeMap<String,Voitot> jarjestettyVarastoVoitot; 
    
    public Tilastojentekija(Nimivarasto varasto) {
        this.varasto = varasto;
        this.voittojenVertailija = new VoittojenVertailija(varasto.getLista());
        this.jarjestettyVarastoVoitot = new TreeMap<String,Voitot>(voittojenVertailija);
    }
    
    public String VoittajaLuettelo() {
        jarjestettyVarastoVoitot.putAll(varasto.getLista());
        String luettelo = "";
        
        System.out.println(jarjestettyVarastoVoitot.get("Tupu"));
        
        for(String avain : jarjestettyVarastoVoitot.keySet()) {
            luettelo = luettelo + (avain + " " + Integer.toString(jarjestettyVarastoVoitot.get(avain).getVoitot()) + "\n");
        }
        return luettelo;
    }
}
