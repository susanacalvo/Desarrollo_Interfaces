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
	 * M�todo que devuelve la Denominaci�n de la carrera
	 * @return denominacion
	 */
	public String getDenominacion() {
		return denominacion;
	}
	
	/**
	 * M�todo que establece una Denominaci�n
	 * @param denominacion
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	/**
	 * M�todo que devuelve los metros de la carrera
	 * @return metros
	 */
	public double getMetros() {
		return metros;
	}
	
	/**
	 * M�todo que establece los metros de la carrera
	 * @param metros
	 */
	public void setMetros(double metros) {
		this.metros = metros;
	}
	
	/**
	 * M�todo que devuelve una Fecha
	 * @return fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	
	/**
	 * M�todo que establece una Fecha
	 * @param fecha
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * M�todo que devuelve el lugar de la carrera
	 * @return lugar
	 */
	public String getLugar() {
		return lugar;
	}
	
	/**
	 * M�todo que establece un lugar a la carrera
	 * @param lugar
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	/**
	 * M�todo que devuelve si se ha realizado o no
	 * @return realizado
	 */
	public boolean isRealizado() {
		return realizado;
	}
	
	/**
	 * M�todo que establece si se ha realizado o no
	 * @param realizado
	 */
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
	
	/**
	 * M�todo que devuelve una cadena de informaci�n de la clase Carrera
	 * @return
	 */
	@Override
	public String toString() {
		return  metros + " " + denominacion;
	}
	
	
	
	
}
