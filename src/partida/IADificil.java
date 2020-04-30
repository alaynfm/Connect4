package partida;

import java.util.Random;

public class IADificil extends IA {

	public void jugar() {
		int columna = obtenerColumnaMayorPuntuacion();
		Tablero.getMiTablero().colocarFicha2(columna);
	}
	
	private static int obtenerColumnaMayorPuntuacion() 
	{
		int col = 0;
		int maxValor = 0;

		for(int i = 0; i < Tablero.getMiTablero().getColumnas(); i++) 
		{
			int nuevoValor = Tablero.getMiTablero().valorCasillaIA(i);
			if (nuevoValor!= -1 && maxValor<nuevoValor) 
			{
				maxValor = nuevoValor;
				col = i;
				if (maxValor >= 1000) 
				{
					return col;
				}
			}
			else if(maxValor==nuevoValor)
			{
				int posiblesJugadas[] = {maxValor,nuevoValor}; 
				int rnd = new Random().nextInt(posiblesJugadas.length);
				if (rnd == 1) 
				{
					col = i;
				}
				maxValor = posiblesJugadas[rnd];
			}
		}
		return col;
	}

}
