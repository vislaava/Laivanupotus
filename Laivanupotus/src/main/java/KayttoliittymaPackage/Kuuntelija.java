/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import upotus.laivanupotus.pelialusta.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.List;
import javax.swing.JLabel;
import upotus.laivanupotus.pelialusta.tekstikayttis.Peliruutu;

/**
 * Kuuntelija
 *
 * Luokka kuuntelee peli-ikkunan nappiruudukkoa, jossa itse laivanupotus-peli
 * tapahtuu
 *
 * @author Tanja
 */
public class Kuuntelija implements ActionListener {

    private boolean onkoPeliAlkanut = false;
    private OmaButton nappi;
    private Peliruutu pelaaja;
    private Peli peli;
    private Nappienkirjoittaja kirjuri;
    private JLabel tekstiPaneeli;
    private boolean loppu;
    private Ohjeidentulostaja ohjetulostaja;

    public Kuuntelija(Peli peli, Nappienkirjoittaja kirjuri, JLabel tekstiPaneeli, Ohjeidentulostaja ohjetulostaja) {
        this.pelaaja = pelaaja;
        this.peli = peli;
        this.kirjuri = kirjuri;
        this.tekstiPaneeli = tekstiPaneeli;
        this.loppu = false;
        this.ohjetulostaja = ohjetulostaja;
    }

    /**
     * setLoppu
     *
     * Kun joku on voittanut, asettaa boolean-arvon todeksi jolloin
     * ruudukkonappien kuuntelija lopettaa kuuntelemisen, eikä peli voi jatkua
     */
    public void setLoppu() {
        loppu = true;
    }

    /**
     * actionPerformed
     *
     * Metodi kuuntelee hiirenklikkauksen ja saa tietona ruudun koordinaatit ja
     * riippuen klikkauksen kanssa shiftin painamisesta, laivan asennon
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        ohjetulostaja.Tulosta();
        if (peli.getLoppuiko() == false) {
            boolean vaaka;
            if ((ae.getModifiers() & InputEvent.SHIFT_MASK) != 0) {
                vaaka = false;
            } else {
                vaaka = true;
            }
            nappi = (OmaButton) ae.getSource();
            tekstiPaneeli.setText(peli.TapahtumaRuudussa(nappi.getParX(), nappi.getParY(), vaaka));
            kirjuri.Kirjaintenmuuttaminen(peli.getRuudukko(), peli.getLaivojenlaittaminen());            
        } else {
            return;
        }
        ohjetulostaja.Tulosta();
    }

}
