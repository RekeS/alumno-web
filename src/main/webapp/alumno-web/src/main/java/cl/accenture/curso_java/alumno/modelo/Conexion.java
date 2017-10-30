package cl.accenture.curso_java.alumno.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Administrador
 *
 */
public class Conexion {

	private String host;
	private int puerto;
	private String baseDeDatos;
	private String nombre;
	private String password;
	
	public Conexion() {
		this.host = "localhost"; //127.0.0.1
		this.puerto = 3306;
		this.baseDeDatos = "curso";
		this.nombre = "jmaldonado";
		this.password = "java123";	
	}

	public Conexion(String host, int puerto, String baseDeDatos, String nombre, String password) {
		super();
		this.host = host;
		this.puerto = puerto;
		this.baseDeDatos = baseDeDatos;
		this.nombre = nombre;
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public String getBaseDeDatos() {
		return baseDeDatos;
	}

	public void setBaseDeDatos(String baseDeDatos) {
		this.baseDeDatos = baseDeDatos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Obtiene la conexion de la base de datos.
	 * @return
	 * @throws SinConexionException 
	 */
	public Connection obtenerConexion() throws SinConexionException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.
					getConnection(
	"jdbc:mysql://" + this.host+ ":" + 
	this.puerto + "/" + this.baseDeDatos, this.nombre, this.password);
			return conexion;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SinConexionException( "No se ha podido realizar "
					+ "la conexion hacia la base de datos " + e.getMessage() );
		}
	}
	
}