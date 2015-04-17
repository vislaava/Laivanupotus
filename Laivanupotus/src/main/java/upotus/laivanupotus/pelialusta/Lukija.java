/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.pelialusta;

import java.util.Scanner;

/**
 *
 * @author Tanja
 */
public class Lukija {
    private Scanner lukija = new Scanner(System.in);
    
    public Lukija() {
        
    }
    
    public int KysyX() {
        System.out.println("Anna koordinaatti x");
        int x = Integer.parseInt(lukija.nextLine());
        return x;
    }
    
    public int KysyY() {
        System.out.println("Anna koordinaatti y");
        int y = Integer.parseInt(lukija.nextLine());
        return y;
    }
    
    public boolean KysyVaaka() {
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
