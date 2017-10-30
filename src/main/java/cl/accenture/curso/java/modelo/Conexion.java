/**
 * 
 */
package cl.accenture.curso.java.modelo;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author Usuario
 *
 */
public class Conexion {

	private String host;
	private int puerto;
	private String baseDeDatos;
	private String usuario;
	private String password;

	/**
	 * @param host
	 * @param puerto
	 * @param baseDeDatos
	 * @param usuario
	 */
	public Conexion() {
		this.host = "127.0.0.1";
		this.puerto = 3306;
		this.baseDeDatos = "Curso";
		this.usuario = "Juan";
		this.password = "papelucho1";
	}

	/**
	 * @param host
	 * @param puerto
	 * @param baseDeDatos
	 * @param usuario
	 * @param password
	 */
	public Conexion(String host, int puerto, String baseDeDatos, String usuario, String password) {
		this.host = host;
		this.puerto = puerto;
		this.baseDeDatos = baseDeDatos;
		this.usuario = usuario;
		this.password = password;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the puerto
	 */
	public int getPuerto() {
		return puerto;
	}

	/**
	 * @param puerto
	 *            the puerto to set
	 */
	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	/**
	 * @return the baseDeDatos
	 */
	public String getBaseDeDatos() {
		return baseDeDatos;
	}

	/**
	 * @param baseDeDatos
	 *            the baseDeDatos to set
	 */
	public void setBaseDeDatos(String baseDeDatos) {
		this.baseDeDatos = baseDeDatos;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Connection obtenerConexion() throws SinConexionException  {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.puerto + "/" + this.baseDeDatos,
					this.usuario, this.password);
			return conexion;
		
		} catch (Exception e) {

			throw new SinConexionException ("No se ha podido conectar "+e.getMessage());
		} 

		
	}

}
