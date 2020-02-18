package partida;
public class Jugador {
	private String nombre;
	private String color;
	
	public Jugador(String pNombre, String pColor) {
		this.nombre=pNombre;
		this.color=pColor;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getColor() {
		return this.color;
	}
}
