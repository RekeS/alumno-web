/**
 * 
 */
package cl.accenture.curso.java.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cl.accenture.curso.java.dao.AlumnoDAO;
import cl.accenture.curso.java.modelo.Alumno;
import cl.accenture.curso.java.modelo.SinConexionException;

/**
 * @author Usuario
 *
 */
@ManagedBean
@RequestScoped
public class AlumnoControlador implements Serializable {

	/**
	 * 
	1 */
	private static final long serialVersionUID = -5581660955398946276L;

	private int id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private int edad;
	private List<Alumno> alumnos;

	/**
	 * 
	 */
	public AlumnoControlador() {
		this.id = 0;
		this.nombre = "";
		this.apellidoPaterno = "";
		this.apellidoMaterno = "";
		this.edad = 0;
		this.alumnos = new ArrayList<Alumno>();
		

	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellidoPaterno
	 * @param apellidoMaterno
	 * @param edad
	 */
	public AlumnoControlador(int id, String nombre, String apellidoPaterno, String apellidoMaterno, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.edad = edad;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno
	 *            the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno
	 *            the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad
	 *            the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	

	/**
	 * @return the alumnos
	 */
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	/**
	 * @param alumnos the alumnos to set
	 */
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void guardar() {
		Alumno alumno = new Alumno(this.id, this.nombre, this.apellidoPaterno, this.apellidoMaterno, this.edad);
		AlumnoDAO  dao = new AlumnoDAO();
		try {
			dao.insertarAlumno(alumno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void limpiar() {
		
		this.id = 0;
		this.nombre = "";
		this.apellidoPaterno = "";
		this.apellidoMaterno = "";
		this.edad = 0;
	}
	
	
	public void lista(){
		
		AlumnoDAO dao = new AlumnoDAO();
		try {
			this.alumnos=dao.listarAlumnos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
