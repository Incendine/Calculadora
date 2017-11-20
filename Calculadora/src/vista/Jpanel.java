package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Jpanel extends JPanel {
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public Jpanel() {
		setBackground(Color.BLUE);
		
		

	}
	
	 public void paint (Graphics g)
	    {
		 	super.paintComponent(g);

	        g.setColor (Color.red);
	        g.fillOval(10, 200, 60, 60); 

	        g.setColor (Color.BLACK);
	        g.drawString("5",65,540);
	        
	        g.dispose();

	    }
}
