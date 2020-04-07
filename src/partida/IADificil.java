package partida;

public class IADificil extends IA {

	public void jugar() {
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
				Tablero.getMiTablero().colocarFicha2(casilla, "r");
			}
		}
	}
}
