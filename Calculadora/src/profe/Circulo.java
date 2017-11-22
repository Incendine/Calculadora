/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profe;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author aulamovil10
 */
public class Circulo extends JPanel{

    private int numero;
    
    public Circulo(int numero) {
        this.numero=numero;
    }
    
    

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); //To change body of generated methods, choose Tools | Templates.
        grphcs.setColor(Color.BLACK);
        grphcs.drawOval(0, 0, 50, 50);
        grphcs.drawString(""+this.numero, 10, 25);
    }
    
    
    
}
