package partida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Stack;

import javax.swing.JOptionPane;

import interfaz.Iu_Partida;

public class Tablero extends Observable {

	private String[][] tablero;
	/*
	 * Los colores de las fichas pueden ser - : vacia a : azul r : rojo
	 */
	private String ganador; // Nombre del jugador que ha ganado
	private static Tablero miTablero = new Tablero();
	private IA joseMurillo = null;

	private ListaCasilla listaCasillasLibres;
	private ArrayList<String> ganadores;
	private int turno;

	private Tablero() {
		setIa(true);
		listaCasillasLibres = new ListaCasilla();
		ganadores = new ArrayList<String>();
		turno = 0;
	}

	public static Tablero getMiTablero() {
		return miTablero;
	}

	public void generarTablero(int x, int y) { // creamos el tablero
		ganador = "-";
		tablero = new String[x][y];
		for (int i = 0; i < x; i++) { // recorremos la fila
			for (int k = 0; k < y; k++) { // recorremos la columna
				tablero[i][k] = "-"; // por defecto vacio
				listaCasillasLibres.anadirCasilla("" + i + "" + k + "", k);
			}
		}
	}

	public ListaCasilla getCasillasLibres() {
		return listaCasillasLibres;
	}

	public void setIa(boolean nivel) {
		// true Ia facil
		// False ia dificil
		if (nivel)
			joseMurillo = new IAFacil();
		else
			joseMurillo = new IADificil();
	}

	public String[][] getTablero() {
		return tablero;
	}

