package partida;


import java.util.ArrayList;
import interfaz.Iu_Fin1vs1;
import interfaz.Iu_Finpartida;
import interfaz.Iu_Partida;
import interfaz.Iu_Revancha;
import interfaz.Iu_gig_ganar;


public class Tablero {

	private String[][] tablero;
	/*
	 * Los colores de las fichas pueden ser - : vacia a : azul r : rojo
	 */
	private String ganador; // Nombre del jugador que ha ganado
	private IA joseMurillo = null;
	private int turno;
	private boolean forma; // true si es 1 vs IA
	private String jugador1;
	private String jugador2;

	private static Tablero miTablero = new Tablero();
	private ListaCasilla listaCasillasLibres;
	private ArrayList<String> ganadores;
	private Iu_Partida interfaz;
	private String nombreGanador;
	private String dificultad;
	public static Tablero getMiTablero() {
		return miTablero;
	}
	private Tablero() {
		setIa(true);
		listaCasillasLibres = new ListaCasilla();
		ganadores = new ArrayList<String>();
		turno = 0;

		interfaz = new Iu_Partida();

	}

	public void generarTablero(int x, int y) { // creamos el tablero

		interfaz.dispose();
		ganador = "-";
		tablero = new String[x][y];
		for (int i = 0; i < x; i++) { // recorremos la fila
			for (int k = 0; k < y; k++) { // recorremos la columna
				tablero[i][k] = "-"; // por defecto vacio
				listaCasillasLibres.anadirCasilla("" + i + "" + k + "", k);
			}
		}

		// Creamos la interfaz con los datos correspondientes
		interfaz = new Iu_Partida();
		generarInterfaz(x, y);
		turno = 0;

	}

	public void generarInterfaz(int x, int y) {

		interfaz.crearTablero(x, y);
		interfaz.setLocationRelativeTo(null); // Para centrar la ventana en el medio
		interfaz.setNombreJugador1(jugador1);
		interfaz.setNombreJugador2(jugador2);
		interfaz.setVisible(true);
		interfaz.setEnabled(true);
		interfaz.pintarTablero();
	}

	public void jugarPartida(int j) {
		// TODO Auto-generated method stub

		if (forma) {
			// 1 vs IA
			int turnoini=turno;
			colocarFicha2(j);
			boolean correcto= (turnoini!=turno);//comprobacion de que el turno ha pasado
			if (!hayGanador() && correcto) {
				joseMurillo.jugar();
			}
		} else {
			colocarFicha2(j);

		}

	}

	public ListaCasilla getCasillasLibres() {
		return listaCasillasLibres;
	}

