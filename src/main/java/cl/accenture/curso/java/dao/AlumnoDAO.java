/**
 * 
 */
package cl.accenture.curso.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cl.accenture.curso.java.modelo.Alumno;
import cl.accenture.curso.java.modelo.Conexion;
import cl.accenture.curso.java.modelo.SinConexionException;

/**
 * @author Usuario
 *
 */
public class AlumnoDAO {

	private Conexion conexion;

	/**
	 * 
	 */
	public AlumnoDAO() {

		this.conexion = new Conexion();
	}

	/**
	 * @param conexion
	 */
	public AlumnoDAO(Conexion conexion) {
		this.conexion = conexion;
	}

	/**
	 * @return the conexion
	 */
	public Conexion getConexion() {
		return conexion;
	}

	/**
	 * @param conexion
	 *            the conexion to set
	 */
	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public void insertarAlumno(Alumno alumno) throws SQLException, SinConexionException {

		Statement st = conexion.obtenerConexion().createStatement();
		st.executeUpdate("INSERT INTO Alumnos(idAlumnoss,nombre,apellido,apellidoMaterno,edad) " + "VALUES("
				+ alumno.getId() + ",'" + alumno.getNombre() + "','" + alumno.getApellido() + "','"
				+ alumno.getApellidoMaterno() + "'," + alumno.getEdad() + ");");

	}

	public List<Alumno> listarAlumnos() throws SQLException, SinConexionException {

		List<Alumno> alumnos = new ArrayList<Alumno>();
		Statement st = conexion.obtenerConexion().createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM alumnos");

		while (rs.next()) {

			alumnos.add(new Alumno(rs.getInt("idAlumnoss"), rs.getString("nombre"), rs.getString("apellido"),
					rs.getString("apellidoMaterno"), rs.getInt("edad")));

		}

		return alumnos;
	}

}
