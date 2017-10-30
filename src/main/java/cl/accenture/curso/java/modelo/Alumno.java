package cl.accenture.curso.java.modelo;


public class Alumno {

	
	private int id;
	private String nombre;
	private String apellido;
	private String apellidoMaterno;
	private int edad;
	/**
	 * 
	 */
	public Alumno() {
	}
	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param apellidoMaterno
	 * @param edad
	 */
	public Alumno(int id, String nombre, String apellido, String apellidoMaterno, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
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
	 * @param id the id to set
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
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	/**
	 * @param apellidoMaterno the apellidoMaterno to set
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
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Alumno ){
			
			Alumno alumno = (Alumno)obj;
			return alumno.getId() == this.id;
			
		}
		return false;
	}
	
	@Override
	public String toString() {
	 StringBuilder builder = new StringBuilder();
	 builder.append("Id Alumno "+this.id+"/");
	 builder.append("Nombre "+this.nombre+"/");
	 builder.append("Apellido "+this.apellido+"/");
	 builder.append("Apellido Materno "+this.apellidoMaterno+"/");
	 builder.append("Edad "+this.edad);
		return builder.toString();
	}
}
