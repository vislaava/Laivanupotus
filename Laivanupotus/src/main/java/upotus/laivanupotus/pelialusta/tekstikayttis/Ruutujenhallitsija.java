/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta.tekstikayttis;
import upotus.laivanupotus.pelialusta.Laivavarasto;
import upotus.laivanupotus.pelialusta.Laivavarasto;
import upotus.laivanupotus.peliruudukko.Ruudukko;
/**
 * Ruutujenhallitsija
 * 
 * Toteuttaa melko paljon samankaltaisia tehtäviä kuin Peli-luokka.
 * Luo pelaajille omat ruudukot ja asettaa käyntiin laivojenlaittamisen ja pelaamisen.
 * @author Tanja
 */
public class Ruutujenhallitsija {
    
    /**
     * Luokka kuuluu tekstikäyttöliittymään ja alkaa olla melko turha. GUIn kanssa toimii luokka Peli.
     */
    
    private Peliruutu pelaaja1;
    private Laivavarasto laivat1;
    private Peliruutu pelaaja2;
    private Laivavarasto laivat2;
    private Ruudukko ruudukko;
    
    public Ruutujenhallitsija() {
        ruudukko = new Ruudukko();
        this.pelaaja1 = new Peliruutu(ruudukko);
        this.laivat1 = pelaaja1.getLaivojenlaittaja();
        this.pelaaja2 = new Peliruutu(ruudukko);
        this.laivat2 = pelaaja2.getLaivojenlaittaja();
    }
    
    public Peliruutu getPelaaja1() {
        return pelaaja1;
    }
    
    public Peliruutu getPelaaja2() {
        return pelaaja2;
    }
    
    /**
     * SijoitetaanLaivat
     * 
     * Metodi käskee pelaajia sijoittamaan laivansa ja kutsuu laivoja, jotta ne voidaan sijoittaa.
     */
    
    public void sijoitetaanLaivat() {
        System.out.println("Pelaaja 1, sijoita laivasi.");
        laivat1.sijoitaLaivat();
        System.out.println("Pelaaja 2, sijoita laivasi.");
        laivat2.sijoitaLaivat();
    }
    
    /**
     * PelataanKierros
     * 
     * Metodi toteuttaa yhden pelikierroksen, jossa kumpikin pelaaja osallistuu kerran.
     */
    
    public void pelataanKierros() {
        pelaaja1.kierros(pelaaja2);
        pelaaja2.kierros(pelaaja1);
    }
}
