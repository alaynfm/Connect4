package partida;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ListaCasilla {

	private HashMap<String, Integer> lista;
	public ListaCasilla() {
		lista = new HashMap<String,Integer >();
	}
	
	
	public void anadirCasilla(String cod, int columna) {
		lista.put(cod, columna);
	}

	public void eliminarCasillla(String cod) {
		if (!lista.isEmpty()) {
			lista.remove(cod);
		}
	}

	public int getCasillaAleatoria() {
		
		Collection<Integer> values = lista.values();
		Integer[] targetArray = values.toArray(new Integer[values.size()]);
		int columna = ThreadLocalRandom.current().nextInt(0,targetArray.length-1);
		return targetArray[columna];
	}

	public int size() {
		return lista.size();
	}
	
	public boolean estaCasilla(String cod) {
		Boolean esta = false;
		if (lista.containsKey(cod)) {esta = true;}
		return esta;
	}
}