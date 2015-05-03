/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import upotus.laivanupotus.pelialusta.Peli;

/**
 *
 * @author Tanja
 */
class UusiPeliKuuntelija implements ActionListener {
    private Peli peli;
    private JFrame frame1;
    private JFrame frame2;
    private Nappienkirjoittaja kirjuri;

    public UusiPeliKuuntelija(Peli peli, JFrame frame1, JFrame frame2, Nappienkirjoittaja kirjuri) {
        this.peli = peli;
        this.frame1 = frame1;
        this.frame2 = frame2;
        this.kirjuri = kirjuri;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.resetPeli();
        kirjuri.Kirjaintenmuuttaminen(peli.getRuudukko(), peli.getLaivojenlaittaminen());
        frame1.setVisible(true);
        frame2.setVisible(false);
        System.out.println("blaaaaa");
    }
    
}
