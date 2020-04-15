package partida;

import java.io.ObjectOutputStream.PutField;

public class IADificil extends IA {

	public void jugar() {
		/*
		Boolean tresSeguidasMaquina = Tablero.getMiTablero().buscarTresSeguidas("r");
		if (tresSeguidasMaquina) {
			
		} else {
			Boolean tresSeguidasJugador = Tablero.getMiTablero().buscarTresSeguidas("a");
			Boolean dosSeguidasMaquina = Tablero.getMiTablero().buscarDosSeguidas("r");
			if (tresSeguidasJugador) {
				
			} else if (dosSeguidasMaquina) {
				
			} else {
				ListaCasilla listaCasillas = Tablero.getMiTablero().getCasillasLibres();
				int casilla = listaCasillas.getCasillaAleatoria();
				Tablero.getMiTablero().colocarFicha2(casilla);
			}
		}
		*/
		int columna = obtenerColumnaMayorPuntuacion();
		Tablero.getMiTablero().colocarFicha2(columna);
	}
	
	private static int obtenerColumnaMayorPuntuacion() 
	{
		int col = 0;
		int maxValor = 0;
		for(int i = 0; i < Tablero.getMiTablero().getColumnas(); i++) 
		{
			int nuevoValor = caluclarValorDeColumna(i);
			if (maxValor<nuevoValor) 
			{
				maxValor = nuevoValor;
				col = i;
				if (maxValor >= 1000) 
				{
					return col;
				}
			}
		}
		return col;
	}
	private static int caluclarValorDeColumna(int pCol) 
	{
		//Los valores de las puntuaciones de los movimientos se pueden modificar si nos conviene
		int puntGanar = 1000;
		int puntEvitarVictoria = 900;
		int puntTresEnLinea = 10;
		int puntDosEnLinea = 5;		
		//Terminan los valores de puntuacion
		int puntuacionTotal = 0;
		int fila = Tablero.getMiTablero().getFilas();
		while(Tablero.getMiTablero().getPosicion(fila, pCol).equals("-")) 
		{
			fila++;
		}	
		
		if (true) {//Comprobar que si la pone ahi va a ganar
			puntuacionTotal += puntGanar;
		}
		
		if (true) {//Comprobar que evita la victoria del contrario
			puntuacionTotal += puntEvitarVictoria;
		}
		
		if (true) {//Comprobar que hace tres en linea
			puntuacionTotal += puntTresEnLinea;
		}
		
		if (true) {//Comprobar que hace dos en linea
			puntuacionTotal += puntDosEnLinea;
		}
		
		return puntuacionTotal;
	}
}
