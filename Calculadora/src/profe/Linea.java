/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author aulamovil10
 */
public class Linea extends JPanel {

    public Linea() {
        setPreferredSize(new Dimension(50, 70));
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); //To change body of generated methods, choose Tools | Templates.
        grphcs.setColor(Color.RED);
        grphcs.drawLine(this.getPreferredSize().height, 0,0, this.getPreferredSize().width);
    }

}
