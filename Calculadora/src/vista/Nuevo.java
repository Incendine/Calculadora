package vista;

import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import vista.ScrollDemo2.DrawingPane;

public class Nuevo extends JPanel {

	private JPanel drawingPane;

	public Nuevo() {
		super(new BorderLayout());
		drawingPane = new DrawingPane();
		drawingPane.setBackground(Color.white);
		JScrollPane scroller = new JScrollPane(drawingPane);
		scroller.setPreferredSize(new Dimension(200, 200));

		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setViewportView(drawingPane);
		add(scroller, BorderLayout.CENTER);
	}

	public class DrawingPane extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			Rectangle rect;
          
                rect = new Rectangle(10, 200, 60, 60);
                g.setColor(Color.GREEN);
                g.fillOval(rect.x, rect.y, rect.width, rect.height);
		}
	}

	public static void crearyMostrar() {
		JFrame frame = new JFrame("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent contentPane = new Nuevo();
		contentPane.setOpaque(true);
		frame.setContentPane(contentPane);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				crearyMostrar();
			}
		});
	}

}
