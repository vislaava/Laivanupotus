/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta;
import upotus.laivanupotus.pelialusta.Peliruutu;
import upotus.laivanupotus.pelialusta.Laivavarasto;
import upotus.laivanupotus.peliruudukko.Ruudukko;
/**
 *
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
    
    public void SijoitetaanLaivat() {
        System.out.println("Pelaaja 1, sijoita laivasi.");
        laivat1.SijoitaLaivat();
        System.out.println("Pelaaja 2, sijoita laivasi.");
        laivat2.SijoitaLaivat();
    }
    
    public void PelataanKierros() {
        pelaaja1.Kierros(pelaaja2);
        pelaaja2.Kierros(pelaaja1);
    }
}
