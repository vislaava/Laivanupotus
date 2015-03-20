/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus;

/**
 *
 * @author Tanja
 */
public class Ruutu {
    private boolean onkoLaivaa = false;
    private boolean onkoAmmuttu = false;
    
    public void setLaiva(boolean onko){
        this.onkoLaivaa = onko;
    }
    
    public void setAmmu(boolean onko) {
        this.onkoAmmuttu = onko;
    }
    
    public boolean onkoLaivaa() {
        return onkoLaivaa;
    }
    
    public boolean onkoAmmuttu() {
        return onkoAmmuttu;
    }
}
