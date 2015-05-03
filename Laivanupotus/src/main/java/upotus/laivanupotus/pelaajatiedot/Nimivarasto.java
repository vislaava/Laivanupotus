/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelaajatiedot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Nimivarasto
 *
 * Luokka säilyttää ja käsittelee käyttäjien nimiä ja voittojen ja siirtojen
 * määriä.
 *
 * @author Tanja
 */
public class Nimivarasto {

    private Map<String, Voitot> nimilista;

    public Nimivarasto() {
        this.nimilista = LueTiedosto();
    }

    /**
     * LuoKayttaja
     *
     * Metodi luo käyttäjän ja käyttäjälle voitto-olion, jotka tallennetaan
     * HashMap:iin. Nimi on avain.
     *
     * @param nimi
     */
    public void LuoKayttaja(String nimi) {
        if (nimilista.containsKey(nimi)) {
            return;
        } else {
            nimilista.put(nimi, new Voitot());
        }
    }
    
    /**
     * LueTiedosto
     * 
     * Metodi lukee .ser-tiedostosta nimilista-mapin ja palauttaa sen konstruktorille
     * tai jos tiedostoa ei ole, luo sellaisen.
     * @return nimilista-map
     */

    private Map LueTiedosto() {
        try {
            FileInputStream fis = new FileInputStream("hashmap.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            nimilista = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return new HashMap< String, Voitot>();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return new HashMap< String, Voitot>();
        }
        return nimilista;
    }

    public Map getLista() {
        return nimilista;
    }

    /**
     * tulostaKayttajatiedot
     *
     * @param nimi
     * @return String-esitys nimiliststa
     */
    public String tulostaKayttajatiedot(String nimi) {
        return nimilista.toString();
    }

    /**
     * PaivitaKayttajanTietoja
     *
     * Metodi lisää pelaajalle voiton ja lisää käytetys siirrot
     *
     * @param nimi
     * @param siirrot
     */
    public void PaivitaKayttajanTietoja(String nimi, int siirrot) {
        nimilista.get(nimi).LisaaVoitto();
        nimilista.get(nimi).PaivitaSiirrot(siirrot);
    }
    
    /**
     * Tallenna KayttajatTiedostoon
     * 
     * Metodi tallentaa nimilistan .ser-tiedostoon
     * @return palauttaa truen kun onnistuu
     */

    public boolean TallennaKayttajatTiedostoon() {
        try {
            FileOutputStream kayttajatiedosto = new FileOutputStream("hashmap.ser");
            ObjectOutputStream oos = new ObjectOutputStream(kayttajatiedosto);
            oos.writeObject(nimilista);
            oos.close();
            kayttajatiedosto.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return true;
    }

    /**
     * TallennaKayttajatTekstitiedostoon
     *
     * Metodi tallentaa käyttäjän ja hänen voittotietonsa tekstitiedostoon
     *
     * @return palauttaa truen kun onnistuu tallentamaan.
     */
//    public boolean TallennaKayttajatTekstitiedostoon() {
//        PrintWriter writer;
//        try {
//            writer = new PrintWriter("kayttajatiedot.txt", "UTF-8");
//        } catch (FileNotFoundException ex) {
//            System.out.println("Tiedostoa ei löydy.");
//            return false;
//        } catch (UnsupportedEncodingException ex) {
//            System.out.println("Ohjelma ei pysty käsittelemään annettua merkistöä.");
//            return false;
//        }
//        for (String kayttaja : nimilista.keySet()) {
//            String kayttajanRivi = kayttaja + nimilista.get(kayttaja).toString();
//            writer.println(kayttajanRivi);
//        }
//        writer.close();
//        return true;
//    }
}
