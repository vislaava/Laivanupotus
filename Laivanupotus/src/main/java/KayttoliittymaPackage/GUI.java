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
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import upotus.laivanupotus.pelialusta.Peliruutu;
import upotus.laivanupotus.peliruudukko.Ruutu;

/**
 *
 * @author Tanja
 */
public class GUI implements Runnable {
    
    private JFrame frame;
    private JPanel ruutuPaneeli;
    private GridLayout ruudukkoonAsettelija;
    private ArrayList<OmaButton> napit;
    private ArrayList<OmaButton> napit2;
    private Nappienkirjoittaja kirjuri;
    private Nappienkirjoittaja kirjuri2;
    private Peli peli;
    
    public GUI() {
        ruudukkoonAsettelija = new GridLayout(10,10);
        this.napit = new ArrayList<OmaButton>();
        this.napit2 = new ArrayList<OmaButton>();
        this.peli = new Peli();
    }

    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ruutuPaneeli = new JPanel();
        ruutuPaneeli.setPreferredSize(new Dimension(400, 400));
        
        luoRuudukko(ruutuPaneeli);
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoRuudukko(Container container) {
        container.setLayout(ruudukkoonAsettelija);
        Ruutu[][] ruudut = peli.getRuudukko().getRuudut();
        
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                OmaButton nappi = new OmaButton(x, y);
                container.add(nappi);
                napit.add(nappi);
            }
        }
        
        this.kirjuri = new Nappienkirjoittaja(napit);
                
        for(OmaButton nappi : napit) {
            nappi.addActionListener(new Kuuntelija(peli, kirjuri));
        }
    }
    
}
