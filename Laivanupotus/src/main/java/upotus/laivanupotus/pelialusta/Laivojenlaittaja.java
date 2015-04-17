/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import upotus.laivanupotus.peliruudukko.Ruudukko;

/**
 *
 * @author Tanja
 */
public class Laivojenlaittaja {
    private List<Laiva> laivaluettelo;
    private Laiva laiva;
    private Ruudukko ruudukko;
    private Ruudukontulostaja tulostaja;
    private Lukija ruudunlukija;

    Laivojenlaittaja(Ruudukko ruudukko, Ruudukontulostaja tulostaja, Lukija ruudunlukija) {
        this.ruudukko = ruudukko;
        this.tulostaja = tulostaja;
        this.ruudunlukija = ruudunlukija;
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
    
    public boolean SijoitaLaivat() {
        for (Laiva laiva : laivaluettelo) {
            while (true) {
                System.out.println(tulostaja.TulostaRuudukko(false));
                System.out.println("Laivan pituus on " + laiva.getPituus());
                int x = ruudunlukija.KysyX();
                int y = ruudunlukija.KysyY();
                boolean vaaka = ruudunlukija.KysyVaaka();
                if (ruudukko.lisaaLaiva(x, y, laiva.getPituus(), vaaka) == true) {
                    break;
                }
                
            }
        }
        return true;
    }
    
}
