/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta;

import upotus.laivanupotus.pelialusta.tekstikayttis.Ruudukontulostaja;
import kayttoliittymaPackage.Ohjeidentulostaja;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import upotus.laivanupotus.peliruudukko.Ruudukko;

/**
 * Säilyttää ja luo sen määrän laivoja, joita
 * pitää pelaajan sijoittaa ruudukkoon. Vaihtoehtoiset konstruktorit tekstikäyttöliittymälle a GUIlle
 * @author Tanja
 */
public class Laivavarasto {
    private List<Laiva> laivaluettelo;
    private Laiva laiva;
    private Ruudukko ruudukko;
    private Ruudukontulostaja tulostaja;
    private Lukija ruudunlukija;
    private Ohjeidentulostaja teksti;

    public Laivavarasto(Ruudukko ruudukko, Ruudukontulostaja tulostaja, Lukija ruudunlukija) {
        this.ruudukko = ruudukko;
        this.tulostaja = tulostaja;
        this.ruudunlukija = ruudunlukija;
        this.teksti = teksti;
        this.laivaluettelo = new ArrayList();
        laivaluettelo.add(new Laiva(5));
        laivaluettelo.add(new Laiva(4));
        laivaluettelo.add(new Laiva(3));
        laivaluettelo.add(new Laiva(2));
        laivaluettelo.add(new Laiva(2));
        laivaluettelo.add(new Laiva(1));
        laivaluettelo.add(new Laiva(1));
        laivaluettelo.add(new Laiva(1));
    }
    
    public Laivavarasto() {
        this.ruudukko = ruudukko;
        this.tulostaja = tulostaja;
        this.ruudunlukija = ruudunlukija;
        this.teksti = teksti;
        this.laivaluettelo = new ArrayList();
        laivaluettelo.add(new Laiva(5));
        laivaluettelo.add(new Laiva(4));
        laivaluettelo.add(new Laiva(3));
        laivaluettelo.add(new Laiva(2));
        laivaluettelo.add(new Laiva(2));
        laivaluettelo.add(new Laiva(1));
        laivaluettelo.add(new Laiva(1));
        laivaluettelo.add(new Laiva(1));
    }
    
    /**
     * getLaivat
     * 
     * @return List laivoista
     */
    
    public List<Laiva> getLaivat() {
        return laivaluettelo;
    }
    
    /**
     * SijoitaLaivat
     * 
     * Metodi kertoo mikä laiva laitetaan seuraavaksi ja jos koordinaatit ovat sopivat, laittaa laivan
     * @return palauttaa truen kun laivat on asetettu
     */
    
    public boolean sijoitaLaivat() {
        for (Laiva laiva : laivaluettelo) {
            while (true) {
                System.out.println(tulostaja.tulostaRuudukko(false));
                System.out.println("Laivan pituus on " + laiva.getPituus());
                int x = ruudunlukija.kysyX();
                int y = ruudunlukija.kysyY();
                boolean vaaka = ruudunlukija.kysyVaaka();
                if (ruudukko.lisaaLaiva(x, y, laiva.getPituus(), vaaka) == true) {
                    break;             
                }
                                
            }
        }
        return true;
    }
    
}
