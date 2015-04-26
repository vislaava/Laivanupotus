/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import java.awt.Insets;
import javax.swing.JButton;
import upotus.laivanupotus.peliruudukko.Ruutu;

/**
 *
 * @author Tanja
 */
public class OmaButton extends JButton {
    private boolean onkoAmmuttu;
    private boolean onkoLaivaa;
    private Ruutu ruutu;
    private int parx;
    private int pary;
    
    /**
     * OmaButton eroaa JButtonista sen osalta, ettÃ¤ se saa luodessa koordinaatiston parametrit
     * @param ruutu
     * @param x
     * @param y 
     */
    
    public OmaButton(Ruutu ruutu, int parx, int pary) {
        this.ruutu = ruutu;
        this.onkoAmmuttu = ruutu.onkoAmmuttu();
        this.onkoLaivaa = ruutu.onkoLaivaa();
        this.parx = parx;
        this.pary = pary;
        setMargin(new Insets(0, 0, 0, 0));
    }
    
    public void Paivita() {
        this.onkoAmmuttu = ruutu.onkoAmmuttu();
        this.onkoLaivaa = ruutu.onkoLaivaa();
    }
    
    public int getParX() {
        return parx;
    }
    
    public int getParY() {
        return pary;
    }
}