	private void jugar2vs2(int j) {

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

	public void colocarFicha2(int c) {

		// Miramos si podemos colocar la ficha

		// Si la colocamos y ha ganado terminamos la partida
		// Si no seguimos jugando

		String color;
		if (turno % 2 == 0) // jugador1
			color = "a";
		else // Jugador2 o IA
			color = "r";

		for (int i = tablero.length - 1; i >= 0; i--) {
			if (tablero[i][c].equals("-")) {
				tablero[i][c] = color;
				Iu_Partida.miPartida().pintarColumna(c); // Pintamos la columna en la que la ponemos
				buscarGanador(i, c, color);
				listaCasillasLibres.eliminarCasillla("" + i + "" + c + "");
				break;
			}
		}

		turno++;

		if (hayGanador()) { // Terminamos la partida y pintamos con las fichas que se ha ganado

			ArrayList<String> lista = Tablero.getMiTablero().getGanadores();

			for (String elemento : lista) {

				Iu_Partida.miPartida().pintarPosicion(elemento.charAt(0) + "", elemento.charAt(1) + "", color);
			}

			Iu_Partida.miPartida().pintarTablero();
			JOptionPane.showMessageDialog(null, "Se ha terminado la Partida", "Error", JOptionPane.WARNING_MESSAGE);
			Iu_Partida.miPartida().setVisible(false);

		}

	}

	public void jugarPartida1vsia(int j) {

		colocarFicha2(j);
		if (!hayGanador())
			joseMurillo.jugar();

	}

	public boolean sePuedeColocar(int x) {
		// Post: Devuelve true si se puede colocar

		boolean sepuede = false;
		int ty = tablero.length;
		for (int i = ty - 1; i >= 0; i--) { // recorremos de forma inversa
			if (tablero[i][x].equals("-")) {
				sepuede = true;
			}
		}
		return sepuede;
	}

	public void buscarGanador(int i, int x, String color) {
		if (buscarGanadorJuego(i, x)) {
			if (color == "r") {
				ganador = "Jose Murillo";
			} else {
				ganador = "usuario";
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

	public boolean buscarTresSeguidas(String color) {
		boolean existe = false;
		boolean existeVertical = false;
		boolean existeHorizontal = false;
		boolean existeDiagonal = false;

		existe = existeVertical || existeHorizontal || existeDiagonal;
		return existe;

	}

	public boolean buscarDosSeguidas(String color) {

		return true;
	}

	public boolean buscarVertical(int fila, int columna, int numFichas) {

		boolean existe = false;
		int vcontAbajo = 0;
		int vcontArriba = 0;
		boolean contA = true;
		boolean contB = true;

		ArrayList<String> lista1 = new ArrayList<String>();
		lista1.add("" + fila + "" + columna);

		for (int i = 1; i < 4; i++) {

			// hacia abajo
			if (contA && posCorrecta(fila + i, columna)) {
				if ((tablero[fila + i][columna]).equals(tablero[fila][columna])) {
					vcontArriba++;
					int f = fila + i;
					lista1.add("" + f + "" + columna);
				} else {
					contA = false;
				}
			}

			// hacia arriba
			if (contB && posCorrecta(fila - i, columna)) {
				if ((tablero[fila - i][columna]).equals(tablero[fila][columna])) {
					vcontAbajo++;
					int f = fila - i;
					lista1.add("" + f + "" + columna);

				} else {
					contB = false;
				}
			}

			if (vcontArriba + vcontAbajo >= numFichas - 1) {
				existe = true;
				ganadores = lista1;
				break;
			}
		}
		return existe;
	}

	public boolean buscarHorizontal(int fila, int columna, int numFichas) {
		boolean existe = false;
		int vcontAbajo = 0;
		int vcontArriba = 0;
		boolean contaA = true;
		boolean contB = true;

		ArrayList<String> lista1 = new ArrayList<String>();
		lista1.add("" + fila + "" + columna);

		for (int i = 1; i < 4; i++) {

			if (contaA && posCorrecta(fila, columna + i)) {
				if ((tablero[fila][columna + i]).equals(tablero[fila][columna])) {
					vcontArriba++;
					int c = columna + i;
					lista1.add("" + fila + "" + c);

				} else {
					contaA = false;
				}
			}

			if (contB && posCorrecta(fila, columna - i)) {
				if (contB && (tablero[fila][columna - i]).equals(tablero[fila][columna])) {
					vcontAbajo++;
					int c = columna - i;
					lista1.add("" + fila + "" + c);
				} else {
					contB = false;
				}
			}

			if (vcontArriba + vcontAbajo >= numFichas - 1) {
				existe = true;
				ganadores = lista1;
				break;
			}
		}

		return existe;
	}

	public boolean buscarDiagonal(int fila, int columna, int numFichas) {
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

		boolean existe = false;
		ArrayList<String> lista1 = new ArrayList<String>();
		lista1.add("" + fila + "" + columna);

		// hacia arriba
		for (int i = 1; i < 4; i++) {

			// hacia abajo izquierda
			if (contA && posCorrecta(fila + i, columna - i)) {
				if ((tablero[fila + i][columna - i]).equals(color)) {
					contAbajoIzq++;
					int f = fila + i;
					int c = columna - 1;
					lista1.add("" + f + "" + c);

				} else {
					contA = false;
				}
			}
			// hacia arriba derecha
			if (contB && posCorrecta(fila - i, columna + i)) {
				if ((tablero[fila - i][columna + i]).equals(color)) {
					contArribaDer++;
					int f = fila - i;
					int c = columna + i;
					lista1.add("" + f + "" + c);
				} else {
					contB = false;
				}
			}

			// hacia abajo derecha
			if (contC && posCorrecta(fila + i, columna + i)) {
				if ((tablero[fila + i][columna + i]).equals(color)) {
					contAbajoDer++;
					int f = fila + i;
					int c = columna + i;
					lista1.add("" + f + "" + c);
				} else {
					contC = false;
				}
			}

			// arriba izq
			if (contD && posCorrecta(fila - i, columna - i)) {
				if ((tablero[fila - i][columna - i]).equals(color)) {
					contArribaIzq++;
					int f = fila - i;
					int c = columna - i;
					lista1.add("" + f + "" + c);
				} else {
					contD = false;
				}
			}

			if (contArribaDer + contAbajoIzq >= numFichas - 1 || contAbajoDer + contArribaIzq >= numFichas - 1) {
				existe = true;
				ganadores = lista1;
				break;
			}
		}
		return existe;
	}

	public ArrayList<String> getGanadores() {
		return ganadores;
	}

	public boolean buscarGanadorVertical(int fila, int columna) {

		return buscarVertical(fila, columna, 4);
	}

	public boolean buscarGanadorHorizontal(int fila, int columna) {

		return buscarHorizontal(fila, columna, 4);

	}

	public boolean buscarGanadorDiagonal(int fila, int columna) {
		return buscarDiagonal(fila, columna, 4);
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

	public void setColor(int fila, int columna, String color) {
		tablero[fila][columna] = color;
	}

}
