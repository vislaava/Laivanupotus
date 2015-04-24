/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import upotus.laivanupotus.pelialusta.Peliruutu;
import upotus.laivanupotus.peliruudukko.Ruutu;

/**
 *
 * @author Tanja
 */
public class Kayttoliittyma implements Runnable {
    
    private JFrame frame;
    private GridLayout ruudukkoonAsettelija;
    private Peliruutu peliruutu;
    private ArrayList<OmaButton> napit;
    
    public Kayttoliittyma(Peliruutu peliruutu) {
        ruudukkoonAsettelija = new GridLayout(10,10);
        this.peliruutu = peliruutu;
        this.napit = new ArrayList<OmaButton>();
    }

    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(ruudukkoonAsettelija);
        Ruutu[][] ruudut = peliruutu.getRuudukko().getRuudut();
        
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                OmaButton nappi = new OmaButton(ruudut[x][y], x, y);
                nappi.addActionListener(new Kuuntelija());
                container.add(nappi);
                napit.add(nappi);
            }
        }
    }
    
}
