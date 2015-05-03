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
import javax.swing.JLabel;
import upotus.laivanupotus.pelaajatiedot.Nimivarasto;
import upotus.laivanupotus.tilastot.Tilastojentekija;

/**
 *Tilastokuuntelija
 * 
 * Luokka kuuntelee kahta JButtonia, joista toinen kutsuu vuoroihin perustuvaa tilastoa
 * ja toinen voittoihin perustuvaa tilastoa.
 * 
 * @author Tanja
 */
class Tilastokuuntelija implements ActionListener {
    private JButton voitotTilastoNappi;
    private JButton vuorotTilastoNappi;
    private JLabel tilastoLabel;
    private Nimivarasto nimivarasto;
    private Tilastojentekija tilastot;
    private JFrame frame3;
    
    public Tilastokuuntelija(JButton voitotTilastoNappi, JButton vuorotTilastoNappi, JLabel tilastoLabel, Nimivarasto nimivarasto, JFrame frame3) {
        this.voitotTilastoNappi = voitotTilastoNappi;
        this.vuorotTilastoNappi = vuorotTilastoNappi;
        this.tilastoLabel = tilastoLabel;
        this.nimivarasto = nimivarasto;
        tilastot = new Tilastojentekija(nimivarasto);
        this.frame3 = frame3;
    }
    
    /**
     * actionPerformed
     * 
     * Metodi asettaa tilastoikkunan näkyville, tarkistaa kummasta napista
     * kutsu tuli ja sen perusteella asettaa tilastoLabeliin tilastoesityksen.
     * 
     * @param ae 
     */

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame3.setVisible(true);
        JButton vertailtava = (JButton) ae.getSource();
        if (vertailtava.getText().equals(voitotTilastoNappi.getText())) {
            tilastoLabel.setText(tilastot.VoittajaLuettelo());
        } else {
            tilastoLabel.setText(tilastot.VahitenSiirtojaSuhteessaVoittoihinLuettelo());
        }
    }
    
}
