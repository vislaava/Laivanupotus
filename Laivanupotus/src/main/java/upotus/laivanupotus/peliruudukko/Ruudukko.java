/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upotus.laivanupotus.peliruudukko;

/**
 *
 * @author Tanja
 */
public class Ruudukko {

    private Ruutu[][] ruudut;
    private final int riviMax = 10;
    private final int sarakeMax = 10;

    public Ruudukko() {
        this.ruudut = new Ruutu[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ruudut[i][j] = new Ruutu();
            }
        }
    }

    public void LaitaLaiva(int x, int y, boolean laiva) {
        ruudut[x][y].setLaiva(laiva);
    }

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
                return true;
            }
        }
        return false;
    }

    public boolean mahtuukoLaiva(int x, int y, int pituus, boolean vaaka) {
        for (int i = 0; i < pituus; i++) {
            if (ruudut[x][y].onkoLaivaa() == true) {
                System.out.println("Ei mahdu!");
                return false;
            }
            if (vaaka == true) {
                x++;
            } else {
                y++;
            }
        }
        System.out.println("Mahtuu!");
        return true;
    }

    public boolean onkoReunoillaTilaa(int x, int y, int pituus, boolean vaaka) {
        //laiva vaakasuunnassa
        if (vaaka == true) {
            int xv = x;
            int yv = y;

            if (onkoVasemmalla(x, y) || onkoOikealla((x + pituus - 1), y)) {
                return false;
            }
            for (int i = 0; i < pituus; i++) {
                if (onkoPohjoisessa(xv, yv) || onkoEtelassa(xv, yv)) {
                    xv++;
                    return false;
                }
            }
            //laiva pystysuunnassa
        } else {
            int xp = x;
            int yp = y;

            for (int i = 0; i < pituus; i++) {
                if (onkoVasemmalla(xp, yp) || onkoOikealla(xp, yp)) {
                    yp++;
                    return false;
                }
            }
            if (onkoPohjoisessa(xp, yp) || onkoEtelassa(xp, (y + pituus - 1))) {
                return false;
            }
        }
        return true;
    }

    public boolean onkoAlla(int x, int y) {
        return ruudut[x][y].onkoLaivaa();
    }

    public boolean onkoPohjoisessa(int x, int y) {
        if (y == 0) {
            return false;
        }
        return ruudut[x][y - 1].onkoLaivaa();
    }

    public boolean onkoEtelassa(int x, int y) {
        if (y == sarakeMax) {
            return false;
        }
        return ruudut[x][y + 1].onkoLaivaa();
    }

    public boolean onkoOikealla(int x, int y) {
        if (x == riviMax) {
            return false;
        }
        return ruudut[x + 1][y].onkoLaivaa();
    }

    public boolean onkoVasemmalla(int x, int y) {
        if (x == 0) {
            return false;
        }
        return ruudut[x - 1][y].onkoLaivaa();
    }
    
    public boolean AmmuLaiva(int x, int y) {
        if (onkoAlla(x, y) == true) {
            ruudut[x][y].setAmmu(true);
            return true;
        } else {
            return false;
        }
    }

}
