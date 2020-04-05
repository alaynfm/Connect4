package partida;

import java.util.Observable;

public class Cambio extends Observable{
	
	private boolean cambiado;
	private static Cambio c = new Cambio();
	
	private Cambio() {
		cambiado = false;
	}
	
	public static Cambio getcambio () {return c;}
	
	public void setCambio(boolean cambio) {
		if(cambio) {
			setChanged();
			notifyObservers();
		}
	}
	
	

}
