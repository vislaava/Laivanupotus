/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import upotus.laivanupotus.pelialusta.Peliruutu;
import upotus.laivanupotus.peliruudukko.Ruutu;

/**
 *
 * @author Tanja
 */
public class GUI implements Runnable {
    
    private JFrame frame;
    private GridLayout ruudukkoonAsettelija;
    private ArrayList<OmaButton> napit1;
    private ArrayList<OmaButton> napit2;
    private Nappienkirjoittaja kirjuri1;
    private Nappienkirjoittaja kirjuri2;
    private Peli peli;
    
    public GUI() {
        ruudukkoonAsettelija = new GridLayout(10,10);
        this.napit1 = new ArrayList<OmaButton>();
        this.napit2 = new ArrayList<OmaButton>();
        this.peli = new Peli();
    }

    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(ruudukkoonAsettelija);
        Ruutu[][] ruudut1 = peli.getRuudukko().getRuudut();
        
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                OmaButton nappi = new OmaButton(ruudut1[x][y], x, y);
                container.add(nappi);
                napit1.add(nappi);
            }
        }
        
        Ruutu[][] ruudut2= peli.getRuudukko().getRuudut();
        
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                OmaButton nappi = new OmaButton(ruudut1[x][y], x, y);
                container.add(nappi);
                napit2.add(nappi);
            }
        }
        
        this.kirjuri1 = new Nappienkirjoittaja(napit1);
        
        this.kirjuri2 = new Nappienkirjoittaja(napit2);
        
        for(OmaButton nappi : napit1) {
            nappi.addActionListener(new Kuuntelija(peli, kirjuri1));
        }
        
        for(OmaButton nappi : napit2) {
            nappi.addActionListener(new Kuuntelija(peli, kirjuri2));
        }
        
    }
    
}
