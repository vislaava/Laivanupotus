/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import upotus.laivanupotus.pelaajatiedot.Nimivarasto;

/**
 *
 * @author Tanja
 */
public class Aloitusruutu implements ActionListener{
    private JFrame frame1;
    private JFrame frame2;
    private JTextField kirjoituskentta1;
    private JTextField kirjoituskentta2;
    private Nimivarasto nimivarasto;
    private Peli peli;

    Aloitusruutu(JTextField kirjoituskentta1, JTextField kirjoituskentta2, Nimivarasto nimivarasto, Peli peli, JFrame frame1 ,JFrame frame2) {
        this.kirjoituskentta1 = kirjoituskentta1;
        this.kirjoituskentta2 = kirjoituskentta2;
        this.nimivarasto = nimivarasto;
        this.peli = peli;
        this.frame2 = frame2;
        this.frame1 = frame1;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String pelaaja1 = kirjoituskentta1.getText();
        String pelaaja2 = kirjoituskentta2.getText();
        peli.setPelaaja1Nimi(pelaaja1);
        peli.setPelaaja2Nimi(pelaaja2);
        nimivarasto.LuoKayttaja(pelaaja1);
        nimivarasto.LuoKayttaja(pelaaja2);
        
        frame2.setVisible(true);
        frame1.setVisible(false);
    }
    
}
