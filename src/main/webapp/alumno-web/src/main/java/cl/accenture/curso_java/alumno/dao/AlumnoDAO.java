package cl.accenture.curso_java.alumno.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.alumno.modelo.Alumno;
import cl.accenture.curso_java.alumno.modelo.Conexion;
import cl.accenture.curso_java.alumno.modelo.SinConexionException;

/**
 * @author Administrador
 *
 */
public class AlumnoDAO {
	
	private Conexion conexion;
	
	public AlumnoDAO(){
		this.conexion = new Conexion();
	}
	
	public AlumnoDAO(Conexion conexion){
		this.conexion = conexion;
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	
	public void insertarAlumno( Alumno alumno) throws SQLException, SinConexionException{
		Statement statement = conexion.obtenerConexion().createStatement();
		statement.executeUpdate( "insert into alumnos(idalumno, nombre, apellido, apellidoMaterno,edad) "
				+ "values ( "+alumno.getId()+" , '"+alumno.getNombre()+"', '"+alumno.getApellido()+"', '"+alumno.getApellidoMaterno()+"', "+alumno.getEdad()+" );" );
	}
	
	/**
	 * 
	 * @return
	 * @throws SinConexionException 
	 * @throws SQLException 
	 */
	public List<Alumno> obtenerAlumnos() throws SQLException, SinConexionException{
		List<Alumno> alumnos = new ArrayList<Alumno>();
		Statement statement = conexion.obtenerConexion().createStatement();
		ResultSet rs = statement.executeQuery( "select * from alumnos" );
		while( rs.next() ) {
			Alumno alumno = new Alumno();
			alumno.setId( rs.getInt( "idalumno") );
			alumno.setNombre( rs.getString( "nombre" ) );
			alumno.setApellido( rs.getString( "apellido" ) );
			alumno.setApellidoMaterno( rs.getString( "apellidoMaterno" ) );
			alumno.setEdad( rs.getInt( "edad" ) );
			alumnos.add(alumno);
		}
		return alumnos;
	}
	
	
	
}