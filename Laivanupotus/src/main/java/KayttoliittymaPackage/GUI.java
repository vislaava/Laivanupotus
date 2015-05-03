/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import upotus.laivanupotus.pelialusta.Peli;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorListener;
import upotus.laivanupotus.pelaajatiedot.Nimivarasto;
import upotus.laivanupotus.pelialusta.tekstikayttis.Peliruutu;
import upotus.laivanupotus.peliruudukko.Ruutu;

/**
 *
 * @author Tanja
 */
public class GUI implements Runnable {

    private JFrame frame1;
    private JLabel aloitusTeksti;
    private JTextField kirjoituskentta1;
    private JTextField kirjoituskentta2;
    private JButton aloitusnappi;
    private AloitusruutuKuuntelija aloitusruutu;
    private Nimivarasto nimivarasto;

    private JFrame frame2;
    private JPanel ruutuPaneeli;
    private JPanel tekstiPaneeli;
    private JPanel nappiPaneeli;
    private JLabel tekstiLabel;
    private JLabel ohjeLabel;
    private JButton voitotTilastoNappi;
    private JButton vuorotTilastoNappi;
    private JButton uusiPeliNappi;
    private GridLayout ruudukkoonAsettelija;
    private ArrayList<OmaButton> napit;
    private ArrayList<OmaButton> napit2;
    private Nappienkirjoittaja kirjuri;
    private Nappienkirjoittaja kirjuri2;
    private Peli peli;
    private Tilastokuuntelija tilastokuuntelija;
    private UusiPeliKuuntelija uusikuuntelija;
    private Ohjeidentulostaja ohjetulostaja;
    
    private JFrame frame3;
    private JLabel tilastoLabel;

    public GUI() {
        ruudukkoonAsettelija = new GridLayout(10, 10);
        this.napit = new ArrayList<OmaButton>();
        this.napit2 = new ArrayList<OmaButton>();
        this.nimivarasto = new Nimivarasto();
        this.peli = new Peli(nimivarasto);
    }

    /**
     * run
     * 
     * Metodi luo kaikki ikkunat ja niiden komponentit
     */
    
    @Override
    public void run() {
        
        //Aloitusframe
        frame1 = new JFrame("Aloitusruutu");
        frame1.setPreferredSize(new Dimension(500, 300));
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.Y_AXIS));

        //Aloitusframen komponentit
        aloitusTeksti = new JLabel();
        aloitusTeksti.setPreferredSize(new Dimension(300, 100));
        kirjoituskentta1 = new JTextField();
        kirjoituskentta1.setPreferredSize(new Dimension(300, 50));
        kirjoituskentta2 = new JTextField();
        kirjoituskentta2.setPreferredSize(new Dimension(300, 50));
        aloitusnappi = new JButton();
        aloitusnappi.setPreferredSize(new Dimension(200, 50));

        //Aloitusframen komponenttien lisääminen
        frame1.getContentPane().add(aloitusTeksti);
        frame1.getContentPane().add(kirjoituskentta1);
        frame1.getContentPane().add(kirjoituskentta2);
        frame1.getContentPane().add(aloitusnappi);
        
        //Peliframen luonti
        frame2 = new JFrame("Laivanupotus");
        frame2.setPreferredSize(new Dimension(850, 400));
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setLayout(new BorderLayout());
        
        //Tilastoframen luonti
        frame3 = new JFrame("Tilastot");
        frame3.setPreferredSize(new Dimension(500, 400));
        frame3.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        tilastoLabel = new JLabel();
        tilastoLabel.setPreferredSize(new Dimension(450, 350));
        frame3.add(tilastoLabel);
        frame3.pack();
        
        //Aloitusframen komponentit
        aloitusruutu = new AloitusruutuKuuntelija(kirjoituskentta1, kirjoituskentta2, nimivarasto, peli, frame1, frame2);
        aloitusnappi.addActionListener(aloitusruutu);
        aloitusTeksti.setText("Kirjoita riveille pelaajien nimet.");
        aloitusnappi.setText("Aloita peli");

        //Aloitusframen näkyviin asettaminen
        frame1.pack();
        frame1.setVisible(true);

        //Peliframen komponenttien luonti
        ruutuPaneeli = new JPanel();
        ruutuPaneeli.setPreferredSize(new Dimension(400, 400));
        tekstiPaneeli = new JPanel();
        tekstiPaneeli.setPreferredSize(new Dimension(400, 400));
        tekstiLabel = new JLabel();
        tekstiLabel.setPreferredSize(new Dimension(300, 200));
        tekstiPaneeli.setLayout(new BorderLayout());
        ohjeLabel = new JLabel();
        ohjetulostaja = new Ohjeidentulostaja(ohjeLabel, peli);
        aloitusruutu.tuoOhjetulostaja(ohjetulostaja);
        
        //Peliframen nappipaneeli
        nappiPaneeli = new JPanel();
        nappiPaneeli.setLayout(new BoxLayout(nappiPaneeli, BoxLayout.X_AXIS));
        voitotTilastoNappi = new JButton();
        vuorotTilastoNappi = new JButton();
        uusiPeliNappi = new JButton();
        
        //Peliframen nappien käsittely
        voitotTilastoNappi.setText("Voittotilasto");
        vuorotTilastoNappi.setText("Vuorotilasto");
        uusiPeliNappi.setText("Uusi peli");
        tilastokuuntelija = new Tilastokuuntelija(voitotTilastoNappi, vuorotTilastoNappi, tilastoLabel, nimivarasto, frame3);
        voitotTilastoNappi.addActionListener(tilastokuuntelija);
        vuorotTilastoNappi.addActionListener(tilastokuuntelija);
        
        
        
        //Nappipaneelin nappien lisäys
        nappiPaneeli.add(voitotTilastoNappi);
        nappiPaneeli.add(vuorotTilastoNappi);
        nappiPaneeli.add(uusiPeliNappi);

        //Nappiruudukon tekeminen
        luoRuudukko(ruutuPaneeli);
        uusikuuntelija = new UusiPeliKuuntelija(peli, frame1, frame2, kirjuri);
        uusiPeliNappi.addActionListener(uusikuuntelija);
        
        //Peliframen komponenttien lisäys
        frame2.getContentPane().add(ruutuPaneeli, BorderLayout.WEST);
        frame2.getContentPane().add(tekstiPaneeli, BorderLayout.EAST);
        tekstiPaneeli.add(tekstiLabel, BorderLayout.SOUTH);
        tekstiPaneeli.add(ohjeLabel, BorderLayout.CENTER);
        tekstiPaneeli.add(nappiPaneeli, BorderLayout.NORTH);

        frame2.pack();
    }
    
    /**
     * luoRuudukko
     * 
     * Luo JPaneliin 100:n ruudun ruudukon ja asettaa nappeihin kuuntelijan. 
     * Kuuntelijaan lisätään parametrina Peli-olio, nappienkirjoitus-olio ja 
     * JLabel-olio, joka antaa palautetta tehdyistä siirroista.
     * 
     * @param paneeli, johon asetetaan napit 
     */

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
        kirjuri = new Nappienkirjoittaja(napit);
        Kuuntelija korva = new Kuuntelija(peli, kirjuri, tekstiLabel, ohjetulostaja);
        for (OmaButton nappi : napit) {
            nappi.addActionListener(korva);
        }
    }
}
