package partida;

import interfaz.Iu_Partida;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Iu_Partida.miPartida().crearTablero(9, 15);
		Iu_Partida.miPartida().setVisible(true);
		
//		while(!Tablero.getMiTablero().hayGanador()) {
//			int x = Iu_Partida.miPartida().getCambio();
//			if(x != -1) {
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				Iu_Partida.miPartida().pintarTablero();
//			}
//		}
	}
	
}