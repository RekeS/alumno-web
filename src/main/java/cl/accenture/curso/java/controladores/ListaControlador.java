/**
 * 
 */
package cl.accenture.curso.java.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
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
@ManagedBean(name = "listaAlumnoCtrl")
@RequestScoped
public class ListaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3323529899840117723L;

	private List<Alumno> alumnos;
	
	public ListaControlador() {
		obtenerAlumnosBD();
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
	
	public void obtenerAlumnosBD(){
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
	
	public void ordenar(){
		Collections.sort(this.alumnos, new Comparator<Alumno>() {
			public int compare(Alumno o1, Alumno o2) {
				// TODO Auto-generated method stub
				
				
				return o1.getNombre().compareTo(o2.getNombre());
			}
		});
	}
}
