package partida;

public abstract class IA {

	public abstract void jugar();
	
	public double obtenerColumnaAleatoria(double min, double max){
	    return (Math.random()*((max-min)+1))+min;
	}
}
