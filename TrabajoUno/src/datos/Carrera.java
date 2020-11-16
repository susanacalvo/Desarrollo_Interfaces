package datos;

import java.time.LocalDate;

public class Carrera {
	private String denominacion;
	private double metros;
	private LocalDate fecha;
	private String lugar;
	private boolean realizado;
	
	public Carrera(String denominacion, double metros, LocalDate fecha, String lugar, boolean realizado) {
		super();
		this.denominacion = denominacion;
		this.metros = metros;
		this.fecha = fecha;
		this.lugar = lugar;
		this.realizado = realizado;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public double getMetros() {
		return metros;
	}
	public void setMetros(double metros) {
		this.metros = metros;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public boolean isRealizado() {
		return realizado;
	}
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
	@Override
	public String toString() {
		return "Denominacion=" + denominacion + ", metros=" + metros + ", fecha=" + fecha + ", lugar=" + lugar;
	}
	
	
	
	
}
