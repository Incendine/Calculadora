package logica;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lectura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			leerArchivo();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
	}

	public static void leerArchivo() throws FileNotFoundException, IOException {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
		fc.setFileFilter(filtro);
		int seleccion = fc.showOpenDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {

			FileReader f = new FileReader(fc.getName());
			BufferedReader b = new BufferedReader(f);
			while (b.readLine() != null) {
				// Metodo de calculadora

			}
			b.close();
		}
	}
}
