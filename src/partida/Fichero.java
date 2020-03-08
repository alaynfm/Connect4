package partida;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import interfaz.Iu_Menu1J;

public class Fichero {
	
	private static Fichero miFichero;
	
	private Fichero() {
		
	}
	public static Fichero getFichero() {return miFichero;}

	public String leerNormas() {
		//Imprime las normas
		String norma = "Normas para jugar al Conecta 4"; 

		try {
			Scanner input = new Scanner(new File("normas.txt"));
			while (input.hasNextLine()) {
				String line = input.nextLine();
				norma = norma + line + "\n";

			}
			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println();
		return norma;

	}

}
