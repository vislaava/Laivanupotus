/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittymaPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import upotus.laivanupotus.pelialusta.Peli;

/**
 * Uusipelikuuntelija
 * 
 * Luokassa asetetaan ohjelma alkutilaan
 * @author Tanja
 */
class UusiPeliKuuntelija implements ActionListener {
    private Peli peli;
    private JFrame frame1;
    private JFrame frame2;
    private Nappienkirjoittaja kirjuri;
    private JLabel tekstilabel;

    public UusiPeliKuuntelija(Peli peli, JFrame frame1, JFrame frame2, Nappienkirjoittaja kirjuri, JLabel tekstilabel) {
        this.peli = peli;
        this.frame1 = frame1;
        this.frame2 = frame2;
        this.kirjuri = kirjuri;
        this.tekstilabel = tekstilabel;
    }
    
    /**
     * actionPerformed
     * 
     * Metodi asettaa Peli-luokan alkutilaan, asettaa ruudukkonapit tyhjiksi, samoin kuin tekstit, piilottaa peli-ikkunan ja ottaa esiin aloitusikkunan
     * @param ae 
     */

    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.resetPeli();
        kirjuri.kirjaintenmuuttaminen(peli.getRuudukko(), peli.getLaivojenlaittaminen());
        tekstilabel.setText("");
        frame1.setVisible(true);
        frame2.setVisible(false);
    }
    
}
