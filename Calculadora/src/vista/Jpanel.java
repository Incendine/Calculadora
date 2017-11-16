package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.BorderLayout;

public class Jpanel extends JPanel {
	private JTextField textfield1;
	/**
	 * Create the panel.
	 */
	public Jpanel() {
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.BLUE);
	}
	
	 public void paint (Graphics g)
	    {
		 	super.paint(g);

	        g.setColor (Color.red);
	        g.fillOval(10, 200, 60, 60); 

	        g.setColor (Color.BLACK);
	        g.drawString("5",65,540);
	        
	        g.dispose();

	    }
}
