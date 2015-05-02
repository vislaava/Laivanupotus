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
    private JLabel aloitusTeksti;
    private JTextField kirjoituskentta1;
    private JTextField kirjoituskentta2;
    private Nimivarasto nimivarasto;
    private Peli peli;

    Aloitusruutu(JLabel aloitusTeksti, JTextField kirjoituskentta1, JTextField kirjoituskentta2, Nimivarasto nimivarasto, Peli peli, JFrame frame1 ,JFrame frame2) {
        this.aloitusTeksti = aloitusTeksti;
        this.kirjoituskentta1 = kirjoituskentta1;
        this.kirjoituskentta2 = kirjoituskentta2;
        this.nimivarasto = nimivarasto;
        this.peli = peli;
        this.frame2 = frame2;
        this.frame1 = frame1;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.setPelaaja1Nimi(kirjoituskentta1.getText());
        peli.setPelaaja2Nimi(kirjoituskentta2.getText());
        
        frame2.setVisible(true);
        frame1.setVisible(false);
    }
    
}
