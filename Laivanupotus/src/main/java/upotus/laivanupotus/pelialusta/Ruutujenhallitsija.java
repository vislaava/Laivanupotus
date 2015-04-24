/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta;
import upotus.laivanupotus.pelialusta.Peliruutu;
import upotus.laivanupotus.pelialusta.Laivojenlaittaja;
/**
 *
 * @author Tanja
 */
public class Ruutujenhallitsija {
    Peliruutu pelaaja1;
    Laivojenlaittaja laivat1;
    Peliruutu pelaaja2;
    Laivojenlaittaja laivat2;
    
    public Ruutujenhallitsija() {
        this.pelaaja1 = new Peliruutu();
        this.laivat1 = pelaaja1.getLaivojenlaittaja();
        this.pelaaja2 = new Peliruutu();
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
