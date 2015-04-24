/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tanja
 */
public class Kuuntelija implements ActionListener {
    private boolean onkoPeliAlkanut = false;
    private OmaButton nappi;
    

    public Kuuntelija() {
    }
    
    public void setLaivojenlaittoAlkanut() {
        onkoPeliAlkanut = false;
    }
    
    public void setPeliAlkaneeksi() {
        onkoPeliAlkanut = true;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        nappi = (OmaButton)ae.getSource();
        
    }
    
}
