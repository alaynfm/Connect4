package partida;

import interfaz.Iu_Partida;

public class IAFacil extends IA {

	public void jugar() {
		ListaCasilla listaCasillas = Tablero.getMiTablero().getCasillasLibres();
		int casilla = listaCasillas.getCasillaAleatoria();
		Tablero.getMiTablero().colocarFicha2(casilla);
	}
	
	
}
