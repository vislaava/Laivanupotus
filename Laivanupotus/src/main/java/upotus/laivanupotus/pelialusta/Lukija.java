/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta;

import java.util.Scanner;

/**
 * Lukija
 *
 * Luokka hoitaa scanner-oliota ja kysyy pelaajalta sijaintitietoja ja suuntaa
 *
 * @author Tanja
 */
public class Lukija {

    private Scanner lukija = new Scanner(System.in);

    public Lukija() {

    }

    /**
     * KysyX
     *
     * Metodi pyytää x-janan kohdan
     *
     * @return palauttaa int:in joka kertoo missä kohtaa x-janalla ollaan
     */
    public int kysyX() {
        System.out.println("Anna koordinaatti x");
        int x;
        while(true) {
            x = Integer.parseInt(lukija.nextLine());
            if (x < 10 || x >= 0) {
                break;
            } else {
                System.out.println("Luvun pitää olla 0-9");
            }
        }
        return x;
    }

    /**
     * KysyY Metodi kysyy y-janan kohdan
     *
     * @return palauttaa y-intin
     */
    public int kysyY() {
        System.out.println("Anna koordinaatti y");
        int y;
        while (true) {
            y = Integer.parseInt(lukija.nextLine());
            if (y < 10 || y >= 0) {
                break;
            } else {
                System.out.println("Luvun pitää olla 0-9");
            }
        }
        return y;
    }

    /**
     * KysyVaaka
     *
     * Metodi kysyy laivan suunnan
     *
     * @return
     */
    public boolean kysyVaaka() {
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
