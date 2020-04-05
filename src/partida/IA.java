package partida;

public class IA {

	
	public double obtenerColumnaAleatoria(double min, double max){
	    return (Math.random()*((max-min)+1))+min;
	}
}
