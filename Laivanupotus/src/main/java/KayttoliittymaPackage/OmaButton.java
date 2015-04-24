/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

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
    private int x;
    private int y;
    
    /**
     * OmaButton eroaa JButtonista sen osalta, että se saa luodessa koordinaatiston parametrit
     * @param ruutu
     * @param x
     * @param y 
     */
    
    public OmaButton(Ruutu ruutu, int x, int y) {
        this.ruutu = ruutu;
        this.onkoAmmuttu = ruutu.onkoAmmuttu();
        this.onkoLaivaa = ruutu.onkoLaivaa();
        this.x = x;
        this.y = y;
    }
    
    public void Paivita() {
        this.onkoAmmuttu = ruutu.onkoAmmuttu();
        this.onkoLaivaa = ruutu.onkoLaivaa();
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
