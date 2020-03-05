package gestor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SGBD {
	private static SGBD mSGBD;
	private Connection conn;
	
	private SGBD() {}
	
	public static SGBD getSGBD() {
		if (mSGBD == null) {
			mSGBD = new SGBD();
		}
		return mSGBD;
	}
	
	public Connection realizarConexion() throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306", "sql7323314", "5sgebAHRDr");
		this.conn = conn;
		return conn;
	}
	
	public ResultSet realizarConsulta(String consulta) throws SQLException {
		ResultSet rs = this.conn.createStatement().executeQuery(consulta);
		return rs;
	}
	
	public void realizarUpdate(String update) throws SQLException {
		this.conn.createStatement().executeUpdate(update);
	}
}
