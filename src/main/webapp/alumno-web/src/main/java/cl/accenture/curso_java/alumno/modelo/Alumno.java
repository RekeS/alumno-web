package cl.accenture.curso_java.alumno.modelo;
public class Alumno {

	private int id;
	private String nombre;
	private String apellido;
	private String apellidoMaterno;
	private int edad;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public Alumno(int id, String nombre, String apellido, String apellidoMaterno, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.apellidoMaterno = apellidoMaterno;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Alumno ){
			Alumno alumno = (Alumno)obj;
			return this.id == alumno.getId();
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nid:"+ id);
		builder.append("\nnombre:"+nombre);
		builder.append("\napellido:"+apellido);
		builder.append("\napellidoMaterno:"+apellidoMaterno);
		builder.append("\nedad:"+edad);
		return builder.toString();
	}
}