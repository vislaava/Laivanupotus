/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelaajatiedot;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tanja
 */
public class Nimivarasto {
    private Map <String, Voitot> nimilista;

    public Nimivarasto() {
        this.nimilista = new HashMap < String, Voitot>();
    }
    
    public void LuoKayttaja(String nimi) {
        nimilista.put(nimi, new Voitot());
    }
    
    public Map getLista() {
        return nimilista;
    }
    
    public String tulostaKayttajatiedot(String nimi) {
        return nimilista.toString();
    }
    
    public void PaivitaKayttajanTietoja(String nimi, int siirrot) {
        nimilista.get(nimi).LisaaVoitto();
        nimilista.get(nimi).PaivitaSiirrot(siirrot);
    }
    
    public boolean TallennaKayttajatTekstitiedostoon() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("kayttajatiedot.txt", "UTF-8");
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löydy.");
            return false;
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Ohjelma ei pysty käsittelemään annettua merkistöä.");
            return false;
        }
        for (String kayttaja : nimilista.keySet()) {
            String kayttajanRivi = kayttaja + nimilista.get(kayttaja).toString();
            writer.println(kayttajanRivi);
        }
        writer.close();
        return true;
    }
}
