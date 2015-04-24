/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import KayttoliittymaPackage.Kayttoliittyma;
import javax.swing.SwingUtilities;
import upotus.laivanupotus.pelialusta.Peliruutu;
import upotus.laivanupotus.pelialusta.Laivojenlaittaja;
import upotus.laivanupotus.pelialusta.Ruutujenhallitsija;

/**
 *
 * @author Tanja
 */
public class Main {
    public static void main(String [] args) {
        Ruutujenhallitsija valtias = new Ruutujenhallitsija();
        Kayttoliittyma kayttoliittymaP1 = new Kayttoliittyma(valtias.getPelaaja1());
        SwingUtilities.invokeLater(kayttoliittymaP1);
        
        Kayttoliittyma kayttoliittymaP2 = new Kayttoliittyma(valtias.getPelaaja2());
        SwingUtilities.invokeLater(kayttoliittymaP2);
        
        valtias.SijoitetaanLaivat();
        valtias.PelataanKierros();
        

        
    }
}
