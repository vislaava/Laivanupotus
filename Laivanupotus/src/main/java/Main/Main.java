/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import KayttoliittymaPackage.GUI;
import javax.swing.SwingUtilities;
import upotus.laivanupotus.pelialusta.Peliruutu;
import upotus.laivanupotus.pelialusta.Laivavarasto;
import upotus.laivanupotus.pelialusta.Ruutujenhallitsija;

/**
 *
 * @author Tanja
 */
public class Main {
    public static void main(String [] args) {
        GUI kayttoliittyma = new GUI();
        SwingUtilities.invokeLater(kayttoliittyma);

        

        
    }
}
