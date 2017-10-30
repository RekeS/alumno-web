/**
 * 
 */
package cl.accenture.curso_java.alumno.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cl.accenture.curso_java.alumno.dao.AlumnoDAO;
import cl.accenture.curso_java.alumno.modelo.Alumno;
import cl.accenture.curso_java.alumno.modelo.SinConexionException;

/**
 * @author jmaldonado
 *
 */
@ManagedBean
@SessionScoped
public class ListaAlumnoControlador implements Serializable {

	private static final long serialVersionUID = -4122898785805951524L;
	
	private List<Alumno> alumnos;
	
	public ListaAlumnoControlador() {
		obtenerAlumnosDB();
	}
	
	/**
	 * 
	 */
	public void obtenerAlumnosDB(){
		AlumnoDAO dao = new AlumnoDAO();
		try {
			this.alumnos = dao.obtenerAlumnos();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SinConexionException e) {
			e.printStackTrace();
		}
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	/**
	 * 
	 */
	public void ordenar(){
		Collections.sort(this.alumnos, new Comparator<Alumno>() {

			public int compare(Alumno o1, Alumno o2) {
				return o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase());
			}
		});
	}
	
	

}