	public void setIa(boolean nivel) {

		// true Ia facil
		// False ia dificil
		if (nivel) {
			joseMurillo = new IAFacil();
			this.dificultad= "Facil";
		}
		else {
			joseMurillo = new IADificil();
			this.dificultad="Dificil";
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
		int i;
		for (i = tablero.length - 1; i >= 0; i--) {
			if (tablero[i][c].equals("-")) {
				tablero[i][c] = color;
				if (turno % 2 == 0)
					interfaz.pintarPosicion(i + 1, c, "a"); // Pintamos la columna en la que la ponemos
				else
					interfaz.pintarPosicion(i + 1, c, "r");
				buscarGanador(i, c, color);
				listaCasillasLibres.eliminarCasillla("" + i + "" + c + "");
				turno++;
				interfaz.seturno(turno);
				break;
			}
		}
		if (i!=-1) { //Si i=-1 la columna esta llena
			
		}
		if (hayGanador()) { // Terminamos la partida y pintamos con las fichas que se ha ganado

			ArrayList<String> lista = ganadores;

			for (String elemento : lista) {

				String[] v1 = elemento.split("\\s+-->\\s+");
				interfaz.pintarGanadores(v1[0], v1[1], ganador);
			}

			// hacemos que la interfaz no funcione, la partida se ha terminado
			interfaz.setEnabled(false);
			
			interfaz.pararTimer();
			

			if (forma) {

				if (ganador.equals("a")) {	//ha ganado el jugador
					(new Iu_Finpartida()).setVisible(true);
				}else {	
					
					//Reproducir un sonido
					(new Iu_Revancha()).setVisible(true);
					
				}

			} else {
				// hacer la Iu Revancha por si quieren jugar otra
				(
						new Iu_Fin1vs1()).setGanador(nombreGanador);;

			}
		}
		if (this.listaCasillasLibres.size()==0) { //lista vacia, por tanto hay empate
			//paramos la interfaz
			interfaz.setEnabled(false);
			interfaz.pararTimer();
			
			if (forma) {
				new Iu_Revancha().setVisible(true); //mostramos el empate
			}
			else {
				new Iu_Fin1vs1().setEmpate();
			}
		}

	}

	public void cerrarInterfaz() {
		interfaz.dispose();
	}

	private void buscarGanador(int i, int x, String color) {
		if (buscarGanadorJuego(i, x)) {
			if (color == "r") { //gana rojo
				ganador = "r";
				nombreGanador=this.jugador2;
			} else { //gana azul
				ganador = "a";
				nombreGanador=this.jugador1;
			}
		}
	}

	public boolean hayGanador() {
		if (ganador.equals("-"))
			return false;
		else
			return true;
	}

	private boolean buscarGanadorJuego(int i, int x) {

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
		lista1.add("" + fila + " --> " + columna);

		for (int i = 1; i < 4; i++) {

			// hacia abajo
			if (contA && posCorrecta(fila + i, columna)) {
				if ((tablero[fila + i][columna]).equals(tablero[fila][columna])) {
					vcontArriba++;
					int f = fila + i;
					lista1.add("" + f + " --> " + columna);
				} else {
					contA = false;
				}
			}

			// hacia arriba
			if (contB && posCorrecta(fila - i, columna)) {
				if ((tablero[fila - i][columna]).equals(tablero[fila][columna])) {
					vcontAbajo++;
					int f = fila - i;
					lista1.add("" + f + " --> " + columna);

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
		lista1.add("" + fila + " --> " + columna);

		for (int i = 1; i < 4; i++) {

			if (contaA && posCorrecta(fila, columna + i)) {
				if ((tablero[fila][columna + i]).equals(tablero[fila][columna])) {
					vcontArriba++;
					int c = columna + i;
					lista1.add("" + fila + " --> " + c);

				} else {
					contaA = false;
				}
			}

			if (contB && posCorrecta(fila, columna - i)) {
				if (contB && (tablero[fila][columna - i]).equals(tablero[fila][columna])) {
					vcontAbajo++;
					int c = columna - i;
					lista1.add("" + fila + " --> " + c);
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

	public boolean buscarDiagonal1(int fila, int columna, int numFichas) {
		String color = tablero[fila][columna];
		// Diagonal
		int contArribaDer = 0;
		int contAbajoIzq = 0;

		// Para no contar de mas, una si y una no.
		boolean contA = true;
		boolean contB = true;

		boolean existe = false;
		ArrayList<String> lista1 = new ArrayList<String>();
		lista1.add("" + fila + " --> " + columna);

		// hacia arriba
		for (int i = 1; i < 4; i++) {

			// hacia abajo izquierda
			if (contA && posCorrecta(fila + i, columna - i)) {
				if ((tablero[fila + i][columna - i]).equals(color)) {
					contAbajoIzq++;
					int f = fila + i;
					int c = columna - i;
					lista1.add("" + f + " --> " + c);

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
					lista1.add("" + f + " --> " + c);
				} else {
					contB = false;
				}
			}

			if (contArribaDer + contAbajoIzq >= numFichas - 1) {
				existe = true;
				ganadores = lista1;
				break;
			}
		}
		return existe;
	}

	public boolean buscarDiagonal2(int fila, int columna, int numFichas) {
		String color = tablero[fila][columna];

		int contAbajoDer = 0;
		int contArribaIzq = 0;

		// Para no contar de mas, una si y una no.

		boolean contC = true;
		boolean contD = true;

		boolean existe = false;
		ArrayList<String> lista1 = new ArrayList<String>();
		lista1.add("" + fila + " --> " + columna);

		// hacia arriba
		for (int i = 1; i < 4; i++) {

			// hacia abajo derecha
			if (contC && posCorrecta(fila + i, columna + i)) {
				if ((tablero[fila + i][columna + i]).equals(color)) {
					contAbajoDer++;
					int f = fila + i;
					int c = columna + i;
					lista1.add("" + f + " --> " + c);
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
					lista1.add("" + f + " --> " + c);
				} else {
					contD = false;
				}
			}

			if (contAbajoDer + contArribaIzq >= numFichas - 1) {
				existe = true;
				ganadores = lista1;
				break;
			}
		}
		return existe;
	}
	
	public int valorCasillaIA(int pCol) 
	{
		int puntuacion = 0;
		int fila = 0;
		boolean salir = false;
		while (fila < tablero.length && !salir) 
		{
			if (tablero[fila][pCol].equals("-")) 
			{
				fila++;
			}
			else 
			{
				salir = true;
			}
		}
		if (fila != 0) 
		{
			puntuacion+= recorrerDireccionValor(fila-1, pCol,  1,  0);//Recorre la vertical hacia abajo
			puntuacion+= recorrerDireccionValor(fila-1, pCol,  0,  1);//Recorre la Horizontal hacia la derecha
			puntuacion+= recorrerDireccionValor(fila-1, pCol,  0, -1);//Recorre la Horizontal hacia la izquierda
			puntuacion+= recorrerDireccionValor(fila-1, pCol,  1,  1);//Recorre la Diagonal abajo derecha
			puntuacion+= recorrerDireccionValor(fila-1, pCol,  1, -1);//Recorre la Diagonal abajo izquierda
			puntuacion+= recorrerDireccionValor(fila-1, pCol, -1,  1);//Recorre la Diagonal arriba derecha
			puntuacion+= recorrerDireccionValor(fila-1, pCol, -1, -1);//Recorre la Diagonal arriba izquierda
		}
		else
		{
			puntuacion = -1;
		}
		return puntuacion;
	} 
	
	private int recorrerDireccionValor(int pFila, int pCol, int pDirFila, int pDirCol) 
	{
		//En funcion de los valores de pDirFila y pDirColumna recorrera una direccion diferente
		//Los valores de las puntuaciones de los movimientos se pueden modificar si nos conviene
		int puntGanar = 10000;
		int puntEvitarVictoria = 9000;
		int puntTresEnLinea = 10;
		int puntDosEnLinea = 5;		
		//Terminan los valores de puntuacion
		
		int valor = 0;
		int filaAux = pFila+pDirFila;
		int columnaAux = pCol+pDirCol;
		int i = 0;
		String jugador="";
		boolean salir = false;
		while (posCorrecta(filaAux, columnaAux) && i < 3 && !salir)
		{	
			if (i == 0 && !tablero[filaAux][columnaAux].equals("-")) 
			{	
				jugador = tablero[filaAux][columnaAux];
				
			}			
			if (posCorrecta(filaAux,columnaAux)&&!jugador.equals(tablero[filaAux][columnaAux]))
			{
				salir = true;
			}
			
			if(!salir)
			{
				i++;
			}
			filaAux = filaAux+pDirFila;
			columnaAux = columnaAux+pDirCol;
		}
		
		if (jugador.equals("r")) 
		{
			if (i == 1) 
			{
				valor += puntDosEnLinea*1.25;
			}
			else if (i==2) 
			{
				valor += puntTresEnLinea*1.25;
			}
			else if (i == 3) 
			{
				valor += puntGanar;
			}
		}
		else if (jugador.equals("a")) 
		{
			if (i == 1) 
			{
				valor += puntDosEnLinea;
			}
			else if (i==2) 
			{
				valor += puntTresEnLinea;
			}
			else if (i == 3) 
			{
				valor += puntEvitarVictoria;
			}
		}
		System.out.println("Columna = "+ pCol + " Contiunas = "+ Integer.toString(i)+ " Jugador = "+ jugador + " Puntuacion = " +Integer.toString(valor));
		return valor;
	}

	public boolean buscarGanadorVertical(int fila, int columna) {

		return buscarVertical(fila, columna, 4);
	}

	public boolean buscarGanadorHorizontal(int fila, int columna) {

		return buscarHorizontal(fila, columna, 4);

	}

	public boolean buscarGanadorDiagonal(int fila, int columna) {
		boolean enc = false;
		enc = buscarDiagonal1(fila, columna, 4);
		if (!enc) {
			enc = buscarDiagonal2(fila, columna, 4);
		}
		return enc;
	}

	private Boolean posCorrecta(int i, int j) {
		if (i < tablero.length && j < tablero[0].length && i >= 0 & j >= 0)
			return true;
		else
			return false;

	}

	public int getFilas() {
		// TODO Auto-generated method stub
		return tablero.length;
	}

	public int getColumnas() {
		// TODO Auto-generated method stub
		return tablero[0].length;
	}

	public void setInterfaz(Iu_Partida interfaz2) {
		// TODO Auto-generated method stub
		interfaz = interfaz2;
	}

	public void eliminarInterfaz() {
		// TODO Auto-generated method stub
		interfaz.dispose();
	}

	public Iu_Partida getInterfaz() {
		return interfaz;
	}

	public void setForma(boolean f) {
		forma = f;
	}

	public boolean getForma() {
		return forma;
	}

	public void setj1(String f) {
		jugador1 = f;
	}

	public void setj2(String f) {
		jugador2 = f;
	}
	public String getNombreUsuario() {
		return this.interfaz.getNombreJugador1();
	}
	public int getTiempoUsuario() {
		return this.interfaz.getPuntuacionJugador1();
	}
	public String getDificultad() {
		return this.dificultad;
	}

	public String getJugador1() {
		// TODO Auto-generated method stub
		return jugador1;
	}
}
