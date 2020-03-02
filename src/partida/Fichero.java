package partida;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import interfaz.Iu_Menu1J;

public class Fichero {
	
	public void cargarDatos(String fichero) {

		try {
			Scanner input = new Scanner(new File(fichero));
			while (input.hasNextLine()) {
				String line = input.nextLine();
				
				
			}
			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println();
	}

}
