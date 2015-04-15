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
    Scanner lukija = new Scanner(System.in);
    private Ruudukko ruudukko;
    private Ruudukontulostaja tulostaja;

    Laivojenlaittaja(Ruudukko ruudukko, Ruudukontulostaja tulostaja) {
        this.ruudukko = ruudukko;
        this.tulostaja = tulostaja;
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
        int x = 0;
        int y = 0;
        boolean vaaka = true;
        for (Laiva laiva : laivaluettelo) {
            System.out.println("Laivan pituus on " + laiva.getPituus());
            x = KysyX();
            y = KysyY();
            vaaka = KysyVaaka();
            ruudukko.lisaaLaiva(x, y, laiva.getPituus(), vaaka);
            tulostaja.TulostaRuudukko(false);
        }
        return true;
    }
    
    private int KysyX() {
        System.out.println("Anna koordinaatti x");
        int x = lukija.nextInt();
        return x;
    }
    
    private int KysyY() {
        System.out.println("Anna koordinaatti y");
        int y = lukija.nextInt();
        return y;
    }
    
    private boolean KysyVaaka() {
        while (true) {
            System.out.println("Anna suunta. Vaaka = v; pysty = p");
            String suunta = lukija.nextLine();
            if (suunta.equals("v")) {
                return true;
            } else if (suunta.equals("p")) {
                return false;
            } else {
                System.out.println("Väärä merkki.");
            }
        }
    }
    
}
