/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Tanja
 */
public class Aloitusruutu implements ActionListener{
    private JLabel aloitusTeksti;
    private JTextArea kirjoituskentta1;
    private JTextArea kirjoituskentta2;

    Aloitusruutu(JLabel aloitusTeksti, JTextArea kirjoituskentta1, JTextArea kirjoituskentta2) {
        this.aloitusTeksti = aloitusTeksti;
        this.kirjoituskentta1 = kirjoituskentta1;
        this.kirjoituskentta2 = kirjoituskentta2;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
