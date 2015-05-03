/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.peliruudukko;

/**
 * Ruudukko
 * 
 * Luokka hallitsee ruuduista koostuvaa taulukkoa, tarkistaa ruudukon ruutujen tilan ja muuttaa niita.
 * @author Tanja
 */
public class Ruudukko {

    private Ruutu[][] ruudut;
    private final int riviMax = 10;
    private final int sarakeMax = 10;
    
    /**
     * Konstruktori luo kaksiulotteisen taulukon ja alustaa sen Ruutu-olioiksi.
     */

    public Ruudukko() {
        this.ruudut = new Ruutu[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ruudut[i][j] = new Ruutu();
            }
        }
    }
    
    /**
     * getRuudut
     * 
     * Metodi palauttaa taulukon
     * 
     * @return Ruuduista koostuva taulukko.
     */

    public Ruutu[][] getRuudut() {
        return ruudut;
    }
    
    /**
     * LaitaLaiva
     * 
     * Metodi muuttaa Ruutu-oliossa ruudun sisältämään laivan
     * 
     * @param x sarake
     * @param y rivi
     * @param laiva boolean, joka asettaa laivan trueksi
     */

    public void laitaLaiva(int x, int y, boolean laiva) {
        ruudut[x][y].setLaiva(laiva);
    }
    
    /**
     * lisaaLaiva
     * 
     * Metodi muuttaa ruutu kerrallaan laivan trueksi koordinaattien, pituuden ja suunnan mukaan.
     * Tarkistaa metodien OnkoAllaTilaa ja OnkoReunoillaTilaa että laiva pystytään laittamaan paikalleen.
     * 
     * @param x sarake  
     * @param y rivi
     * @param pituus laivan koko ruutuina
     * @param vaaka määrittää laivan asennon. True on vaaka, false pysty
     * @return Palauttaa truen mikäli koko laiva pystytään sijoittamaan, muuten false
     */

    public boolean lisaaLaiva(int x, int y, int pituus, boolean vaaka) {
        if (mahtuukoLaiva(x, y, pituus, vaaka) == true) {
            if (onkoReunoillaTilaa(x, y, pituus, vaaka) == true) {
                if (vaaka == true) {
                    for (int i = 0; i < pituus; i++) {
                        ruudut[x][y].setLaiva(true);
                        x++;
                    }
                } else {
                    for (int i = 0; i < pituus; i++) {
                        ruudut[x][y].setLaiva(true);
                        y++;
                    }
                }
                System.out.println("Mahtuu!");
                return true;
            }
        }
        System.out.println("Ei mahdu!");
        return false;
    }
    /**
     * mahtuukoLaiva
     * 
     * Metodi tarkistaa että laiva ei ylitä taulukon rajoja ja että alla on tilaa.
     * 
     * @param x sarake
     * @param y rivi
     * @param pituus laivan pituus
     * @param vaaka laivan suunta
     * @return palauttaa truen mikäli yksikään tarkistettavista asioista ei palauta falsea.
     */

    public boolean mahtuukoLaiva(int x, int y, int pituus, boolean vaaka) {
        if (vaaka == true) {
            if (x + pituus > riviMax) {
                return false;
            }
        } else {
            if (y + pituus > sarakeMax) {
                return false;
            }
        }
        for (int i = 0; i < pituus; i++) {
            if (ruudut[x][y].onkoLaivaa() == true) {
                return false;
            }
            if (vaaka == true) {
                x++;
            } else {
                y++;
            }
        }
        return true;
    }
    /**
     * onkoReunoillaTilaa
     * 
     * Metodi tarkistaa laivan ympäristön jotta laiva ei päädy rinnakkain toisen laivan kanssa. 
     * 
     * @param x sarake
     * @param y rivi
     * @param pituus laivan pituus
     * @param vaaka laivan suunta
     * @return palauttaa truen mikäli laiva ei koskettaisi toista laivaa
     */

    public boolean onkoReunoillaTilaa(int x, int y, int pituus, boolean vaaka) {
        //laiva vaakasuunnassa
        if (vaaka == true) {
            int xv = x;
            int yv = y;

            if (onkoLannessa(x, y) || onkoIdassa((x + pituus - 1), y)) {
                return false;
            }
            for (int i = 0; i < pituus; i++) {
                if (onkoPohjoisessa(xv, yv) || onkoEtelassa(xv, yv)) {
                    return false;
                }
                xv++;
            }
            //laiva pystysuunnassa
        } else {
            int xp = x;
            int yp = y;

            for (int i = 0; i < pituus; i++) {
                if (onkoLannessa(xp, yp) || onkoIdassa(xp, yp)) {
                    return false;
                }
                yp++;
            }
            if (onkoPohjoisessa(xp, yp) || onkoEtelassa(xp, (y + pituus - 1))) {
                return false;
            }
        }
        return true;
    }
    /**
     * onkoPohjoisessa
     * 
     * Metodi tarkistaa annetun ruudun ylapuolisen rivin saman sarakkeen ruudun.
     */
    public boolean onkoPohjoisessa(int x, int y) {
        if (y == 0) {
            return false;
        }
        return ruudut[x][y - 1].onkoLaivaa();
    }

    /**
     * onkoEtelassa
     * 
     * Metodi tarkistaa annetun ruudun alapuolisen rivin saman sarakkeen ruudun.
     */
    public boolean onkoEtelassa(int x, int y) {
        if (y == sarakeMax - 1) {
            return false;
        }
        return ruudut[x][y + 1].onkoLaivaa();
    }
    
    /**
     * onkoIdassa
     * 
     * Metodi tarkistaa annetun ruudun oikeanpuolisen sarakkeen saman rivin ruudun.
     */

    public boolean onkoIdassa(int x, int y) {
        if (x == riviMax - 1) {
            return false;
        }
        return ruudut[x + 1][y].onkoLaivaa();
    }
    
    /**
     * onkoLannessa
     * 
     * Metodi tarkistaa annetun ruudun vasemmanpuolisen sarakkeen saman rivin ruudun.
     */

    public boolean onkoLannessa(int x, int y) {
        if (x == 0) {
            return false;
        }
        return ruudut[x - 1][y].onkoLaivaa();
    }
    
    /**
     * AmmuLaiva
     * 
     * Metodi asettaa annetun ruudun ammutuksi mmikali ruutua ei ole ammuttu
     * @return palauttaa truen jos muuttaa ruudun ammutuksi
     */

    public boolean ammuLaiva(int x, int y) {
        if (ruudut[x][y].onkoAmmuttu() != true) {
            ruudut[x][y].setAmmu(true);
            return true;
        } else {
            return false;
        }
    }
    /**
     * OnkoKaikkiAmmuttu
     * 
     * Metodi tarkistaa rivi ja sarake kerrallaan etta onko ruudussa laivaa ja jos on onko se ammuttu.
     * @return Jos vastaan ei tule ampumatonta laivallista 
     * ruutua palauttaa truen. jos tulee ampumaton laiva palauttaa falsen
     */

    public boolean onkoKaikkiAmmuttu() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (ruudut[x][y].onkoLaivaa() == true) {
                    if (ruudut[x][y].onkoAmmuttu() == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    /**
     * onkoAlla
     * 
     * Testien apumetodi tarkistaa onko ruudussa laiva
     * @return palauttaa ruudun boolean-palautuksen
     */
    public boolean onkoAlla(int x, int y) {
        return ruudut[x][y].onkoLaivaa();
    }
}