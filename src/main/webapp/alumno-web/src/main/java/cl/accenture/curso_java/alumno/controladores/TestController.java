/**
 * 
 */
package cl.accenture.curso_java.alumno.controladores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * @author jmaldonado
 *
 */
@ManagedBean
@SessionScoped
public class TestController {
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
