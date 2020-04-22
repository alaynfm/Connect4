package gestor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import partida.*;

public class GestorUsuarios {

	private static GestorUsuarios mGestorUsuarios;
	private Jugador jugador;
	
	private GestorUsuarios() {}
	
	public static GestorUsuarios getGestorUsuarios() {
		if (mGestorUsuarios == null) {
			mGestorUsuarios = new GestorUsuarios();
		}
		return mGestorUsuarios;
	}
	/* no sirve en principio (BORRAR SI FINALMENTE NO SIRVE)
	public void iniciarSesion(String usuario, String contrasena) {
		try {
			String consulta = "SELECT contrasena FROM usuarios WHERE usuario = '" + usuario+"'";
			ResultSet rs = SGBD.getSGBD().realizarConsulta(consulta);
			rs.next();
			String contrasenaPosible = rs.getString(1);
			
			if (contrasenaPosible.equals(contrasena)) {
				System.out.println("Sesion iniciada");
				this.jugador = new Jugador(usuario, "rojo");
			} else {
				System.out.println("Contrasena incorrecta");
			}
		} catch (SQLException e) {
			System.out.println("Error al iniciar la sesion");
			System.out.println(e.getMessage());
		}
	}
	
	public void registrarse(String usuario, String contrasena) {
		try {
			String update = "INSERT INTO usuarios (usuario, contrasena) VALUES ('" + usuario + "', '" + contrasena + "')";
			SGBD.getSGBD().realizarUpdate(update);
			update = "INSERT INTO ranking (usuario, puntuacion, numpartidas) VALUES ('" + usuario + "', 0, 0)";
			SGBD.getSGBD().realizarUpdate(update);
		} catch (SQLException e) {
			System.out.println("Error al registrarte");
			System.out.println(e.getMessage());
		}
	}
	
	*/
	public void partidaGanada(String usuario, int tiempo, String dificultad) { //dificultad tiene que ser exactamente Facil o Dificil
		//Guarda una partida en el highscore (se comprueba en este metodo si es su mejor partida o no)
		try {
			String consulta = "SELECT tiempo FROM ranking"+dificultad+" WHERE nombre = '" + usuario+"'";
			ResultSet rs = SGBD.getSGBD().realizarConsulta(consulta);
			if (rs.next()) { //hay puntuacion
				int mejorTiempo = rs.getInt("tiempo");
				if (tiempo < mejorTiempo) {
					consulta = "UPDATE ranking"+dificultad+" SET tiempo = " + tiempo + " WHERE nombre = '" + usuario+"'";
					SGBD.getSGBD().realizarUpdate(consulta);
				}
			}
			else { //nunca ha jugado
				guardarPartida(usuario,tiempo,dificultad);
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar o actualizar datos");
			e.printStackTrace();
		}
		
	}
	public void guardarPartida(String usuario, int tiempo, String dificultad) { //Guarda la partida en la base de datos (no comprueba nada)
		String sentencia = "INSERT INTO ranking"+dificultad+" (nombre, tiempo) VALUES ('" + usuario + "',"+tiempo+")";
		try {
			SGBD.getSGBD().realizarUpdate(sentencia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String[][] obtener10Mejores(String dificultad) { //dificultad tiene que ser exactamente Facil o Dificil
		//Obtiene una matriz con los 10 mejores en funcion de la dificultad
		String consulta = "SELECT * FROM ranking"+dificultad+" ORDER BY tiempo ASC LIMIT 10";
		String[][] tabla= new String[2][10];
		try {
			ResultSet rs = SGBD.getSGBD().realizarConsulta(consulta);
			int i=0;
			while (rs.next()) {
				String nombre= rs.getString("nombre");
				int tiempo= rs.getInt("tiempo");
				String [] row= {nombre,String.valueOf(tiempo)};
				tabla[0][i]=nombre;
				tabla[1][i]=String.valueOf(tiempo);
				i++;
			}
		} catch (SQLException e) {
			System.out.println("No hay ranking");
			e.printStackTrace();
		}
		return tabla;
	}
	public int obtenerTuPosicionRelativa(int tiempo) {
		String consulta = "SELECT numero FROM rankingTotal WHERE tiempo>"+tiempo+" LIMIT 1";
		try {
		ResultSet rs = SGBD.getSGBD().realizarConsulta(consulta);
		rs.next();
		return rs.getInt("numero");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int obtenerTuPosicion(String nombre) {
		String consulta = "SELECT numero FROM rankingTotal WHERE nombre='"+nombre+"' LIMIT 1";
		try {
		ResultSet rs = SGBD.getSGBD().realizarConsulta(consulta);
		rs.next();
		return rs.getInt("numero");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}