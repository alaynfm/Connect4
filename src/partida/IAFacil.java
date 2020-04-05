package partida;

public class IAFacil extends IA {

	public void jugar() {
		String[][] matriz = Tablero.getMiTablero().getMatriz();
		double numColumnas = matriz[0].length;
		double posicionDouble = obtenerColumnaAleatoria(0, numColumnas-1);
		int posicion = (int)posicionDouble;
		boolean colocado = false;
		while (!colocado) {
			if (Tablero.getMiTablero().sePuedeColocar(posicion)) {
				Tablero.getMiTablero().colocarFicha(posicion, "rojo");
				colocado = true;
			} else {
				posicionDouble = obtenerColumnaAleatoria(0, numColumnas-1);
				posicion = (int)posicionDouble;
			}
		}
	}
	
	
}
