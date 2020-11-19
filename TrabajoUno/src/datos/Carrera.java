package datos;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * Clase Carrera
 * @author Susana
 *
 */
public class Carrera implements Serializable{
	/**
	 * Atributos de la clase
	 */
	private static final long serialVersionUID = 1L;
	private String denominacion;
	private double metros;
	private LocalDate fecha;
	private String lugar;
	private boolean realizado;
	
	/**
	 * Constructor de la clase Carrera
	 * @param denominacion
	 * @param metros
	 * @param fecha
	 * @param lugar
	 * @param realizado
	 */
	public Carrera(String denominacion, double metros, LocalDate fecha, String lugar, boolean realizado) {
		super();
		this.denominacion = denominacion;
		this.metros = metros;
		this.fecha = fecha;
		this.lugar = lugar;
		this.realizado = realizado;
	}
	
	/**
	 * Método que devuelve la Denominación de la carrera
	 * @return denominacion
	 */
	public String getDenominacion() {
		return denominacion;
	}
	
	/**
	 * Método que establece una Denominación
	 * @param denominacion
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	/**
	 * Método que devuelve los metros de la carrera
	 * @return metros
	 */
	public double getMetros() {
		return metros;
	}
	
	/**
	 * Método que establece los metros de la carrera
	 * @param metros
	 */
	public void setMetros(double metros) {
		this.metros = metros;
	}
	
	/**
	 * Método que devuelve una Fecha
	 * @return fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	
	/**
	 * Método que establece una Fecha
	 * @param fecha
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Método que devuelve el lugar de la carrera
	 * @return lugar
	 */
	public String getLugar() {
		return lugar;
	}
	
	/**
	 * Método que establece un lugar a la carrera
	 * @param lugar
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	/**
	 * Método que devuelve si se ha realizado o no
	 * @return realizado
	 */
	public boolean isRealizado() {
		return realizado;
	}
	
	/**
	 * Método que establece si se ha realizado o no
	 * @param realizado
	 */
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
	
	/**
	 * Método que devuelve una cadena de información de la clase Carrera
	 * @return
	 */
	@Override
	public String toString() {
		return  metros + " " + denominacion;
	}
	
	
	
	
}
