/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import profe.Circulo;
import profe.Linea;

/**
 *
 * @author aulamovil10
 */
public class Userinterface {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		JFrame f = new JFrame("ventana");
		f.setSize(new Dimension(400, 400));

		JPanel p = new JPanel();
		p.setBackground(Color.RED);
		p.setPreferredSize(new Dimension(2000, 2000));
		p.setLayout(new GridLayout(4, 4));

		JPanel pc = new Circulo(10);
		p.add(pc);
		pc.setPreferredSize(new Dimension(50, 50));

		JPanel lc = new Linea();
		p.add(lc);

		JScrollPane sp = new JScrollPane(p);
		sp.setBackground(Color.yellow);

		f.getContentPane().add(sp);
		f.setMinimumSize(new Dimension(100, 100));
		f.setVisible(true);
	}

}
