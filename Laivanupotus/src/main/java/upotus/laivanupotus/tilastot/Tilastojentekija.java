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
 *Tilastojentekija
 * 
 * Luokka tuottaa tilastoja voitoista ja niihin käytetyistä vuoroista
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
    
    /**
     * Voittajaluettelo
     * 
     * Metodi luo String-esityksen, jossa esitetään eniten voittoja saavuttaneet pelaajat
     * @return String-esitys eniten voittaneista pelaajista
     */
    
    public String VoittajaLuettelo() {
        this.jarjestettyVarastoVoitot = new TreeMap<String,Voitot>(voittojenVertailija);

        jarjestettyVarastoVoitot.putAll(varasto.getLista());
        String luettelo = "<html> Eniten voittoja: <br> <br>";
                
        for (Map.Entry<String, Voitot> entry : jarjestettyVarastoVoitot.entrySet()) {
            luettelo = luettelo + entry.getKey() + " " + entry.getValue() + "<br>";
        }
        
        luettelo = luettelo + "</html>";
        
        return luettelo;
    }
    
    /**
     * VahitenSiirtojaSuhteessaVoittoihinLuettelo
     * 
     * Metodi luo String-esityksen, jossa pelaajat asetetaan järjestykseen sen mukaan, kuka voittaa keskimäärin nopeimmin
     * @return String-esitys nopeimmista pelaajista
     */
    
    public String VahitenSiirtojaSuhteessaVoittoihinLuettelo() {
        this.jarjestettyVarastoVoitot = new TreeMap<String,Voitot>(siirtojenVertailija);
        
        jarjestettyVarastoVoitot.putAll(varasto.getLista());
        
        String luettelo = "<html> Vähiten siirtoja per voitot: <br> <br>";
        
        for (Map.Entry<String, Voitot> entry : jarjestettyVarastoVoitot.entrySet()) {
            luettelo = luettelo + entry.getKey() + " " + entry.getValue() + "<br>";
        }
        
        luettelo = luettelo + "</html>";
        
        return luettelo;
    }
    
    //testiluokkia varten metodit, joihin pelaajaporukat heitetään valmiiksi
    
    public String VoittajaLuettelo(Map mappi) {
        this.jarjestettyVarastoVoitot = new TreeMap<String,Voitot>(voittojenVertailija);

        jarjestettyVarastoVoitot.putAll(varasto.getLista());
        String luettelo = "<html>";
                
        for (Map.Entry<String, Voitot> entry : jarjestettyVarastoVoitot.entrySet()) {
            luettelo = luettelo + entry.getKey() + " " + entry.getValue() + "<br>";
        }
        
        luettelo = luettelo + "</html>";
                
        return luettelo;
    }

    String VähitenSiirtojaSuhteessaVoittoihinLuettelo(Map lista) {
        this.jarjestettyVarastoVoitot = new TreeMap<String,Voitot>(siirtojenVertailija);
        
        jarjestettyVarastoVoitot.putAll(varasto.getLista());
        String luettelo = "";
        
        for (Map.Entry<String, Voitot> entry : jarjestettyVarastoVoitot.entrySet()) {
            luettelo = luettelo + entry.getKey() + " " + entry.getValue();
        }
        
        return luettelo;
    }

}
