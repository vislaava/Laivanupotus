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
    Peliruutu pelaaja1 = new Peliruutu();
    Laivojenlaittaja laivat1 = pelaaja1.getLaivojenlaittaja();
    Peliruutu pelaaja2 = new Peliruutu();
    Laivojenlaittaja laivat2 = pelaaja2.getLaivojenlaittaja();
    
    public Ruutujenhallitsija() {
        
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
