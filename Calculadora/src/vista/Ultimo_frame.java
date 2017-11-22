package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import vista.Circulo;
import vista.Linea;

public class Ultimo_frame {

	static JPanel p;
	public static void main(String[] args) {
		// TODO code application logic here
		JFrame f = new JFrame("Calculadora");
		f.setSize(new Dimension(500, 500));
		
		p = new JPanel();
		p.setBackground(Color.GRAY);
		p.setPreferredSize(new Dimension(1000, 1000));
		p.setLayout(null);
		recursivo("+*345", 500, 100, 0);
		p.setPreferredSize(new Dimension((int) Math.pow(2, nivel)*50+500, nivel*50+250));
		System.out.println(nivel);
		
/*
		JPanel pc = new Circulo("10");
		p.add(pc);
		pc.setBounds(100, 100, pc.getPreferredSize().width, pc.getPreferredSize().height);
		pc.setPreferredSize(new Dimension(50, 50));

		JPanel lc = new Linea(1);
		p.add(lc);
*/
		JScrollPane sp = new JScrollPane(p);
		sp.setBackground(Color.yellow);

		f.getContentPane().add(sp);
		f.setMinimumSize(new Dimension(100, 100));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	static int nivel=0;
	public static void recursivo(String ecuacion,int x, int y, int linea) {
		if(ecuacion.length()==0) {
			return;
		}else {
			String caracter = ecuacion.substring(0,1);
			String ecuacionRestante = ecuacion.substring(1,ecuacion.length());
			if (caracter.equals("+") || caracter.equals("*") || caracter.equals("-") || caracter.equals("/")
					|| caracter.equals("^")) {
				JPanel pc = new Circulo(caracter);
				p.add(pc);
				pc.setBounds(x, y, pc.getPreferredSize().width, pc.getPreferredSize().height);
				JPanel lc = new Linea(linea);
				p.add(lc);
				if(linea==0) {
				   lc.setBounds(x-50,y+50,pc.getPreferredSize().width,pc.getPreferredSize().height);
				   recursivo(ecuacionRestante, x-100,y+100, 0);
				}
				if(linea==1) {
					lc.setBounds(x+50,y+50,pc.getPreferredSize().width,pc.getPreferredSize().height);
					recursivo(ecuacionRestante, x+100,y+100, 0);
				}
			}
			else {
				JPanel pc = new Circulo(caracter);
				p.add(pc);
				pc.setBounds(x, y, pc.getPreferredSize().width, pc.getPreferredSize().height);
				if(ecuacionRestante.length()>0) {
					if(linea==0) {
						JPanel lc = new Linea(1);
						p.add(lc);
						lc.setBounds(x+150,y-50,pc.getPreferredSize().width,pc.getPreferredSize().height);
						recursivo(ecuacionRestante, x+200,y, 1);
						nivel=nivel+2;
					}else
					{
						JPanel lc = new Linea(1);
						p.add(lc);
						lc.setBounds(x+50,y-150,pc.getPreferredSize().width,pc.getPreferredSize().height);
						recursivo(ecuacionRestante, x+100,y-100, 1);
					}
				}
			}
		}
	}

}
