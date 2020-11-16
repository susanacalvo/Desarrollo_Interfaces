package datos;

import java.io.Serializable;
/**
 * Clase Persona
 * @author Susana
 *
 */
public class Persona implements Serializable{
	/**
	 * Atributos de la clase
	 */
	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private double altura;
	
	/**
	 * Constructor de la clase Persona
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 * @param altura
	 */
	public Persona(String dni, String nombre, String apellidos, int edad, double altura) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.altura = altura;
	}
	
	/**
	 * M�todo que devuelve el Dni
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * M�todo que establece un dni
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * M�todo que devuelve el Nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * M�todo que establece un Nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * M�todo que devuelve el Apellido
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * M�todo que establece un Apellido
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * M�todo que devuelve la Edad
	 * @return edad
	 */
	public int getEdad() {
		return edad;
	}
	
	/**
	 * M�todo que establece una Edad
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/**
	 * M�todo que devuelve la Altura
	 * @return altura
	 */
	public double getAltura() {
		return altura;
	}
	
	/**
	 * M�todo que establece una Altura
	 * @param altura
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	/**
	 * M�todo que devuelve una cadena de informaci�n de la clase Persona
	 * @return
	 */
	@Override
	public String toString() {
		return "Dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", altura=" + altura;
	}
	
	
	
	
}
