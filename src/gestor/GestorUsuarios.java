package gestor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorUsuarios {

	private static GestorUsuarios mGestorUsuarios;
	
	private GestorUsuarios() {}
	
	public static GestorUsuarios getGestorUsuarios() {
		if (mGestorUsuarios == null) {
			mGestorUsuarios = new GestorUsuarios();
		}
		return mGestorUsuarios;
	}
	
	public void iniciarSesion(String usuario, String contrasena) {
		try {
			String consulta = "SELECT contrasena FROM usuarios WHERE usuario = " + usuario;
			ResultSet rs = SGBD.getSGBD().realizarConsulta(consulta);
			String contrasenaPosible = rs.getString(1);
			
			if (contrasenaPosible == contrasena) {
				System.out.println("Sesion iniciada");
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
			String update = "INSERT INTO usuarios (usuario, contrasena) VALUES (" + usuario + ", " + contrasena + ")";
			SGBD.getSGBD().realizarUpdate(update);
			update = "INSERT INTO ranking (usuario, puntuacion, numpartidas) VALUES (" + usuario + ", 0, 0)";
			SGBD.getSGBD().realizarUpdate(update);
		} catch (SQLException e) {
			System.out.println("Error al registrarte");
			System.out.println(e.getMessage());
		}
		
	}
	
	public void partidaGanada(int puntuacion, String usuario) {
		try {
			String consulta = "SELECT puntuacion, numpartidas FROM ranking WHERE usuario = " + usuario;
			ResultSet rs = SGBD.getSGBD().realizarConsulta(consulta);
			int mejorPuntuacion = rs.getInt("puntuacion");
			int numPartidas = rs.getInt("numpartidos");
			numPartidas++;
			if (puntuacion > mejorPuntuacion) {
				consulta = "UPDATE ranking SET puntuacion = " + puntuacion + ", numpartidas = " + numPartidas + " WHERE usuario = " + usuario;
			} else {
				consulta = "UPDATE ranking SET numpartidas = " + numPartidas + " WHERE usuario = " + usuario;
			}
			SGBD.getSGBD().realizarUpdate(consulta);
			
		} catch (SQLException e) {
			System.out.println("Error al buscar o actualizar datos");
			System.out.println(e.getMessage());
		}
	}
}