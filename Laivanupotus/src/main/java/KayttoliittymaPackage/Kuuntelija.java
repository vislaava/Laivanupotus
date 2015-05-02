/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.List;
import javax.swing.JLabel;
import upotus.laivanupotus.pelialusta.Peliruutu;

/**
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

    public Kuuntelija(Peli peli, Nappienkirjoittaja kirjuri, JLabel tekstiPaneeli) {
        this.pelaaja = pelaaja;
        this.peli = peli;
        this.kirjuri = kirjuri;
        this.tekstiPaneeli = tekstiPaneeli;
        this.loppu = false;
    }

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
    }

}
