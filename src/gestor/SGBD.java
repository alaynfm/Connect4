package gestor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SGBD {
	private static SGBD mSGBD;
	
	private SGBD() {}
	
	public static SGBD getSGBD() {
		if (mSGBD == null) {
			mSGBD = new SGBD();
		}
		return mSGBD;
	}
	
	public Connection realizarConexion() throws SQLException{
		Connection conn = DriverManager.getConnection("url", "usuario", "contrasena");
		return conn;
	}
	
	public ResultSet realizarConsulta(Connection conn, String consulta) throws SQLException {
		ResultSet rs = conn.createStatement().executeQuery(consulta);
		return rs;
	}
	
	public void realizarUpdate(Connection conn, String update) throws SQLException {
		conn.createStatement().executeUpdate(update);
	}
}
