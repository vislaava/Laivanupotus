/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import upotus.laivanupotus.pelialusta.Peliruutu;
import upotus.laivanupotus.peliruudukko.Ruutu;

/**
 *
 * @author Tanja
 */
public class GUI implements Runnable {
    
    private JFrame frame1;
    private JLabel aloitusTeksti;
    private JTextArea kirjoituskentta;
    private JButton aloitusnappi;
    private Aloitusruutu aloitusruutu;
    
    private JFrame frame2;
    private JPanel ruutuPaneeli;
    private JPanel tekstiPaneeli;
    private JLabel tekstiLabel;
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
        frame1 = new JFrame("Aloitusruutu");
        frame1.setPreferredSize(new Dimension(500, 500));
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        
        aloitusTeksti = new JLabel();
        aloitusTeksti.setPreferredSize(new Dimension(400, 100));
        kirjoituskentta = new JTextArea();
        kirjoituskentta.setPreferredSize(new Dimension(400, 100));
        aloitusnappi = new JButton();
        aloitusnappi.setPreferredSize(new Dimension(200, 100));
        
        frame1.getContentPane().add(aloitusTeksti, BorderLayout.NORTH);
        frame1.getContentPane().add(kirjoituskentta, BorderLayout.CENTER);
        frame1.getContentPane().add(aloitusnappi, BorderLayout.SOUTH);
        
        frame2 = new JFrame("Laivanupotus");
        frame2.setPreferredSize(new Dimension(850, 400));
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setLayout(new BorderLayout());
        
        ruutuPaneeli = new JPanel();
        ruutuPaneeli.setPreferredSize(new Dimension(400, 400));
        tekstiPaneeli = new JPanel();
        tekstiPaneeli.setPreferredSize(new Dimension(400, 400));
        tekstiLabel = new JLabel();
        tekstiLabel.setPreferredSize(new Dimension(300, 200));
        tekstiPaneeli.setLayout(new BorderLayout());
        
        luoRuudukko(ruutuPaneeli);
        
        frame2.getContentPane().add(ruutuPaneeli, BorderLayout.WEST);
        frame2.getContentPane().add(tekstiPaneeli, BorderLayout.EAST);
        tekstiPaneeli.add(tekstiLabel, BorderLayout.SOUTH);
        
        frame2.pack();
        frame2.setVisible(true);
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
        Kuuntelija korva = new Kuuntelija(peli, kirjuri, tekstiLabel);
        for(OmaButton nappi : napit) {
            nappi.addActionListener(korva);
        }
    }
    
}
