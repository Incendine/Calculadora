/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author aulamovil10
 */
public class Linea extends JPanel {

    public Linea(int lado) {
        setPreferredSize(new Dimension(50, 70));
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); 
        grphcs.setColor(Color.RED);
        grphcs.drawLine(0, 0, this.getPreferredSize().height, this.getPreferredSize().width);
    }

}
