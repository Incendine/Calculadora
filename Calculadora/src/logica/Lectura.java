package logica;

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
		
		String cadena;
		FileReader f = new FileReader("C:\\Users\\Incen\\Desktop\\cadn.txt");
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			Main m = new Main();
			m.realizarEcuacion(cadena);
			m =null;
			Prefijo2 p = new Prefijo2();
			p.realizarEcuacion(cadena);
		}
		b.close();
	}
}
