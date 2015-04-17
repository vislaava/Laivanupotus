/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.peliruudukko;

/**
 * Luokka sailyttaa yhden ruudun asetukset laivallisuuden ja ampumisen suhteen.
 * 
 * @author Tanja
 */
public class Ruutu {
    private boolean onkoLaivaa = false;
    private boolean onkoAmmuttu = false;
    
    /**
     * Metodi asettaa ruudun laivalliseksi
     * 
     * @param onko laivallisuus
     */
    
    public void setLaiva(boolean onko){
        this.onkoLaivaa = onko;
    }
    
    /**
     * Metodi asettaa ruudun ammutuksi
     * 
     * @param onko ampumistilanne
     */
    
    public void setAmmu(boolean onko) {
        this.onkoAmmuttu = onko;
    }
    
    /**
     * Metodi palauttaa ruudun laivallisuuden tilan
     * 
     * @return laivallisuus
     */
    
    public boolean onkoLaivaa() {
        return onkoLaivaa;
    }
    
    /**
     * Metodi palauttaa ruudun ampumistilanteen
     * 
     * @return onko ruutua ammuttu
     */
    
    public boolean onkoAmmuttu() {
        return onkoAmmuttu;
    }
}
