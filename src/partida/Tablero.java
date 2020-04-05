package partida;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

import interfaz.Iu_Partida;

public class Tablero extends Observable {

	private String[][] tablero;
	/*Los colores de las fichas pueden ser
	 * - : vacia
	 * a : azul
	 * r : rojo
	 * */
	private String ganador;	//Nombre del jugador que ha ganado
	private static Tablero miTablero = new Tablero();
	private ArrayList<Observable> misObservables = new ArrayList<Observable>();
	
	private Tablero() {
		misObservables = new ArrayList<Observable>();
	}
	
	public static Tablero getMiTablero() {return miTablero;}

	public void generarTablero(int x, int y) { // creamos el tablero
		ganador = "-";
		tablero = new String[x][y];
		for (int i = 0; i < x; i++) { // recorremos la fila
			for (int k = 0; k < y; k++) { // recorremos la columna
				tablero[i][k] = "-"; // por defecto vacio
			}
		}
	}
	
	public String[][] getTablero(){
		return tablero;
	}

	public void imprimirTablero() {
		// Imprime el tablero en la terminal
		int ty = tablero.length;
		int tx = tablero[0].length;
		for (int i = 0; i < ty; i++) {
			System.out.print("\n");
			for (int k = 0; k < tx; k++) {
				System.out.print(tablero[i][k]);
			}
		}

	}

	public String getPosicion(int x, int y) {
		// Post: Devuelve lo que hay en la posicion indicada (- si vacio, Rojo si J1,
		// Azul si J2)
		int ty = tablero.length;
		int tx = tablero[0].length;

		if (x > ty || x < 0) { // posicion incorrecta (hay que tratarla)
			return null;
		} else if (y > tx || y < 0) { // posicion incorrecta (hay que tratarla)
			return null;
		} else {
			return tablero[x][y];
		}
	}

	public void colocarFicha(int x, String color) {
		// busca la posicion mas baja y coloca ahi la ficha
		int tx = tablero[0].length;
		if (x < tx && sePuedeColocar(x)) {
			int ty = tablero.length;
			for (int i = ty - 1; i >= 0; i--) { // recorremos de forma inversa
				if (tablero[i][x].equals("-")) {
					tablero[i][x] = color;
					buscarGanador(i, x, color);
					
					//Patron observer https://www.youtube.com/watch?v=Zt6478Za0zk
					setChanged();
					notifyObservers();

					break;
				}
			}
			if(hayGanador()) {
				System.out.println("Hay un ganador");
			}
		}
	}
	
	public void colocarFicha2(int c,String color) {
	
		for(int i = tablero.length - 1; i>=0;i--) {
			if(tablero[i][c].equals("-")) {
				tablero[i][c] = color;
				buscarGanador(i, c, color);
				
				//Para el patron observer
				setChanged();
				notifyObservers(Iu_Partida.miPartida());
				
				break;
			}
			
		}
	}

	public boolean sePuedeColocar(int x) {
		// Post: Devuelve true si se puede colocar
		int ty = tablero.length;
		for (int i = ty - 1; i >= 0; i--) { // recorremos de forma inversa
			if (tablero[i][x].equals("-")) {
				return true;
			}
		}
		return false;
	}

	public void buscarGanador(int i, int x, String color) {
		if (buscarGanadorJuego(i, x)) {
			if (color == "r") {
				ganador = "usuario";
			} else {
				ganador = "maquina";
			}
		}
	}

	public boolean hayGanador() {
		if (ganador.equals("-"))
			return false;
		else
			return true;
	}

	public boolean buscarGanadorJuego(int i, int x) {

		if (buscarGanadorDiagonal(i, x) || buscarGanadorHorizontal(i, x) || buscarGanadorVertical(i, x))
			return true;
		else
			return false;
	}

	public boolean buscarGanadorVertical(int fila, int columna) {

		boolean ganador = false;
		int vcontAbajo = 0;
		int vcontArriba = 0;
		boolean contA = true;
		boolean contB = true;

		for (int i = 1; i < 4; i++) {

			// hacia abajo
			if (contA && posCorrecta(fila + i, columna)) {
				if ((tablero[fila + i][columna]).equals(tablero[fila][columna])) {
					vcontArriba++;
				} else {
					contA = false;
				}
			}

			// hacia arriba
			if (contB && posCorrecta(fila - i, columna)) {
				if ((tablero[fila - i][columna]).equals(tablero[fila][columna])) {
					vcontAbajo++;
				} else {
					contB = false;
				}
			}

			if (vcontArriba + vcontAbajo >= 3) {
				ganador = true;
				break;
			}
		}
		return ganador;
	}

	public boolean buscarGanadorHorizontal(int fila, int columna) {

		boolean ganador = false;
		int vcontAbajo = 0;
		int vcontArriba = 0;
		boolean contaA = true;
		boolean contB = true;

		for (int i = 1; i < 4; i++) {

			if (contaA && posCorrecta(fila, columna + i)) {
				if ((tablero[fila][columna + i]).equals(tablero[fila][columna])) {
					vcontArriba++;
				} else {
					contaA = false;
				}
			}

			if (contB && posCorrecta(fila, columna - i)) {
				if (contB && (tablero[fila][columna - i]).equals(tablero[fila][columna])) {
					vcontAbajo++;
				} else {
					contB = false;
				}
			}

			if (vcontArriba + vcontAbajo >= 3) {
				ganador = true;
				break;
			}
		}

		return ganador;

	}

	public boolean buscarGanadorDiagonal(int fila, int columna) {
		String color = tablero[fila][columna];
		// Diagonal
		int contArribaDer = 0;
		int contAbajoDer = 0;
		int contAbajoIzq = 0;
		int contArribaIzq = 0;

		// Para no contar de mas, una si y una no.
		boolean contA = true;
		boolean contB = true;
		boolean contC = true;
		boolean contD = true;

		boolean ganador = false;
		// hacia arriba
		for (int i = 1; i < 4; i++) {

			// hacia abajo izquierda
			if (contA && posCorrecta(fila + i, columna - i)) {
				if ((tablero[fila + i][columna - i]).equals(color)) {
					contAbajoIzq++;
				} else {
					contA = false;
				}
			}
			// hacia arriba derecha
			if (contB && posCorrecta(fila - i, columna + i)) {
				if ((tablero[fila - i][columna + i]).equals(color)) {
					contArribaDer++;
				} else {
					contB = false;
				}
			}

			// hacia abajo derecha
			if (contC && posCorrecta(fila + i, columna + i)) {
				if ((tablero[fila + i][columna + i]).equals(color)) {
					contAbajoDer++;
				} else {
					contC = false;
				}
			}

			// arriba izq
			if (contD && posCorrecta(fila - i, columna - i)) {
				if ((tablero[fila - i][columna - i]).equals(color)) {
					contArribaIzq++;
				} else {
					contD = false;
				}
			}
			
			if (contArribaDer + contAbajoIzq >= 3 || contAbajoDer + contArribaIzq >= 3) {
				ganador = true;
				break;
			}
		}
		return ganador;
	}

	private Boolean posCorrecta(int i, int j) {
		if (i < tablero.length && j < tablero[0].length && i >= 0 & j >= 0)
			return true;
		else
			return false;

	}

	public String getGanador() {
		// Devuelve el atributo ganador (recomendable comprobar primero si hay ganador
		return this.ganador;
	}
	public String[][] getMatriz() {
		return tablero;
	}
	
	public void setColor(int fila, int columna , String color) {
		tablero[fila][columna] = color;
	}

}
