package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;

public class Jpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JScrollPane scrollPane;
	public Jpanel() {
		
		
		
		JPanel panel = new JPanel();
		scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		setLayout(new BorderLayout(0, 0));
		scrollPane.setPreferredSize(new Dimension(200,200));
		add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(panel);
	}
	
	 public void paint (Graphics g)
	    {
	        scrollPane.paint(g);

	        g.setColor (Color.red);
	        g.fillOval(10, 200, 60, 60); 

	        g.setColor (Color.BLACK);
	        g.drawString("5",65,540);
	        
	        setDoubleBuffered(true);

	    }
}
