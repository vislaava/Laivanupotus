/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.tilastot;

import java.util.Map;
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
    private SiirtojenVertailija siirtojenVertailija;
    private TreeMap<String,Voitot> jarjestettyVarastoVoitot; 
    
    public Tilastojentekija(Nimivarasto varasto) {
        this.varasto = varasto;
        this.voittojenVertailija = new VoittojenVertailija(varasto.getLista());
        this.siirtojenVertailija = new SiirtojenVertailija(varasto.getLista());
    }
    
    public String VoittajaLuettelo(Map mappi) {
        this.jarjestettyVarastoVoitot = new TreeMap<String,Voitot>(voittojenVertailija);

        jarjestettyVarastoVoitot.putAll(varasto.getLista());
        String luettelo = "";
                
        for (Map.Entry<String, Voitot> entry : jarjestettyVarastoVoitot.entrySet()) {
            luettelo = luettelo + entry.getKey() + " " + entry.getValue();
        }
        
        return luettelo;
    }
    
    public String VähitenSiirtojaSuhteessaVoittoihinLuettelo(Map mappi) {
        this.jarjestettyVarastoVoitot = new TreeMap<String,Voitot>(siirtojenVertailija);
        
        jarjestettyVarastoVoitot.putAll(varasto.getLista());
        String luettelo = "";
        
        for (Map.Entry<String, Voitot> entry : jarjestettyVarastoVoitot.entrySet()) {
            luettelo = luettelo + entry.getKey() + " " + entry.getValue();
        }
        
        return luettelo;
    }
    
    

}
