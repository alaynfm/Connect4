package partida;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tablero x= new Tablero(9,9);
		//x.imprimirTablero();
		
		x.colocarFicha(0, "R");
		x.colocarFicha(1, "R");
		x.colocarFicha(1, "R");
		x.colocarFicha(2, "R");
		x.colocarFicha(2, "R");
		x.colocarFicha(2, "R");
		x.colocarFicha(3, "A");
		x.colocarFicha(3, "A");
		x.colocarFicha(3, "A");
		x.colocarFicha(3, "R");
		x.colocarFicha(4, "R");

	
		System.out.println("Hay victoria: "+ x.hayGanador());
		//x.colocarFicha(0, "A");
		System.out.println(x.sePuedeColocar(0));
		x.imprimirTablero();
	}
	
}